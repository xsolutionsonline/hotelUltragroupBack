package com.ultragroup.hotel.usecases;

import com.ultragroup.hotel.config.exceptions.MessageException;
import com.ultragroup.hotel.models.dtos.ReservationDTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationUseCase {

    ReservationDTO create(ReservationDTO reservation) throws MessageException;

    ResponseEntity<ReservationDTO> getReservationById(Long id);
    List<ReservationDTO> getAllReservation() throws MessageException;

    List<ReservationDTO> getAllReservationHotelUserCreatedId(Long isUser) throws MessageException;

    List<ReservationDTO> getReservationsWithExitDateAfterToday() throws MessageException;


}
