package com.ultragroup.hotel.controllers;


import com.ultragroup.hotel.config.exceptions.MessageException;
import com.ultragroup.hotel.models.dtos.ReservationDTO;
import com.ultragroup.hotel.usecases.ReservationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationController {


    private final ReservationUseCase reservationUseCase;

    public ReservationController(ReservationUseCase reservationUseCase) {
        this.reservationUseCase = reservationUseCase;
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> create(@RequestBody ReservationDTO request) {
        try {
            ReservationDTO response = reservationUseCase.create(request);
            return ResponseEntity.ok(response);
        } catch (MessageException e) {
            return ResponseEntity.badRequest().body(ReservationDTO.builder().message(e.getMessage()).build());
        }
    }


    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getReservation() {
        return ResponseEntity.ok(reservationUseCase.getAllReservation());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<List<ReservationDTO>> getReservationById(@PathVariable Long idUser) {
        return ResponseEntity.ok(reservationUseCase.getAllReservationHotelUserCreatedId(idUser));
    }

    @GetMapping("/future")
    public ResponseEntity<List<ReservationDTO>> getAllReservationHotelUserCreatedId() {
        return ResponseEntity.ok(reservationUseCase.getReservationsWithExitDateAfterToday());
    }
}

