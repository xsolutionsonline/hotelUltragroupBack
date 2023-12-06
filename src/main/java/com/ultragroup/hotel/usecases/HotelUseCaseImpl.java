package com.ultragroup.hotel.usecases;

import com.ultragroup.hotel.config.exceptions.MessageException;
import com.ultragroup.hotel.mappers.HotelMapper;
import com.ultragroup.hotel.models.dtos.HotelDTO;
import com.ultragroup.hotel.models.entities.Hotel;
import com.ultragroup.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class HotelUseCaseImpl implements HotelUseCase {

    @Autowired
    private HotelService hotelService;


    private final HotelMapper hotelMapper;

    public HotelUseCaseImpl(HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }

    @Override
    public HotelDTO create(HotelDTO hotelDTO) throws MessageException {
        return hotelMapper.hotelToHotelDTO(hotelService.create(hotelMapper.hotelDTOToHotel(hotelDTO)));
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return hotelMapper.convertToDTOList(hotelService.getAllHotels());
    }

    @Override
    public ResponseEntity<HotelDTO> getHotelById(Long id) {
        Optional<HotelDTO> hotelDTOOptional = hotelService.findById(id)
                .map(hotelMapper::hotelToHotelDTO);

        return hotelDTOOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body(HotelDTO.builder().message("Hotel No encontrado").build()));
    }

    @Override
    public List<HotelDTO> getHotelsByActive(boolean isActive) {
        return hotelMapper.convertToDTOList(hotelService.findByIsActive(isActive));
    }

    @Override
    public Optional<HotelDTO> updated(Long id, HotelDTO updatedHotel) {
        Optional<Hotel> hotelOptional = hotelService.findById(id);

        if (hotelOptional.isPresent()) {
            Hotel existingHotel = hotelOptional.get();
            existingHotel = hotelMapper.hotelDTOToHotel(updatedHotel);
            hotelService.create(existingHotel);
            return Optional.of(hotelMapper.hotelToHotelDTO(existingHotel));
        } else {
            return Optional.empty();
        }
    }

}
