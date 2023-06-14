package com.persistencia.jpeigor.controllers;

import com.persistencia.jpeigor.models.Agenda;
import com.persistencia.jpeigor.models.enums.SituacaoEnum;
import com.persistencia.jpeigor.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public ResponseEntity insertAgenda(@RequestBody Agenda agenda) {
        agendaService.insertAgenda(agenda);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> findAllAgendamentos() {
        List<Agenda> agendamentos = agendaService.findAllAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAgendamento(@PathVariable int id) {
        agendaService.deleteAgendamento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/situacao")
    public ResponseEntity<List<Agenda>> findBySituacao(@RequestParam SituacaoEnum situacao) {
        var agendas = agendaService.findBySituacao(situacao);
        return ResponseEntity.ok(agendas);
    }

    @GetMapping(value = "/data")
    public ResponseEntity<List<Agenda>> findByData(@RequestParam LocalDate data) {
        var agendas = agendaService.findByData(data);
        return ResponseEntity.ok(agendas);
    }

    @PutMapping(value = "/situacao")
    public ResponseEntity updateSituacao(@RequestParam int id, @RequestParam SituacaoEnum situacao, @RequestParam String observacoes) {
        agendaService.updateSituacao(id, situacao, observacoes);
        return ResponseEntity.ok().build();
    }
}
