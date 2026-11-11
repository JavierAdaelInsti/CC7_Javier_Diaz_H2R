package com.example.H2R_Javier_Diaz_CC7.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "pedido")
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCliente;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
