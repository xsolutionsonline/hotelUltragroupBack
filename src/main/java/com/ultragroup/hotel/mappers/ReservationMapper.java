package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.HotelDTO;
import com.ultragroup.hotel.models.dtos.ReservationDTO;
import com.ultragroup.hotel.models.entities.Hotel;
import com.ultragroup.hotel.models.entities.Reservation;

import java.util.List;


public interface ReservationMapper {
    ReservationDTO reservationToReservationDTO(Reservation reservation);

    Reservation reservationDTOToReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> convertToDTOList(List<Reservation> reservations);
}
