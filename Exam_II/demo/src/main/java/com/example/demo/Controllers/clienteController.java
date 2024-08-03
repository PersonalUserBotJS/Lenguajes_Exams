package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Cliente;
import com.example.demo.Services.clienteServicio;

@RestController
@RequestMapping("api/clientes")
public class clienteController {

    @Autowired
    private clienteServicio clienteService;

    @PostMapping("/{dni}")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        if (nuevoCliente == null) {
            throw new RuntimeException("Cliente ya existe.");
        }

        return nuevoCliente;
    }

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

}
