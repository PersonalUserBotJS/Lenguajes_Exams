package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Prestamos;

@Repository
public interface prestamosRepository extends JpaRepository <Prestamos, Long>{

}
