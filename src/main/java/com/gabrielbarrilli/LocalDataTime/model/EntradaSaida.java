package com.gabrielbarrilli.LocalDataTime.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "dt01_entrada_saida")
public class EntradaSaida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dt01_codigo_entrada_saida")
    private Long id;

    @Column(name = "dt01_hora_atual")
    private LocalTime horaAtual;

    @Column(name = "dt01_data_atual")
    private LocalDate dataAtual;

    @Column(name = "dt01_hora_saida")
    private LocalTime horaSaida;

    @Column(name = "dt01_data_saida")
    private LocalDate dataSaida;

}
