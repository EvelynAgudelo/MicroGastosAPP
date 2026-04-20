package com.example.NEOAPP.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NEOAPP.modelos.Comercio;
import com.example.NEOAPP.servicios.ComercioServicio;

@RestController
@RequestMapping("/microgastosapp/v1/comercios")
public class ComercioControlador {
    @Autowired
    private ComercioServicio ComercServicio;

    @PostMapping
    public ResponseEntity<?>controladorGuardar(@RequestBody Comercio Datos){
        return ResponseEntity.status(HttpStatus.OK).body(ComercServicio.GuardarComecio(Datos));
    }

    @GetMapping
     public ResponseEntity<?>controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(ComercServicio.ListarComercios());
    }
}
