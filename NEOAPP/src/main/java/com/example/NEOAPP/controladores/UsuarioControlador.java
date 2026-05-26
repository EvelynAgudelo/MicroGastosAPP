package com.example.NEOAPP.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.NEOAPP.modelos.Usuario;
import com.example.NEOAPP.servicios.UsuarioServicio;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/microgastosapp/v1/usuarios")
public class UsuarioControlador {
    //INYECTAR EL SERVICIO CORRESPONDIENTE
    @Autowired
    private UsuarioServicio UserServicio;
    //PARA CADA SERVICIO OFRECIDO SE DEBE PROGRAMAR UNA FUNCION, ESA FUNCION RECIBIRA LAS PETICIONES DEL PEDIDO Y RESPONDERA

    //Funcion controladora del servicio de guardar usuario
    @PostMapping  //Sirve para guardar la informacion
    public ResponseEntity<?> ControladorGuardar(@RequestBody Usuario Datos){  //el RequestBody sirve para que la api tenga en cuenta que la informacion llegara por medio del body
        return ResponseEntity.status(HttpStatus.OK).body(UserServicio.GuardarUsuario(Datos));
    }
    //Funcion controladora del servicio de listar todos los usuarios
    @GetMapping
    public ResponseEntity<?>controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(UserServicio.ListarUsuarios());
    }
}
