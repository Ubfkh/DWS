package com.example.U4P3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Carta")
@Getter
@Setter
public class CartaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @Column (nullable = false)
    private Date fechaSalida;

    @Column (nullable = false)
    private boolean legalCommander;

    @Column (nullable = false)
    private String imgurl;
}
