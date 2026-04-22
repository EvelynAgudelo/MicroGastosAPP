package com.example.NEOAPP.modelos;

import java.util.List;

import com.example.NEOAPP.modelos.utils.Estados;
import com.example.NEOAPP.modelos.utils.TipoDocumento;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_completo")
    private String nombre;

    // 🔥 ENUM CORRECTO
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "documento", nullable = false, unique = true, length = 15)
    private String documento;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "correoElectronico", nullable = false, unique = true, length = 50)
    private String correo;

    @Column(name = "numeroCelular", nullable = false, unique = true)
    private String numeroCelular;

    @Column(name = "genero", nullable = false)
    private String genero;

    // 🔥 ENUM CORRECTO
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estados activo;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    // RELACIÓN: Usuario -> Gastos
    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

    // RELACIÓN: Usuario -> Métodos de pago
    @OneToMany(mappedBy = "usuario")
    private List<MetodoPago> metodoPagos;

    public Usuario() {
    }

    // GETTERS Y SETTERS (los tuyos están bien, no los cambio todos para no hacerte ruido)
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Estados getActivo() {
        return activo;
    }

    public void setActivo(Estados activo) {
        this.activo = activo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}