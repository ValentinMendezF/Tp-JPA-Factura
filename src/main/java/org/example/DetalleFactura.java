package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "detalle_factura")
@Getter
@Setter
@Builder
public class DetalleFactura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "subtotal")
    private int subtotal;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
}
