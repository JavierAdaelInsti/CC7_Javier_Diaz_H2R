package com.example.H2R_Javier_Diaz_CC7.service;


import com.example.H2R_Javier_Diaz_CC7.controller.dto.PedidoDTO;
import com.example.H2R_Javier_Diaz_CC7.controller.dto.ProductoDTO;
import com.example.H2R_Javier_Diaz_CC7.exception.CustomException;
import com.example.H2R_Javier_Diaz_CC7.model.EstadoPedido;
import com.example.H2R_Javier_Diaz_CC7.model.Pedido;
import com.example.H2R_Javier_Diaz_CC7.model.Producto;
import com.example.H2R_Javier_Diaz_CC7.repository.PedidoRepository;
import com.example.H2R_Javier_Diaz_CC7.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MyService {
    private final ProductoRepository productoRepository;
    private final PedidoRepository pedidoRepository;

    public MyService(ProductoRepository productoRepository, PedidoRepository pedidoRepository) {
        this.productoRepository = productoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Producto buscarProducto(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new CustomException("El producto " + id + " no existe"));
    }

    public Pedido buscarPedido(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new CustomException("El pedido " + id + " no existe"));
    }

    public Producto registrarProducto(ProductoDTO payload) {
        Producto pr = new Producto();
        pr.setNombre(payload.getNombre());
        pr.setCategoria(payload.getCategoria());
        pr.setActivo(true);
        return productoRepository.save(pr);
    }

    @Transactional
    public Pedido crearPedido(PedidoDTO payload) {
        Producto producto = buscarProducto(payload.getIdproducto());
        if (producto.getActivo()) throw new CustomException("No activo");
        producto.setActivo(false);
        productoRepository.save(producto);
        Pedido pedido = new Pedido();
        pedido.setNombreCliente(payload.getNombreCliente());
        pedido.setCantidad(pedido.getCantidad());
        pedido.setPrecioUnitario(pedido.getPrecioUnitario());
        pedido.setTotal(pedido.getTotal());
        pedido.setEstado(EstadoPedido.PENDIENTE);
        pedido.setProducto(producto);
        return pedidoRepository.save(pedido);

    }

    public List<Producto> listaProducto() {
        return productoRepository.findAll();
    }

    public List<Producto> ListarActivos() {
        return productoRepository.findByActivoTrue();
    }

    @Transactional
    public Pedido cancelarPedido(Long id) {
        Pedido p = buscarPedido(id);
        if (p.getEstado() != EstadoPedido.PROCESADO) {
            throw new CustomException("Solo se puede cancelar si esta pendiente");
        }
        p.setEstado(EstadoPedido.CANCELADO);
        pedidoRepository.save(p);
        p.getProducto().setActivo(true);

    }
}




