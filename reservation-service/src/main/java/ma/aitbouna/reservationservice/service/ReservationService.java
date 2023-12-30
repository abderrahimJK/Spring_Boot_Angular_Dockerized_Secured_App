package ma.aitbouna.reservationservice.service;


import ma.aitbouna.reservationservice.entities.Person;
import ma.aitbouna.reservationservice.entities.Reservation;
import ma.aitbouna.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    ReservationRepository ressourceRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.ressourceRepository = reservationRepository;
    }

    public Reservation save(Reservation reservation){
        return ressourceRepository.save(reservation);
    }

    public Reservation findById(Long id){
        return ressourceRepository.findById(id).get();
    }

    public List<Reservation> findAll(){
        return ressourceRepository.findAll();
    }

    public List<Reservation> findByPerson(Person person) {
        return ressourceRepository.findByPerson(person);
    }
}
