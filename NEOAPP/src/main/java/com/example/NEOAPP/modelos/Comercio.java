package com.example.NEOAPP.modelos;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "comercio")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nit;
    private String nombre;
    private String actividad;

    @OneToMany(mappedBy = "comercio")
    private List<Gasto> gastos;

    public Comercio() {}

    // GETTERS Y SETTERS
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getActividad() { return actividad; }
    public void setActividad(String actividad) { this.actividad = actividad; }
}