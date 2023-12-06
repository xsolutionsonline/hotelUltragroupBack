package com.ultragroup.hotel.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelDTO {
    private Long id;
    private String name;
    private Integer starCategory;
    private String description;
    private Date registrationDate;
    private UserDTO userCreated;
    private boolean active;
    private List<RoomDTO> rooms;
    private String country;
    private String department;
    private String city;
    private String message;
}
