package com.example.NEOAPP.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NEOAPP.modelos.Gasto;
import com.example.NEOAPP.repositorios.IGastoRepositorio;

@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio repoGasto;

    public Gasto GuardarGasto(Gasto datosGasto){
        if(datosGasto.getFecha()==null){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Por favor añadir fecha del gasto"
            );
        }
        if(datosGasto.getValor()<5){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Por favor agregale un valor al gasto"
            );
        }
        return repoGasto.save(datosGasto);
    }

}
  