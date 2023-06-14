package com.persistencia.jpeigor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.persistencia.jpeigor.models.enums.SituacaoEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Agendas")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate data;

    private LocalTime hora;

    private SituacaoEnum situacao;

    @Column(name = "data_situacao", nullable = true)
    private LocalDate dataSituacao;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "vacina_id")
    private Vacina vacina;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties(value = "agendamentos")
    private Usuario usuario;

    public Agenda() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataSituacao() {
        return dataSituacao;
    }

    public void setDataSituacao(LocalDate dataSituacao) {
        this.dataSituacao = dataSituacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Agenda clone() {
        Agenda agenda = new Agenda();
        agenda.setSituacao(this.getSituacao());
        agenda.setData(this.getData());
        agenda.setHora(this.getHora());
        agenda.setUsuario(this.getUsuario());
        agenda.setObservacoes(this.getObservacoes());
        agenda.setDataSituacao(this.getDataSituacao());
        agenda.setVacina(this.getVacina());
        return agenda;
    }
}
