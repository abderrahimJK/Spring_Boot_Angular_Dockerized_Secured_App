package ma.aitbouna.reservationservice.repository;

import ma.aitbouna.reservationservice.entities.Person;
import ma.aitbouna.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findByPerson(Person person);
}
