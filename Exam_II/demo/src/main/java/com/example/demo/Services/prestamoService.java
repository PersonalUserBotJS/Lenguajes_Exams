package com.example.demo.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.clienteRepository;
import com.example.demo.Repositories.cuotasRepository;
import com.example.demo.Repositories.prestamosRepository;
import com.example.demo.Entities.Cliente;
import com.example.demo.Entities.Cuotas;
import com.example.demo.Entities.Prestamos;

@Service
public class prestamoService {

    @Autowired
    private prestamosRepository prestamosRepository;

    @Autowired
    private clienteRepository clienteRepository;

    @Autowired
    private cuotasRepository cuotasRepository;

    private double calcularCuota(double monto, double cantidad, int plazo) {
        double i = 0.09 / 12;
        int n = plazo * 12;
        return monto * i / (1 - Math.pow(1 + i, n));
    }

    private List<Cuotas> generarTablaCuotas(Prestamos prestamo) {
        List<Cuotas> cuotas = new ArrayList<>();
        double saldo = prestamo.getMonto();
        double cuota = calcularCuota(prestamo.getMonto(), prestamo.getcantidad(), prestamo.getPlazo());

        for (int mes = 1; mes <= prestamo.getPlazo() * 12; mes++) {
            Cuotas cuotaobjeto = new Cuotas();
            cuotaobjeto.setMes(mes);
            cuotaobjeto.setPrestamo(prestamo);

            double interes = saldo * (prestamo.getcantidad() / 12);
            double capital = cuota - interes;
            saldo -= capital;

            cuotaobjeto.setInteres(interes);
            cuotaobjeto.setCapital(capital);
            cuotaobjeto.setSaldo(saldo);

            cuotas.add(cuotaobjeto);
        }

        return cuotas;
    }

    public Prestamos crearPrestamo(String dni, Prestamos prestamo) {
        Cliente cliente = clienteRepository.findByDni(dni);

        if (cliente != null) {
            prestamo.setCliente(cliente);
            prestamo.setFechaApertura(new Date());
            prestamo.setCuota(calcularCuota(prestamo.getMonto(), prestamo.getcantidad(), prestamo.getPlazo()));

            Prestamos nuevoPrestamo = prestamosRepository.save(prestamo);
            List<Cuotas> cuotas = generarTablaCuotas(nuevoPrestamo);
            cuotasRepository.saveAll(cuotas);
            return nuevoPrestamo;
        }
        return null;
    }

    public Prestamos obtenerPrestamoPorCodigo(Long codigoPrestamo) {
        return prestamosRepository.findById(codigoPrestamo);
    }
}

