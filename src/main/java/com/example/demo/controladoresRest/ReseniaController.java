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

import com.example.demo.modelo.Resenia;
import com.example.demo.controlador.Controlador;

@RestController
@RequestMapping("/resenia")
public class ReseniaController {

    @Autowired
    private Controlador reseniaController;

    @GetMapping("/getAll")
    public ResponseEntity<List<Resenia>> getAllResenias() {
        List<Resenia> resenias = reseniaController.getAllResenias();
        return new ResponseEntity<>(resenias, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Resenia> getReseniaById(@PathVariable("id") int id) {
        Resenia resenia = reseniaController.getReseniaById(id);
        return new ResponseEntity<>(resenia, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Resenia> createResenia(@RequestBody Resenia resenia) {
        Resenia createdResenia = reseniaController.createResenia(resenia);
        return new ResponseEntity<>(createdResenia, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Resenia> updateResenia(@PathVariable("id") int id, @RequestBody Resenia resenia) {
        Resenia updatedResenia = reseniaController.updateResenia(id, resenia);
        return new ResponseEntity<>(updatedResenia, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteResenia(@PathVariable("id") int id) {
        reseniaController.deleteResenia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}