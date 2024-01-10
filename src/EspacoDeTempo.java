import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class EspacoDeTempo {
    public void calculaTempo(){
        LocalDate dataEntrada = LocalDate.now();
        LocalTime horaEntrada = LocalTime.now();

        LocalDate dataSaida = LocalDate.of(2024 , 2 , 10);
        LocalTime horaSaida = LocalTime.of(9 , 15);

        Duration duracao = Duration.between(dataEntrada.atTime(horaEntrada), dataSaida.atTime(horaSaida));

        // Obtém a diferença em horas e minutos
        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;

        // Exibe o tempo total de permanência
        System.out.println("Tempo total de permanência: " + horas + " horas e " + minutos + " minutos.");
    }
}
