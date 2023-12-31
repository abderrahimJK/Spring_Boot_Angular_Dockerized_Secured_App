package ma.aitbouna.reservationservice.repository;

import ma.aitbouna.reservationservice.entities.Person;
import ma.aitbouna.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("select r from Reservation r where r.personId = ?1")
    List<Reservation> findByPersonId(Long id);

}
