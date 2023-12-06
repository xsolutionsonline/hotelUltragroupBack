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
public class ReservationDTO {
    private Long id;
    private HotelDTO hotel;
    private Date entryDate;
    private Date exitDate;
    private RoomDTO room;
    private List<GuestDTO> users;
    private int numberOfPersons;
    private EmergencyContactDTO emergencyContact;
    private String message;
}

