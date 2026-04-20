package com.example.NEOAPP.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NEOAPP.modelos.MetodoPago;
import com.example.NEOAPP.servicios.MetodoPagoServicio;

@RestController
@RequestMapping("/microgastosapp/v1/metodosDePago")
public class MetodoPagoControlador {
    @Autowired
    private MetodoPagoServicio MetodoPagoServicio;

    @PostMapping
    public ResponseEntity<?>ControladorGuardar(@RequestBody MetodoPago Datos){
        return ResponseEntity.status(HttpStatus.OK).body(MetodoPagoServicio.GuardarMetododePago(Datos));
    }
    @GetMapping
    public ResponseEntity<?>controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(MetodoPagoServicio.ListarMetododePago());
    }
}
