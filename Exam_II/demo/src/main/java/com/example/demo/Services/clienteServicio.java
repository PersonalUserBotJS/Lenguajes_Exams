package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.clienteRepository;
import com.example.demo.Entities.Cliente;

@Service
public class clienteServicio {

    @Autowired
    private clienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByDni(cliente.getDni());

        if (clienteExistente != null) {
            return null;
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }


}
