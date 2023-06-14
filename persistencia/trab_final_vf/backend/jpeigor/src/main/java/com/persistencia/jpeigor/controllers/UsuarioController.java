package com.persistencia.jpeigor.controllers;

import com.persistencia.jpeigor.models.Usuario;
import com.persistencia.jpeigor.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity insertUsuario(@RequestBody Usuario usuario) {
        usuarioService.insertUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable int id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }
}
