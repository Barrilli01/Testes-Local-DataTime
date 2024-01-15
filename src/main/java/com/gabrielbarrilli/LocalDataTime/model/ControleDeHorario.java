package com.gabrielbarrilli.LocalDataTime.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "ch01_saida")
public class ControleDeHorario {

    // teste
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch01_codigo_saida")
    private Long id;

    private LocalDate dataEntrada;

    @Column(name = "ch01_data_hora_entrada")
    private LocalDateTime dataHoraEntrada;

    @Column(name = "ch01_data_hora_saida")
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

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
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

    public ControleDeHorario(LocalDate dataEntrada, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida, Quarto quarto, String placa) {
        this.dataEntrada = dataEntrada;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.quarto = quarto;
        this.placa = placa;
    }

    public ControleDeHorario() {
    }
}
