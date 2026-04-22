package com.example.NEOAPP.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NEOAPP.modelos.Usuario;
import com.example.NEOAPP.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repositorio;

    // GUARDAR USUARIO
    public Usuario GuardarUsuario(Usuario datosUsuario) {

        // VALIDAR OBJETO COMPLETO
        if (datosUsuario == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El usuario no puede ser nulo"
            );
        }

        // VALIDAR NOMBRE
        String nombre = datosUsuario.getNombre();
        if (nombre == null || nombre.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre es obligatorio"
            );
        }

        // VALIDAR DOCUMENTO
        String documento = datosUsuario.getDocumento();
        if (documento == null || documento.length() < 5) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El documento debe tener mínimo 5 caracteres"
            );
        }

        // GUARDAR EN BD
        return repositorio.save(datosUsuario);
    }

    // LISTAR USUARIOS
    public List<Usuario> ListarUsuarios() {
        return repositorio.findAll();
    }

    // BUSCAR POR ID
    public Usuario BuscarPorId(Integer id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuario no encontrado"
                ));
    }

    // ELIMINAR USUARIO
    public void EliminarUsuario(Integer id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Usuario no encontrado"
            );
        }
        repositorio.deleteById(id);
    }
}