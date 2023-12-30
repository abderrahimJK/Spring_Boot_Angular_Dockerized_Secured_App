package ma.aitbouna.reservationservice;

import ma.aitbouna.reservationservice.entities.Person;
import ma.aitbouna.reservationservice.entities.Reservation;
import ma.aitbouna.reservationservice.service.PersonService;
import ma.aitbouna.reservationservice.service.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ReservationService reservationService, PersonService personService){
        return args -> {



            Person p1 = new Person(null, "Person 1", "Dev1@aitbouna.ma", "Dev",null);
            Person p2 = new Person(null, "Person 2", "Dev2@aitbouna.ma", "AI",null);
            Person p3 = new Person(null, "Person 3", "Dev3@aitbouna.ma", "Art", null);

            personService.save(p1);
            personService.save(p2);
            personService.save(p3);

            reservationService.save(new Reservation(null, "Reservation 1", "Dev", new Date("12/12/23"), "1h",p1));
            reservationService.save(new Reservation(null, "Reservation 2", "AI",  new Date("12/12/23"), "1.5h", p2));
            reservationService.save(new Reservation(null, "Reservation 3", "Art",  new Date("12/12/23"), "1h", p3));



        };
    }
}
