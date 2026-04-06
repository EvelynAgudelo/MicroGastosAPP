package com.example.NEOAPP.modelos;

import java.util.List;

import com.example.NEOAPP.modelos.utils.Estados;
import com.example.NEOAPP.modelos.utils.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/*--------------------------------------------------------------------------------------------------------------------------------------------------------------
name: Se pone en nombre de la variable 
nullable: Es para decirle al cliente si es obligatorio o no el dato (true: Obligatorio & false:No es obligatorio)
unique: Sirve para decir si la clase o variable es unico o no (true: Unico & False: No es obigatorio)
length: Sirve para aplicar una longitud o numeros de datos a lo que el usuario va a ingresar
------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
@Entity
@Table(name = "usuarios")
    public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreCompleto", nullable = false, unique = false, length = 50) 
    private String nombre;

    @Column(nullable = false, unique = false)
    TipoDocumento tipoDocumento;

    @Column(name = "documento", nullable = false, unique = true, length = 15) 
    private String documento;

    @Column(name = "edad", nullable = true, unique = false)
    private Integer edad;

    // Atributos adicionales

    @Column(name = "CorreoElectronico", nullable = false, unique = true, length = 50)
    private String correo;

    @Column(name = "NumeroDeCelular", nullable = false, unique = true)
    private String numeroCelular;

    @Column(name = "Genero", nullable = false, unique = false)
    private String genero;

    @Column(name = "Estado", nullable = false)
    Estados activo; /*Se pone la variable Estado ya que al crear el paquete para Los tipos de estados, este se cambia*/

    @Column(name = "Ciudad", nullable = false, unique = false  )
    private String ciudad;
    
    /*CREANDO LA PRIMERA RELACION CON LA TABLA GASTOS: 1 USUARIO - MUCHOS GASTOS*/
    @OneToMany(mappedBy = "usuario")/*OneToMany sirve para la relacion que es de 1 a MUCHOS (Donde quedan la relacion de muchos se crea la llave foranea"FK")*/
    private List <Gasto> gastos;

    /*RELACION CON TABLA METODOPAGO: 1 USUARIO - MUCHOS METODOS DE PAGO*/
    @OneToMany(mappedBy = "usuario")
    private List <MetodoPago> metodoPagos;

    public Usuario() {
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