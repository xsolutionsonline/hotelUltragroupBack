package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.LocationRoomDTO;
import com.ultragroup.hotel.models.entities.LocationRoom;
import org.springframework.stereotype.Component;

@Component
public class LocationRoomMapperImpl implements  LocationRoomMapper{

    @Override
    public LocationRoomDTO locationRoomToLocationRoomDTO(LocationRoom locationRoom) {
        return LocationRoomDTO.builder()
                .id(locationRoom.getId())
                .floor(locationRoom.getFloor())
                .roomNumber(locationRoom.getRoomNumber())
                .build();
    }

    @Override
    public LocationRoom locationRoomDTOTolocationRoom(LocationRoomDTO locationRoomDTO) {
        return LocationRoom.builder()
                .id(locationRoomDTO.getId())
                .floor(locationRoomDTO.getFloor())
                .roomNumber(locationRoomDTO.getRoomNumber())
                .build();
    }
}
