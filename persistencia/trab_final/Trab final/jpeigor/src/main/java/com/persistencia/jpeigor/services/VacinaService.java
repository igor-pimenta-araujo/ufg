package com.persistencia.jpeigor.services;

import com.persistencia.jpeigor.models.Vacina;
import com.persistencia.jpeigor.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    public void insertVacina(Vacina vacina) {
        vacinaRepository.save(vacina);
    }

    public void deleteVacina(int vacinaId) {
        vacinaRepository.deleteById(vacinaId);
    }

    public List<Vacina> findAllVacinas() {
        List<Vacina> vacinas = vacinaRepository.findAll();
        return vacinas;
    }
}
