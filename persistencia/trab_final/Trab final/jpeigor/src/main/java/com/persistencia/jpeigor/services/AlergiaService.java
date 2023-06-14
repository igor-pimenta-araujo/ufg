package com.persistencia.jpeigor.services;

import com.persistencia.jpeigor.models.Alergia;
import com.persistencia.jpeigor.repositories.AlergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergiaService {

    @Autowired
    private AlergiaRepository alergiaRepository;

    public void insertAlergia(Alergia alergia) {
        alergiaRepository.save(alergia);
    }

    public void deleteAlergia(int alergiaId) {
        alergiaRepository.deleteById(alergiaId);
    }

    public List<Alergia> findAllAlergias() {
        List<Alergia> alergias = alergiaRepository.findAll();
        return alergias;
    }
}
