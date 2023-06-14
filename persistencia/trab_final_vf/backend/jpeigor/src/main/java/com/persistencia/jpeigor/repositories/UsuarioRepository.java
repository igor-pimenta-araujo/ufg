package com.persistencia.jpeigor.repositories;

import com.persistencia.jpeigor.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
