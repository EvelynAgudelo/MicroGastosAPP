package com.example.NEOAPP.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NEOAPP.modelos.Categoria;

@Repository
public interface ICategoria extends JpaRepository <Categoria, Integer>{

}
