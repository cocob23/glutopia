package com.example.demo.controladoresRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Restaurante;
import com.example.demo.controlador.Controlador;
@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@Autowired
    private Controlador restauranteController;

    @GetMapping("/getAll")
    public ResponseEntity<List<Restaurante>> getAllRestaurantes() {
        List<Restaurante> restaurantes = restauranteController.getAllRestaurantes();
        return new ResponseEntity<>(restaurantes, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Restaurante> getRestauranteById(@PathVariable("id") int id) {
        Restaurante restaurante = restauranteController.getRestauranteById(id);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Restaurante> createRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante createdRestaurante = restauranteController.createRestaurante(restaurante);
        return new ResponseEntity<>(createdRestaurante, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> updateRestaurante(@PathVariable("id") int id, @RequestBody Restaurante restaurante) {
        Restaurante updatedRestaurante = restauranteController.updateRestaurante(id, restaurante);
        return new ResponseEntity<>(updatedRestaurante, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable("id") int id) {
        restauranteController.deleteRestaurante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/{id}/foto")
    public ResponseEntity<String> setRestauranteFoto(@PathVariable("id") int id, @RequestBody String fotoUrl) {
        String response = restauranteController.setRestauranteFoto(id, fotoUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
