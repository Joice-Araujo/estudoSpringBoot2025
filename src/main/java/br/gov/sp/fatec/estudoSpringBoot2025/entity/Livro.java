package br.gov.sp.fatec.estudoSpringBoot2025.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "liv_livro",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"liv_titulo", "liv_edicao"})
    }
)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="liv_id")
    private Long id;

    @Column(name="liv_titulo")
    private String titulo;

    @Column(name="liv_edicao")
    private Integer edicao;

    @Column(name="liv_data_lancamento")
    private LocalDate dataLancamento;

    @Column(name="liv_paginas")
    private Integer paginas;

    @Column(name="liv_genero")
    private String genero;

    public Livro() {}

    public Livro(Long id, String titulo, Integer edicao, LocalDate dataLancamento, Integer paginas, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.edicao = edicao;
        this.dataLancamento = dataLancamento;
        this.paginas = paginas;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

   

    


    
}
