package com.ultragroup.hotel.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuestDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String contact;
    private String email;
    private String password;
    private boolean active;
    private String role;
    private String gender;
    private String documentType;
    private String documentNumber;
    private String phoneNumber;
}
