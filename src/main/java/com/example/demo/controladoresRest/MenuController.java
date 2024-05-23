package com.example.demo.controladoresRest;

import com.example.demo.modelo.Menu;
import com.example.demo.controlador.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private Controlador menuController;

    @GetMapping("/getAll")
    public ResponseEntity<List<Menu>> getAllMenus() {
        List<Menu> menus = menuController.getAllMenus();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("id") int id) {
        Menu menu = menuController.getMenuById(id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        Menu createdMenu = menuController.createMenu(menu);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") int id, @RequestBody Menu menu) {
        Menu updatedMenu = menuController.updateMenu(id, menu);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable("id") int id) {
        menuController.deleteMenu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}