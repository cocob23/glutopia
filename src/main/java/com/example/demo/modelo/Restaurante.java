package com.example.demo.modelo;

import java.sql.Time;

import jakarta.persistence.*;

@Entity
@Table(name = "Restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    private int idRestaurante;

    @Column(name = "nombre_restaurante", nullable = false)
    private String nombreRestaurante;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "provincia", nullable = false)
    private String provincia;

    @Column(name = "tipo_de_cocina", nullable = false)
    private String tipoDeCocina;

    @Column(name = "hora_de_apertura", nullable = false)
    private Time horaDeApertura;

    @Column(name = "hora_de_cierre", nullable = false)
    private Time horaDeCierre;

    @Column(name = "puntuacion_promedio", nullable = false)
    private int puntuacionPromedio;

    @Column(name = "reseñas_totales", nullable = false)
    private int reseniasTotales;

    public Restaurante() {
    	
    }
    public Restaurante(int idRestaurante, String nombreRestaurante, String direccion, String ciudad, String provincia, String tipoDeCocina, Time horaDeApertura, Time horaDeCierre, int puntuacionPromedio, int reseniasTotales ) {
    	this.idRestaurante=idRestaurante;
    	this.nombreRestaurante = nombreRestaurante;
    	this.direccion = direccion;
    	this.ciudad = ciudad;
    	this.provincia = provincia;
    	this.tipoDeCocina = tipoDeCocina;
    	this.horaDeApertura = horaDeApertura;
    	this.horaDeCierre = horaDeCierre;
    	this.puntuacionPromedio = puntuacionPromedio;
    	this.reseniasTotales=reseniasTotales;
    }
    
    // Getters y setters
    
    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTipoDeCocina() {
        return tipoDeCocina;
    }

    public void setTipoDeCocina(String tipoDeCocina) {
        this.tipoDeCocina = tipoDeCocina;
    }

    public Time getHoraDeApertura() {
        return horaDeApertura;
    }

    public void setHoraDeApertura(Time horaDeApertura) {
        this.horaDeApertura = horaDeApertura;
    }

    public Time getHoraDeCierre() {
        return horaDeCierre;
    }

    public void setHoraDeCierre(Time horaDeCierre) {
        this.horaDeCierre = horaDeCierre;
    }

    public int getPuntuacionPromedio() {
        return puntuacionPromedio;
    }

    public void setPuntuacionPromedio(int puntuacionPromedio) {
        this.puntuacionPromedio = puntuacionPromedio;
    }

    public int getReseniasTotales() {
        return reseniasTotales;
    }

    public void setReseniasTotales(int reseniasTotales) {
        this.reseniasTotales = reseniasTotales;
    }

}
