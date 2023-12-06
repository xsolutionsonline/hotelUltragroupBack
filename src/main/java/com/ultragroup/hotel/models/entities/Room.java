package com.ultragroup.hotel.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfBeds;
    private double baseCost;
    private double taxes;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private LocationRoom location;
    private boolean active;
    private boolean hasWifi;
    private boolean hasBathtub;
    private boolean hasView;
    private boolean hasTV;
    private boolean allowsSmoking;
    private int numberOfPersons;
    @ManyToOne()
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}



