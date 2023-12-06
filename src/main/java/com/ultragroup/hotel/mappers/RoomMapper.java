package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.RoomDTO;
import com.ultragroup.hotel.models.entities.Room;

public interface RoomMapper {
    RoomDTO roomToRoomDTO(Room room);

    Room roomDTOToRoom(RoomDTO roomDTO);
}
