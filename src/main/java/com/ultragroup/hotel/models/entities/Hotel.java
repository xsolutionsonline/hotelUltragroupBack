package com.ultragroup.hotel.models.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer starCategory;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userCreated;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    private String country;
    private String department;
    private String city;
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id")
    private List<Room> rooms;

}


