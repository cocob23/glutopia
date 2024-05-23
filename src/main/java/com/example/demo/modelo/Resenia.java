package com.example.demo.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resenia")
public class Resenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resenia")
    private int idResenia;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    public Resenia() {
    	
    }
    
    public Resenia(int idResenia, Usuario usuario, Restaurante restaurante, int puntuacion, String comentario, Date fecha ) {
    	this.idResenia=idResenia;
    	this.usuario = usuario;
    	this.restaurante = restaurante;
    	this.puntuacion = puntuacion;
    	this.comentario = comentario;
    	this.fecha = fecha;
    }
    // Getters y setters
    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
