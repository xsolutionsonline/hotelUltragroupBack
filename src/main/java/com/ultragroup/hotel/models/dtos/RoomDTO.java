package com.ultragroup.hotel.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {
    private Long id;
    private int numberOfBeds;
    private double baseCost;
    private double taxes;
    private String type;
    private LocationRoomDTO location;
    private boolean active;
    private boolean hasWifi;
    private boolean hasBathtub;
    private boolean hasView;
    private boolean hasTV;
    private boolean allowsSmoking;
    private int numberOfPersons;
}
