package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.RoomDTO;
import com.ultragroup.hotel.models.entities.Hotel;
import com.ultragroup.hotel.models.dtos.HotelDTO;
import com.ultragroup.hotel.models.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapperImpl implements  HotelMapper{

    @Autowired
    private  RoomMapper roomMapper;

    @Autowired
    private  UserMapper userMapper;

    @Override
    public HotelDTO hotelToHotelDTO(Hotel hotel) {
        List<RoomDTO> roomDTOs = (hotel.getRooms() != null) ?
                hotel.getRooms().stream()
                        .map(roomMapper::roomToRoomDTO)
                        .collect(Collectors.toList()) :
                Collections.emptyList();


        return HotelDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .starCategory(hotel.getStarCategory())
                .description(hotel.getDescription())
                .registrationDate(hotel.getRegistrationDate())
                .userCreated(userMapper.userToUserDTO(hotel.getUserCreated()))
                .active(hotel.isActive())
                .rooms(roomDTOs)
                .country(hotel.getCountry())
                .department(hotel.getDepartment())
                .city(hotel.getCity())
                .build();
    }

    @Override
    public Hotel hotelDTOToHotel(HotelDTO hotelDTO) {
        List<Room> roomDTOs = (hotelDTO.getRooms() != null) ?
                hotelDTO.getRooms().stream()
                        .map(roomMapper::roomDTOToRoom)
                        .collect(Collectors.toList()) :
                Collections.emptyList();
        return Hotel.builder()
                .id(hotelDTO.getId())
                .name(hotelDTO.getName())
                .starCategory(hotelDTO.getStarCategory())
                .description(hotelDTO.getDescription())
                .registrationDate(hotelDTO.getRegistrationDate())
                .userCreated((hotelDTO.getUserCreated() != null) ?
                        userMapper.userDTOToUser(hotelDTO.getUserCreated()) :
                        null)
                .active(hotelDTO.isActive())
                .rooms(roomDTOs)
                .country(hotelDTO.getCountry())
                .department(hotelDTO.getDepartment())
                .city(hotelDTO.getCity())
                .build();
    }


    @Override
    public List<HotelDTO> convertToDTOList(List<Hotel> hotels) {
        return hotels.stream()
                .map(this::hotelToHotelDTO)
                .collect(Collectors.toList());
    }

}
