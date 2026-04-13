package com.example.NEOAPP.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NEOAPP.modelos.MetodoPago;
import com.example.NEOAPP.repositorios.IMetodoDePago;

@Service
public class MetodoPagoServicio {

    @Autowired
    private IMetodoDePago repoMetodoDePago;

    public MetodoPago GuardarMetododePago (MetodoPago datosMetododePago){
        if(datosMetododePago.getNombre()==null || datosMetododePago.getNombre().isBlank() || datosMetododePago.getNombre().isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre en este campo es obligatorio"
            );
        }
        if(datosMetododePago.getFranquicia().length()<6){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Por favor añade una breve descrpción"
            );
        }
        return repoMetodoDePago.save(datosMetododePago);
    }

    public List <MetodoPago>ListarMetododePago(){
        return repoMetodoDePago.findAll();
    } 
}
