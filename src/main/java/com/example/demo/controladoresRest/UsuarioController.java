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

import com.example.demo.controlador.Controlador;
import com.example.demo.modelo.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private Controlador usuarioService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") int id, @RequestBody Usuario usuario) {
        Usuario updatedUsuario = usuarioService.updateUsuario(id, usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") int id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado exitosamente");
    }
}
