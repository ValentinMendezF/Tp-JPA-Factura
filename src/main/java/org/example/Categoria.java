package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "categorias")
@Getter
@Setter
@Builder
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "denominacion")
    private String denominacion;
}
