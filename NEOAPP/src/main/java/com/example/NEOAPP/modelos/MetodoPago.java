package com.example.NEOAPP.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table (name = "metodoPago")
    public class MetodoPago {
        //id, nombre, franquicia, estado(activo,inactivo),  descripcion 
        private Integer id;
        private String Nombre;
        private String Franquicia;
        private Double Estado;
        private String Descripcion;

        /*RELACION ENTRE METODOS DE PAGO Y USUARIOS*/
        @JoinColumn (name = "fk_usuario", referencedColumnName = "id")
        private MetodoPago metodoPago;
        
        //cONSTRUCTOR
        public MetodoPago() {
        }
        //GETTER Y SETTER
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String nombre) {
            Nombre = nombre;
        }

        public String getFranquicia() {
            return Franquicia;
        }

        public void setFranquicia(String franquicia) {
            Franquicia = franquicia;
        }

        public Double getEstado() {
            return Estado;
        }

        public void setEstado(Double estado) {
            Estado = estado;
        }

        public String getDescripcion() {
            return Descripcion;
        }

        public void setDescripcion(String descripcion) {
            Descripcion = descripcion;
    }
    
    
}
