package com.example.NEOAPP.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NEOAPP.modelos.Usuario;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer>{

}
