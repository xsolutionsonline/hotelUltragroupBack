package com.ultragroup.hotel.config.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.IntStream;

public final class Utilidad {

    public static LocalDate calcularFechaMaximaDevolucion(int dias) {
        LocalDate fechaActual = LocalDate.now().plusDays(1);
        Optional<LocalDate> fechaMaximaOptional = IntStream.iterate(0, i -> i + 1)
                .mapToObj(fechaActual::plusDays)
                .filter(fecha -> !fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                .limit(dias)
                .reduce((primera, segunda) -> segunda);

        return fechaMaximaOptional.orElse(LocalDate.now());
    }

    public static String cambiarFormatoFecha(LocalDate fecha) {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
