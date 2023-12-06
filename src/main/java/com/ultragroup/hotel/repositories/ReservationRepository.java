package com.ultragroup.hotel.repositories;

import com.ultragroup.hotel.models.entities.Hotel;
import com.ultragroup.hotel.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.hotel.userCreated.id = :userId")
    List<Reservation> findByHotelUserCreatedId(@Param("userId") Long userId);

    List<Reservation> findByExitDateAfter(Date exitDate);

}
