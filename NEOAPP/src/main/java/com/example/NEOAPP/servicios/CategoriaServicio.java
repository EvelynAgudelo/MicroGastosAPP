package com.example.NEOAPP.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NEOAPP.modelos.Categoria;
import com.example.NEOAPP.repositorios.ICategoria;

@Service
public class CategoriaServicio {
    @Autowired
    private ICategoria repoCategoria;

    public Categoria GuardarCategoria(Categoria datosCategoria){
        if(datosCategoria.getDescripcion()==null){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El campo de descripcion esta incompleto, por favor revisar"
            );
        }
        return repoCategoria.save(datosCategoria);
    }

    public List<Categoria>ListarCategoria(){
        return repoCategoria.findAll();
    }

}
