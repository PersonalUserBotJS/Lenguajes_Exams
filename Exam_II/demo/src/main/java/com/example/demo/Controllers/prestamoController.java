package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Prestamos;

@RestController
@RequestMapping("api/prestamos")
public class prestamoController {

    @Autowired
    private Prestamos prestamoService;

    @PostMapping("/{dni}")
    public Prestamos crearPrestamo(@PathVariable String dni, @RequestBody Prestamos prestamo) {
        Prestamos nuevoPrestamo = prestamoService.crearPrestamo(dni, prestamo);

        if (nuevoPrestamo == null) {
            throw new RuntimeException("No se pudo crear el préstamo.");
        }

        return nuevoPrestamo;
    }

    @GetMapping("/{codigoPrestamo}")
    public Prestamos obtenerPrestamoPorCodigo(@PathVariable Long codigoPrestamo) {
        Prestamos prestamo = prestamoService.obtenerPrestamoPorCodigo(codigoPrestamo);
        if (prestamo == null) {
            throw new RuntimeException("Préstamo no encontrado.");
        }
        return prestamo;
    }
}
