package com.persistencia.jpeigor.services;

import com.persistencia.jpeigor.models.Alergia;
import com.persistencia.jpeigor.repositories.AlergiaRepository;
import com.persistencia.jpeigor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergiaService {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void insertAlergia(Alergia alergia) {
        alergiaRepository.save(alergia);
    }

    public void deleteAlergia(int alergiaId) {
        var alergia = alergiaRepository.findById(alergiaId).get();
        for (var usuario : alergia.getUsuarios()) {
            usuario.getAlergias().remove(alergia);
            usuarioRepository.save(usuario);
        }
        alergiaRepository.deleteById(alergiaId);
    }

    public List<Alergia> findAllAlergias() {
        List<Alergia> alergias = alergiaRepository.findAll();
        return alergias;
    }
}
