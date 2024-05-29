package com.example.demo.controlador;

import java.util.List;
import java.util.OptionalDouble;

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
	
	
	   public void actualizarPuntuacionPromedio(int idRestaurante) {
	        Restaurante restaurante = restauranteRepository.findById(idRestaurante).orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
	        List<Resenia> resenias = reseniaRepository.findByRestaurante(restaurante);
	        OptionalDouble average = resenias.stream().mapToInt(Resenia::getPuntuacion).average();

	        restaurante.setPuntuacionPromedio(average.isPresent() ? (int) average.getAsDouble() : 0);
	        restaurante.setReseniasTotales(resenias.size());
	        restauranteRepository.save(restaurante);
	    }
	public String setUsuarioFoto(int id, String fotoUrl) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setFoto(fotoUrl);
        usuarioRepository.save(usuario);
        return "Foto de usuario actualizada con éxito";
    }


    public String setRestauranteFoto(int id, String fotoUrl) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));

        restaurante.setFoto(fotoUrl);
        restauranteRepository.save(restaurante);
        return "Foto del restaurante actualizada con éxito";
    }

    public String getRestauranteFoto(int id) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
        return restaurante.getFoto();
    }
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
        restaurante.setCiudad(restauranteDetails.getCiudad());
        restaurante.setProvincia(restauranteDetails.getProvincia());
        restaurante.setTipoDeCocina(restauranteDetails.getTipoDeCocina());
        restaurante.setHoraDeApertura(restauranteDetails.getHoraDeApertura());
        restaurante.setHoraDeCierre(restauranteDetails.getHoraDeCierre());
        restaurante.setPuntuacionPromedio(restauranteDetails.getPuntuacionPromedio());
        restaurante.setReseniasTotales(restauranteDetails.getReseniasTotales());
        restaurante.setFoto(restauranteDetails.getFoto());

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
        Resenia savedResenia = reseniaRepository.save(resenia);
        actualizarPuntuacionPromedio(resenia.getRestaurante().getIdRestaurante());
        return savedResenia;
    }

    public Resenia updateResenia(int id, Resenia reseniaDetails) {
        Resenia resenia = reseniaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resenia no encontrada"));

        resenia.setUsuario(reseniaDetails.getUsuario());
        resenia.setRestaurante(reseniaDetails.getRestaurante());
        resenia.setPuntuacion(reseniaDetails.getPuntuacion());
        resenia.setComentario(reseniaDetails.getComentario());
        resenia.setFecha(reseniaDetails.getFecha());

        Resenia updatedResenia = reseniaRepository.save(resenia);
        actualizarPuntuacionPromedio(resenia.getRestaurante().getIdRestaurante());
        return updatedResenia;
    }

    public void deleteResenia(int id) {
        Resenia resenia = reseniaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resenia no encontrada"));
        int idRestaurante = resenia.getRestaurante().getIdRestaurante();
        reseniaRepository.delete(resenia);
        actualizarPuntuacionPromedio(idRestaurante);
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
