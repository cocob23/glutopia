package com.example.demo.interfase;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelo.*;


public interface interfazUsuario extends JpaRepository<Usuario, Integer> {
	
	
	Usuario findByEmail(String email);
}
