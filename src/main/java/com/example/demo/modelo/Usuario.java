package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "dieta", nullable = false)
    private String dieta;
   
    @Column(name = "foto")  
    private String foto;
    
    public Usuario() {
    	
    }
    public Usuario(int idUsuario, String nombre, String email, String contraseña, String ubicacion, String dieta, String foto ) {
    	this.idUsuario=idUsuario;
    	this.nombre = nombre;
    	this.email = email;
    	this.contraseña = contraseña;
    	this.ubicacion = ubicacion;
    	this.dieta = dieta;
    	this.foto = foto;
    }
    // Getters y setters
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
