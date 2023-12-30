package ma.aitbouna.reservationservice.web;

import ma.aitbouna.reservationservice.entities.Person;
import ma.aitbouna.reservationservice.entities.Reservation;
import ma.aitbouna.reservationservice.repository.PersonRepository;
import ma.aitbouna.reservationservice.service.PersonService;
import ma.aitbouna.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

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
        return personService.findAll();
    }

    @GetMapping("/persons/{id}")
    public Person personById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PostMapping("/persons")
    public void addperson(@RequestBody Person person) {
        personService.save(person);
    }


    @GetMapping("/reservation/{id}")
    public List<Reservation> reservationByUserId(@PathVariable Long id) {
        Person person = personService.findById(id);
        return reservationService.findByPerson(person);
    }

    @PostMapping("/reservation/{id}")
    public void reservation(@RequestBody Reservation reservation,@PathVariable Long id) {

        Person person = personService.findById(id);
        reservation.setPerson(person);
        reservationService.save(reservation);
    }
}
