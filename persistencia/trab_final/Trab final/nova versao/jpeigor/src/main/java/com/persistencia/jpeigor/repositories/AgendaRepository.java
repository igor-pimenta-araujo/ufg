package com.persistencia.jpeigor.repositories;

import com.persistencia.jpeigor.models.Agenda;
import com.persistencia.jpeigor.models.Usuario;
import com.persistencia.jpeigor.models.Vacina;
import com.persistencia.jpeigor.models.enums.SituacaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
    @Query("SELECT a FROM Agenda a INNER JOIN Usuario INNER JOIN Vacina WHERE a.vacina = :vacina AND a.usuario = :usuario AND a.situacao = 0")
    public List<Agenda> findByVacinaAndUsuarioAgendado(Vacina vacina, Usuario usuario);

    @Query("SELECT a FROM Agenda a INNER JOIN Usuario INNER JOIN Vacina WHERE a.situacao = :situacao")
    public List<Agenda> findBySituacao(SituacaoEnum situacao);

    @Query("SELECT a FROM Agenda a INNER JOIN Usuario INNER JOIN Vacina WHERE a.data = :data order by a.situacao, a.hora asc")
    public List<Agenda> findByData(LocalDate data);
}
