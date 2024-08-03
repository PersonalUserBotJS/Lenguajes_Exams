package com.example.demo.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dni")
    private String dni;

    private String nombre;

    private String apellido;

    private String telefono;

    @JsonIgnore
    @OneToMany(mappedBy = "codigoPrestamo", cascade = CascadeType.ALL)
    private List<Prestamos> prestamos;
}
