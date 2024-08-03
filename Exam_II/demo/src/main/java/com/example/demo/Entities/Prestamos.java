package com.example.demo.Entities;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "prestamos")

public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoPrestamo")
    private Long codigoPrestamo;

    private LocalDate fechaApertura;

    private Double monto;

    private Double cantidad;

    private Integer plazo;

    
    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "codigoCuota", cascade = CascadeType.ALL)
    private List<Cuotas> cuotas;
}
