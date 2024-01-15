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

    @Column(name = "ch01_data_entrada")
    private LocalDate dataEntrada;

    @Column(name = "ch01_hora_entrada")
    private LocalTime horaEntrada;

    @Column(name = "ch01_data_saida")
    private LocalDate dataSaida;

    @Column(name = "ch01_hora_saida")
    private LocalTime horaSaida;

    @Column(name = "ch01_tempo_permanencia")
    private String tempoPermanencia;

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

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getTempoPermanencia() {
        return tempoPermanencia;
    }

    public void setTempoPermanencia(String tempoPermanencia) {
        this.tempoPermanencia = tempoPermanencia;
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

    public ControleDeHorario(LocalDate dataEntrada, LocalTime horaEntrada, LocalDate dataSaida, LocalTime horaSaida, String tempoPermanencia, Quarto quarto, String placa) {
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.tempoPermanencia = tempoPermanencia;
        this.quarto = quarto;
        this.placa = placa;
    }

    public ControleDeHorario() {
    }
}
