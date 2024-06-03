package com.example.demo.modelo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String email;
    private String contraseña;
	public String getEmail() {
		return email;
	}
	public Object getContraseña() {
		return contraseña;
	}
}