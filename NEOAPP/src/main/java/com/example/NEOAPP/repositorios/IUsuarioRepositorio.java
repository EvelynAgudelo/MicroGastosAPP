package com.example.NEOAPP.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NEOAPP.modelos.Usuario;





@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer>{
    
    List<Usuario> findByNombre(String nombre); //BUSCAR POR NOMBRE (1) Solo uno, ya que solo aparecera una persona 

    Optional <Usuario> findByDocumento(String documento);//BUCAR POR DOCUMENTO (1) Cuando en la busqueda solo me aparecera un atributo. le pondremos "OPTIONAL", ya que, como ejemplo el documento solo lo tiene una sola persona

    //BUSCAR POR NOMBRES QUE CONTENGAN NNN (LISTA)
    List <Usuario> findByNombresContaining(String nombres);



     //BUSCAR POR EDAD (LISTA) Saldra una lista, ya que al buscar por edad, muchas personas salen con la misma edad
     List <Usuario>findByEdad(Integer edad);
}
