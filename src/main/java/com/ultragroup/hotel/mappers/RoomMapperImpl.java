package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.RoomDTO;
import com.ultragroup.hotel.models.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapperImpl implements  RoomMapper{
   @Autowired
    private  LocationRoomMapper locationRoomMapper;
    @Override
    public RoomDTO roomToRoomDTO(Room room) {
        return RoomDTO.builder()
                .id(room.getId())
                .numberOfBeds(room.getNumberOfBeds())
                .baseCost(room.getBaseCost())
                .taxes(room.getTaxes())
                .type(room.getType())
                .location(locationRoomMapper.locationRoomToLocationRoomDTO(room.getLocation()))
                .active(room.isActive())
                .hasWifi(room.isHasWifi())
                .hasBathtub(room.isHasBathtub())
                .hasView(room.isHasView())
                .hasTV(room.isHasTV())
                .allowsSmoking(room.isAllowsSmoking())
                .numberOfPersons(room.getNumberOfPersons())
                .build();
    }

    @Override
    public Room roomDTOToRoom(RoomDTO roomDTO) {
        return Room.builder()
                .id(roomDTO.getId())
                .numberOfBeds(roomDTO.getNumberOfBeds())
                .baseCost(roomDTO.getBaseCost())
                .taxes(roomDTO.getTaxes())
                .type(roomDTO.getType())
                .location(locationRoomMapper.locationRoomDTOTolocationRoom(roomDTO.getLocation()))
                .active(roomDTO.isActive())
                .hasWifi(roomDTO.isHasWifi())
                .hasBathtub(roomDTO.isHasBathtub())
                .hasView(roomDTO.isHasView())
                .hasTV(roomDTO.isHasTV())
                .allowsSmoking(roomDTO.isAllowsSmoking())
                .numberOfPersons(roomDTO.getNumberOfPersons())
                .build();
    }

}
