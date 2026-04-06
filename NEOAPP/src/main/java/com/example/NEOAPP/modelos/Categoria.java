package com.example.NEOAPP.modelos;

import org.hibernate.annotations.ManyToAny;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
    public class Categoria {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false, unique = true)
        private String nombre;

        @Column(nullable = false)
        private String descripcion;

        // Atributos adicionales

        @Column(nullable = false)
        private String color;

        @Column(nullable = false)
        private String icono;

        @Column(nullable = false)
        private Boolean activa;

        @Column(nullable = false)
        private Double limiteMensual;

        @Column(nullable = false)
        private Integer prioridad;

        //Una categoría tiene muchos gastos
        @ManyToAny
        @JoinColumn (name = "fk_gasto", referencedColumnName = "id")
        private Gasto gasto;

        public Categoria() {
        }

        // Getters y Setters

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getIcono() {
            return icono;
        }

        public void setIcono(String icono) {
            this.icono = icono;
        }

        public Boolean getActiva() {
            return activa;
        }

        public void setActiva(Boolean activa) {
            this.activa = activa;
        }

        public Double getLimiteMensual() {
            return limiteMensual;
        }

        public void setLimiteMensual(Double limiteMensual) {
            this.limiteMensual = limiteMensual;
        }

        public Integer getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(Integer prioridad) {
            this.prioridad = prioridad;
        }
}