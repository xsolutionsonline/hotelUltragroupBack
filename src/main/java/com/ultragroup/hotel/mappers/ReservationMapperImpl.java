package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.*;
import com.ultragroup.hotel.models.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapperImpl implements  ReservationMapper{

    @Autowired
    private  HotelMapper hotelMapper;

    @Autowired
    private  RoomMapper roomMapper;

    @Autowired
    private  GuestMapper userMapper;

    @Autowired
    private  EmergencyContactMapper emergencyContactMapper;

    @Override
    public ReservationDTO reservationToReservationDTO(Reservation reservation) {
        List<GuestDTO> userDTOs = (reservation.getUsers() != null) ?
                reservation.getUsers().stream()
                        .map(userMapper::userToUserDTO)
                        .collect(Collectors.toList()) :
                Collections.emptyList();

        return ReservationDTO.builder()
                .id(reservation.getId())
                .hotel(hotelMapper.hotelToHotelDTO(reservation.getHotel()))
                .entryDate(reservation.getEntryDate())
                .exitDate(reservation.getExitDate())
                .numberOfPersons(reservation.getNumberOfPersons())
                .room(roomMapper.roomToRoomDTO(reservation.getRoom()))
                .users(userDTOs)
                .emergencyContact(emergencyContactMapper.emergencyToEmergencyDTO(reservation.getEmergencyContact()))
                .build();
    }


    @Override
    public Reservation reservationDTOToReservation(ReservationDTO reservationDTO) {
        List<Guest> users = (reservationDTO.getUsers() != null) ?
                reservationDTO.getUsers().stream()
                        .map(userMapper::userDTOToUser)
                        .collect(Collectors.toList()) :
                Collections.emptyList();

        return Reservation.builder()
                .id(reservationDTO.getId())
                .hotel(hotelMapper.hotelDTOToHotel(reservationDTO.getHotel()))
                .entryDate(reservationDTO.getEntryDate())
                .exitDate(reservationDTO.getExitDate())
                .numberOfPersons(reservationDTO.getNumberOfPersons())
                .room(roomMapper.roomDTOToRoom(reservationDTO.getRoom()))
                .users(users)
                .emergencyContact(emergencyContactMapper.emergencyContactDTOToEmergencyContact(reservationDTO.getEmergencyContact()))
                .build();
    }



    @Override
    public List<ReservationDTO> convertToDTOList(List<Reservation> reservations) {
        return reservations.stream()
                .map(this::reservationToReservationDTO)
                .collect(Collectors.toList());
    }

}
