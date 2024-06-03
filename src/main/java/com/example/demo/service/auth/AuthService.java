package com.example.demo.service.auth;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.auth.AuthResponse;
import com.example.demo.modelo.auth.LoginRequest;
import com.example.demo.modelo.auth.RegisterRequest;
import com.example.demo.interfase.interfazUsuario;
import com.example.demo.jwt.*;
import com.example.demo.config.*;


import lombok.RequiredArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final interfazUsuario userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder; // Añadir PasswordEncoder

//    public AuthService (interfazUsuario userRepository, JwtService jwtService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder ) {
 //   	this.userRepository = userRepository;
  //  	this.jwtService = jwtService;
   // 	this.authenticationManager = authenticationManager;
   // 	this.passwordEncoder = passwordEncoder;
    //}
    
    public AuthResponse login(LoginRequest request) {
    	System.out.println("hola");
    	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContraseña()));      
    	System.out.println("hola2");
    	Usuario user = userRepository.findByEmail(request.getEmail());
        System.out.println(user);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getContraseña(),
                Collections.emptyList()
            );
            
            // Obtener el token utilizando el objeto UserDetails convertido
            String token = jwtService.getToken(userDetails);
            return AuthResponse.builder()
            .token(token)
            .userId(Long.valueOf(user.getIdUsuario()))
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = new Usuario();
        user.setNombre(request.getNombre());
        user.setEmail(request.getEmail());
        user.setContraseña(passwordEncoder.encode(request.getContraseña()));
        user.setUbicacion(request.getUbicacion());
        user.setDieta(request.getDieta());
        user.setFoto(request.getFoto());
        userRepository.save(user);
        
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getContraseña(), // Aquí puede haber un problema, explicado después
                Collections.emptyList()
            );
            
            // Obtener el token utilizando el UserDetails creado
            String token = jwtService.getToken(userDetails);
            
            return AuthResponse.builder()
                .token(token)
                .userId(Long.valueOf(user.getIdUsuario()))
                .build();
    }
}
