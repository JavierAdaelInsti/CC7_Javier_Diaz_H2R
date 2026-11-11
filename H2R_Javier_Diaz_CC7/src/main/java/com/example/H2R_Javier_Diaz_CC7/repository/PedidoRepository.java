package com.example.H2R_Javier_Diaz_CC7.repository;

import com.example.H2R_Javier_Diaz_CC7.model.EstadoPedido;
import com.example.H2R_Javier_Diaz_CC7.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByEstado(EstadoPedido estado);
    List<Pedido> findByProductoIdAndEstado(Long productoId, EstadoPedido pedido);

}
