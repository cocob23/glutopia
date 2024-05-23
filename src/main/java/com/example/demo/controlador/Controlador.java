package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfase.*;
import com.example.demo.modelo.*;


@RestController
public class Controlador {
   
	@Autowired
    private interfazUsuario usuarioRepository;
	@Autowired
    private interfazRestaurante restauranteRepository;
	@Autowired
	private interfazResenia reseniaRepository;
	@Autowired
    private interfazMenu menuRepository;
	
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow();
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(int id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow();

        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setContraseña(usuarioDetails.getContraseña());
        usuario.setUbicacion(usuarioDetails.getUbicacion());
        usuario.setDieta(usuarioDetails.getDieta());

        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow();

        usuarioRepository.delete(usuario);
    }
    
    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    public Restaurante getRestauranteById(int id) {
        return restauranteRepository.findById(id)
                .orElseThrow();
    }

    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Restaurante updateRestaurante(int id, Restaurante restauranteDetails) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow();

        restaurante.setNombreRestaurante(restauranteDetails.getNombreRestaurante());
        restaurante.setDireccion(restauranteDetails.getDireccion());
        // Agrega los otros campos a actualizar aquí...

        return restauranteRepository.save(restaurante);
    }

    public void deleteRestaurante(int id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow();

        restauranteRepository.delete(restaurante);
    }
    
    public List<Resenia> getAllResenias() {
        return reseniaRepository.findAll();
    }

    public Resenia getReseniaById(int id) {
        return reseniaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resenia no encontrada"));
    }

    public Resenia createResenia(Resenia resenia) {
        return reseniaRepository.save(resenia);
    }

    public Resenia updateResenia(int id, Resenia reseniaDetails) {
        Resenia resenia = reseniaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resenia no encontrada"));

        resenia.setUsuario(reseniaDetails.getUsuario());
        resenia.setRestaurante(reseniaDetails.getRestaurante());
        resenia.setPuntuacion(reseniaDetails.getPuntuacion());
        resenia.setComentario(reseniaDetails.getComentario());
        resenia.setFecha(reseniaDetails.getFecha());

        return reseniaRepository.save(resenia);
    }

    public void deleteResenia(int id) {
        Resenia resenia = reseniaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resenia no encontrada"));
        reseniaRepository.delete(resenia);
    }
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(int id) {
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menú no encontrado"));
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(int id, Menu menuDetails) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menú no encontrado"));

        menu.setRestaurante(menuDetails.getRestaurante());
        menu.setNombrePlato(menuDetails.getNombrePlato());
        menu.setDescripcion(menuDetails.getDescripcion());
        menu.setPrecio(menuDetails.getPrecio());
        menu.setInformacionAlergias(menuDetails.getInformacionAlergias());

        return menuRepository.save(menu);
    }

    public void deleteMenu(int id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menú no encontrado"));
        menuRepository.delete(menu);
    }

}
