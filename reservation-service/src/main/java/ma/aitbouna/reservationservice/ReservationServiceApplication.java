package ma.aitbouna.reservationservice;

import ma.aitbouna.reservationservice.entities.Person;
import ma.aitbouna.reservationservice.entities.Reservation;
import ma.aitbouna.reservationservice.service.PersonService;
import ma.aitbouna.reservationservice.service.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ReservationService reservationService, PersonService personService){
        return args -> {


            List.of("Abderrahim","Fatima","Khalid").forEach(
                    p->{
                        Person person = Person
                                .builder()
                                .name(p)
                                .function("Developer")
                                .email(p + "@aitbouna.ma")
                                .build();
                        personService.save(person);

                    }
            );
            List.of("reservation 1","reservation 2","reservation 3").forEach(
                    r->{
                        Reservation reservation = Reservation
                                .builder()
                                .name(r)
                                .date(new Date())
                                .context(r + " context")
                                .resourceId(1L)
                                .personId(personService.findById(1L).getId())
                                .duration(30)
                                .build();
                        reservationService.save(reservation);

                    }
            );



        };
    }
}
