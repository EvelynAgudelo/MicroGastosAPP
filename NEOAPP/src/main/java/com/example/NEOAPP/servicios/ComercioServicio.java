package com.example.NEOAPP.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.NEOAPP.modelos.Comercio;
import com.example.NEOAPP.repositorios.IComercioRepositorio;

@Service
public class ComercioServicio {
    @Autowired
    private IComercioRepositorio repoComercio;

    public Comercio GuardarComecio(Comercio datosComercio){
        if(datosComercio.getNombre()==null || datosComercio.getNombre().isBlank() || datosComercio.getNombre().isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es importante, por favor completar el campo"
            );
        }
        return repoComercio.save(datosComercio);
    }

    public List<Comercio>ListarComercios(){
        return repoComercio.findAll();
    }
}
