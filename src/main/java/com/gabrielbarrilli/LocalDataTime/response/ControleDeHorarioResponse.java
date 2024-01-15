package com.gabrielbarrilli.LocalDataTime.response;

import java.time.LocalDateTime;

public record ControleDeHorarioResponse(
        Long id,
        LocalDateTime dataHoraEntrada,
        LocalDateTime dataHoraSaida,
        Long numero,
        String placa,
        HorarioResponse horarioResponse
) {
}
