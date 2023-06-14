package com.persistencia.jpeigor.controllers;

import com.persistencia.jpeigor.models.Vacina;
import com.persistencia.jpeigor.services.VacinaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vacina")
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping
    public ResponseEntity insertVacina(@RequestBody Vacina vacina) {
        vacinaService.insertVacina(vacina);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteVacina(@PathVariable int id) {
        vacinaService.deleteVacina(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Vacina>> findAllVacinas() {
        List<Vacina> vacinas = vacinaService.findAllVacinas();
        return ResponseEntity.ok(vacinas);
    }
}
