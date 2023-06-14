package com.persistencia.jpeigor.services;

import com.persistencia.jpeigor.models.Usuario;
import com.persistencia.jpeigor.models.Vacina;
import com.persistencia.jpeigor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void insertUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(int usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    public List<Usuario> findAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario findUsuarioById(int usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).get();
        return usuario;
    }
}
