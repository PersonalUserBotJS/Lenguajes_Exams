package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cuotas")
public class Cuotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoCuota")
    private Long codigoCuota;

    private Integer mes;

    private Double interes;

    private Double capital;

    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "codigoPrestamo")
    private Prestamos prestamo;

}
