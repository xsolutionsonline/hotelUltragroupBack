package com.ultragroup.hotel.usecases;

import com.ultragroup.hotel.config.exceptions.MessageException;
import com.ultragroup.hotel.models.dtos.HotelDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface HotelUseCase {

    HotelDTO create(HotelDTO hotel) throws MessageException;

    Optional<HotelDTO> updated(Long id, HotelDTO updatedHotel);
    ResponseEntity<HotelDTO> getHotelById(Long id);
    List<HotelDTO> getAllHotels() throws MessageException;
    List<HotelDTO> getHotelsByActive(boolean isActive);

}
