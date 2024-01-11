package com.gabrielbarrilli.LocalDataTime.model;

import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "ch02_quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch02_cod_quarto")
    private Long id;

    @Column(name = "ch02_numero")
    private Integer numero;

    @Column(name = "ch02_descricao")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Quarto(Integer numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    public Quarto() {
    }
}
