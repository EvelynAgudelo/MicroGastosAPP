//LA CAPA QUE HACE LAS CONSULTAS ES EL REPOSITORIO
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
    
    @Autowired //Para conectar las dependencias
        private IUsuarioRepositorio repositorio;  //Inyeccion de una dependencia

        public Usuario GuardarUsuario(Usuario datosUsuario){
            //Hay que validar la operacion que me estan pidiendo hacer (ej: guardar usuario)
            if(datosUsuario.getNombre()==null || datosUsuario.getNombre().isBlank() || datosUsuario.getNombre().isEmpty()){
                            //No esta definido                         Esta en blanco                         Esta vacio
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre de usuario es obligatorio, revisar por favor"
                );
            }
            if (datosUsuario.getDocumento().length()<5) {
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El documento es inválido"
                );
            }
            //Despues de las validaciones, intento guardar los datos que me enviaron
            return repositorio.save(datosUsuario);  //Guarda y retorna los datos ingresados del usuario
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Servicio para listar todos los usuarios en BD
        public List<Usuario>ListarUsuarios(){
            return repositorio.findAll();
        }
/////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////
        //Servicio para eliminar un usuario en BD
        //Servicio para modificar un usuario en BD
        //Servicio para buscar un usuario por su id 


}
