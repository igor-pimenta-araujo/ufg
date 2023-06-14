package com.persistencia.jpeigor.controllers;

import com.persistencia.jpeigor.models.Alergia;
import com.persistencia.jpeigor.services.AlergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alergia")
public class AlergiaController {

    @Autowired
    private AlergiaService alergiaService;

    @PostMapping
    public ResponseEntity insertAlergia(@RequestBody Alergia alergia) {
        alergiaService.insertAlergia(alergia);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAlergia(@PathVariable int id) {
        alergiaService.deleteAlergia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Alergia>> findAllAlergias() {
        List<Alergia> alergias = alergiaService.findAllAlergias();
        return ResponseEntity.ok(alergias);
    }
}
