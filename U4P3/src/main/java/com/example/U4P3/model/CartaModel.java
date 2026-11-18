package com.example.U4P3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Carta")
@Getter
@Setter
public class CartaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String valorMana;

    @Column
    private String supertipo;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String subtipo;

    @Column
    private String texto;

    @Column
    private String fuerza;

    @Column
    private String resistencia;
}
