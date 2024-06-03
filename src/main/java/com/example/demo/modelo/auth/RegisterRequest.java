package com.example.demo.modelo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nombre;
    private String email;
    private String contraseña;
    private String ubicacion;
    private String dieta;
    private String foto;
    
    public String getNombre() {
    	return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getContraseña() {
    	return contraseña;
    }
    
    public String getUbicacion() {
    	return ubicacion;
    }
    
    public String getDieta() {
    	return dieta;
    }
    
    public String getFoto() {
    	return foto;
    }
    

}