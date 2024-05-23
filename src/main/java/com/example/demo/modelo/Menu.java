package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private int idMenu;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    @Column(name = "nombre_plato", nullable = false)
    private String nombrePlato;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private int precio;

    @Column(name = "informacion_alergias", nullable = false)
    private String informacionAlergias;

    public Menu() {
    	
    }
    
    public Menu(Restaurante restaurante, String nombrePlato, String descripcion, int precio, String informacionAlergias) {
    	this.restaurante = restaurante;
    	this.nombrePlato = nombrePlato;
    	this.descripcion= descripcion;
    	this.precio= precio;
    	this.informacionAlergias = informacionAlergias;
    }
    
    // Getters y setters
    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getInformacionAlergias() {
        return informacionAlergias;
    }

    public void setInformacionAlergias(String informacionAlergias) {
        this.informacionAlergias = informacionAlergias;
    }
}

