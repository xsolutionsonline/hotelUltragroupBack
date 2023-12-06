package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.entities.Hotel;
import com.ultragroup.hotel.models.dtos.HotelDTO;

import java.util.List;


public interface HotelMapper {
    HotelDTO hotelToHotelDTO(Hotel hotel);

    Hotel hotelDTOToHotel(HotelDTO hotelDTO);

    List<HotelDTO> convertToDTOList(List<Hotel> hotels);
}
