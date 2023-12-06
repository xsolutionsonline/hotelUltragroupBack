package com.ultragroup.hotel.usecases;

import com.ultragroup.hotel.config.exceptions.MessageException;
import com.ultragroup.hotel.mappers.ReservationMapper;
import com.ultragroup.hotel.models.dtos.ReservationDTO;
import com.ultragroup.hotel.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public class ReservationUseCaseImpl implements ReservationUseCase {

    @Autowired
    private ReservationService reservationService;


    private final ReservationMapper reservationMapper;

    public ReservationUseCaseImpl(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ReservationDTO create(ReservationDTO reservationDTO) throws MessageException {
        return reservationMapper.reservationToReservationDTO(reservationService.create(reservationMapper.reservationDTOToReservation(reservationDTO)));
    }

    @Override
    public List<ReservationDTO> getAllReservation() {
        return reservationMapper.convertToDTOList(reservationService.getAllReservation());
    }

    @Override
    public ResponseEntity<ReservationDTO> getReservationById(Long id) {
        Optional<ReservationDTO> reservationDTOptional = reservationService.findById(id)
                .map(reservationMapper::reservationToReservationDTO);

        return reservationDTOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body(ReservationDTO.builder().message("Hotel No encontrado").build()));
    }

    @Override
    public List<ReservationDTO> getAllReservationHotelUserCreatedId(Long isUser) {
        return reservationMapper.convertToDTOList(reservationService.findByHotelUserCreatedId(isUser));
    }

    @Override
    public List<ReservationDTO> getReservationsWithExitDateAfterToday() throws MessageException {
        return reservationMapper.convertToDTOList(reservationService.findByExitDateAfter());
    }

}
