package com.gabrielbarrilli.LocalDataTime.response;

public record HorarioResponse(
        long horas,
        long minutos,
        long segundos
) {
}
