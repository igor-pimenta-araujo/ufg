package com.persistencia.jpeigor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private char sexo;

    private String logradouro;

    private int numero;

    private String setor;

    private String cidade;

    private String uf;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties(value = "usuario")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Agenda> agendamentos;

    @ManyToMany
    @JoinTable(name = "usuarios_alergias", joinColumns = {@JoinColumn(name = "usuario_id")}, inverseJoinColumns = {@JoinColumn(name = "alergia_id")})
    private List<Alergia> alergias;

    public Usuario() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<Alergia> alergias) {
        this.alergias = alergias;
    }

    public List<Agenda> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agenda> agendamentos) {
        this.agendamentos = agendamentos;
    }


}
