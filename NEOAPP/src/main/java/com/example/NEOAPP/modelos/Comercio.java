package com.example.NEOAPP.modelos;
import org.hibernate.annotations.ManyToAny;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "comercio")
        public class Comercio {
                private Integer id;
                private String Nit;
                private String Nombre;
                private String Actividad;

                /*RELACION CON TABLA GASTO: MUCHOS COMERCIOS - 1 GASTO*/
                @ManyToAny
                @JoinColumn (name = "fk_gasto", referencedColumnName = "id")
                private Gasto gasto;

                //CONSTRUCTOR
                public Comercio() {
                }
                //GETTER Y SETTER
                public Integer getId() {
                        return id;
                }

                public void setId(Integer id) {
                        this.id = id;
                }

                public String getNit() {
                        return Nit;
                }

                public void setNit(String nit) {
                        Nit = nit;
                }

                public String getNombre() {
                        return Nombre;
                }

                public void setNombre(String nombre) {
                        Nombre = nombre;
                }

                public String getActividad() {
                        return Actividad;
                }

                public void setActividad(String actividad) {
                        Actividad = actividad;
        }     
}
