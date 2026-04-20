package com.example.NEOAPP.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NEOAPP.modelos.Categoria;
import com.example.NEOAPP.servicios.CategoriaServicio;

@RestController
@RequestMapping("/microgastosapp/v1/categorias")
public class CategoriaControlador {
    @Autowired
    private CategoriaServicio CategServicio;

    @PostMapping
    public ResponseEntity<?>ControladorGuardar(@RequestBody Categoria Datos){
        return ResponseEntity.status(HttpStatus.OK).body(CategServicio.GuardarCategoria(Datos));
    }

    @GetMapping
    public ResponseEntity<?>ControladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(CategServicio.ListarCategoria());
    }
}
