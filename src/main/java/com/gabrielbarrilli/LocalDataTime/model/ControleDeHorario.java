package com.gabrielbarrilli.LocalDataTime.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ch01_saida")
public class ControleDeHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch01_codigo_saida")
    private Long id;

    @Column(name = "ch01_hora_atual")
    private LocalDateTime dataHoraAtual;

    @Column(name = "ch01_hora_saida")
    private LocalDateTime dataHoraSaida;

    @ManyToOne
    @JoinColumn(name = "fkch01ch02_codigo_quarto")
    private Quarto quarto;

    @Column(name = "ch01_placa")
    private String placa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraAtual() {
        return dataHoraAtual;
    }

    public void setDataHoraAtual(LocalDateTime dataHoraAtual) {
        this.dataHoraAtual = dataHoraAtual;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
