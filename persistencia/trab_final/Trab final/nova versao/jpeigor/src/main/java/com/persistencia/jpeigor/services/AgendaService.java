package com.persistencia.jpeigor.services;

import com.persistencia.jpeigor.models.Agenda;
import com.persistencia.jpeigor.models.Usuario;
import com.persistencia.jpeigor.models.Vacina;
import com.persistencia.jpeigor.models.enums.SituacaoEnum;
import com.persistencia.jpeigor.repositories.AgendaRepository;
import com.persistencia.jpeigor.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private VacinaRepository vacinaRepository;

    public void insertAgenda(Agenda agenda) {
        Vacina vacina = vacinaRepository.findById(agenda.getVacina().getId()).get();
        agenda.setSituacao(SituacaoEnum.Agendado);
        agendaRepository.save(agenda);

        for(int i = 1; i < vacina.getDoses(); i++) {
            LocalDate proximaData = agenda.getData();
            int novoIntervalo = vacina.getIntervalo() * i;
            switch(vacina.getPeriodicidade()) {
                case dias:
                    proximaData = proximaData.plusDays(novoIntervalo);
                    break;
                case semanas:
                    proximaData = proximaData.plusWeeks(novoIntervalo);
                    break;
                case meses:
                    proximaData = proximaData.plusMonths(novoIntervalo);
                    break;
                case anos:
                    proximaData = proximaData.plusYears(novoIntervalo);
                    break;
            }
            Agenda novaAgenda = agenda.clone();
            novaAgenda.setData(proximaData);
            agendaRepository.save(novaAgenda);
        }
    }

    public List<Agenda> findAllAgendamentos() {
        List<Agenda> agendamentos = agendaRepository.findAll();
        return agendamentos;
    }


    public void deleteAgendamento(int agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId).get();
        if(agenda.getSituacao() != SituacaoEnum.Agendado) {
            throw new IllegalArgumentException("Can't delete appointments that are already concluded!");
        }
        int vacinaId = agenda.getVacina().getId();
        int usuarioId = agenda.getUsuario().getId();
        Vacina vacina = new Vacina();
        vacina.setId(vacinaId);
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        List<Agenda> agendas = agendaRepository.findByVacinaAndUsuarioAgendado(vacina, usuario);

        agendaRepository.deleteAll(agendas);
    }

    public List<Agenda> findBySituacao(SituacaoEnum situacao) {
        var agendas = agendaRepository.findBySituacao(situacao);
        return agendas;
    }

    public List<Agenda> findByData(LocalDate data) {
        var agendas = agendaRepository.findByData(data);
        return agendas;
    }

    public void updateSituacao(int agendaId, SituacaoEnum situacao, String observacoes) {
        var agenda = agendaRepository.findById(agendaId).get();
        agenda.setSituacao(situacao);
        agenda.setDataSituacao(LocalDate.now());
        agenda.setObservacoes(observacoes);
        agendaRepository.save(agenda);
    }
}
