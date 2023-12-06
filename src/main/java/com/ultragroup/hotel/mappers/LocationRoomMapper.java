package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.LocationRoomDTO;
import com.ultragroup.hotel.models.entities.LocationRoom;

public interface LocationRoomMapper {
    LocationRoomDTO locationRoomToLocationRoomDTO(LocationRoom locationRoom);

    LocationRoom locationRoomDTOTolocationRoom(LocationRoomDTO locationRoomDTO);
}
