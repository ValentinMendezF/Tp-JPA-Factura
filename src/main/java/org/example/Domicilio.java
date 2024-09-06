package org.example;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
@Getter
@Setter
@Builder
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_calle")
    private String nombreCalle;
    @Column(name = "numero")
    private int numero;
}
