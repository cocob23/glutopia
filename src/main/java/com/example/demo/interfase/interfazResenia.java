package com.example.demo.interfase;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelo.*;

public interface interfazResenia extends JpaRepository<Resenia, Integer>{
	List<Resenia> findByRestaurante(Restaurante restaurante);

}
