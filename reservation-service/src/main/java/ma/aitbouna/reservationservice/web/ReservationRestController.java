package ma.aitbouna.reservationservice.web;

import ma.aitbouna.reservationservice.entities.Person;
import ma.aitbouna.reservationservice.entities.Reservation;
import ma.aitbouna.reservationservice.repository.PersonRepository;
import ma.aitbouna.reservationservice.service.PersonService;
import ma.aitbouna.reservationservice.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationRestController {
    private ReservationService reservationService;
    private PersonService personService;

    public ReservationRestController(ReservationService reservationService, PersonService personService) {
        this.reservationService = reservationService;

        this.personService = personService;
    }

    @GetMapping("/reservations")
    public List<Reservation> keynotesList(){
        return reservationService.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation reservationById(@PathVariable Long id){
        return reservationService.findById(id);
    }

    @PostMapping("/reservations")
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
    }


    /**************************Person service APIs**************************/


    @GetMapping("/persons")
    public List<Person> personList(){
        List<Person> personList = personService.findAll();
        for(Person person: personList){
            List<Reservation> list = reservationService.findByPersonId(person.getId());
            person.setReservations(list);
        }
        return personList;

    }

    @GetMapping("/persons/{id}/reservations")
    public List<Reservation> personById(@PathVariable Long id){
       return reservationService.findByPersonId(id);
    }

    @PostMapping("/persons")
    public void addperson(@RequestBody Person person) {
        personService.save(person);
    }


    @PostMapping("/reservation/{id}")
    public void reservation(@RequestBody Reservation reservation,@PathVariable Long id) {

        reservationService.save(reservation);
    }
}
