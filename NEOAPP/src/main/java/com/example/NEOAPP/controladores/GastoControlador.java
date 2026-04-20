package com.example.NEOAPP.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.NEOAPP.modelos.Gasto;
import com.example.NEOAPP.servicios.GastoServicio;

@RestController
@RequestMapping("/microgastosapp/v1/gastos")
public class GastoControlador {
    @Autowired
    private GastoServicio GastServicio;

    @PostMapping
    public ResponseEntity<?>ControladorGuardar(@RequestBody Gasto Datos){
        return ResponseEntity.status(HttpStatus.OK).body(GastServicio.GuardarGasto(Datos));
    }

    @GetMapping
     public ResponseEntity<?>controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(GastServicio.ListarGasto());
    }
}
