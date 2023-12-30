package ma.aitbouna.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String context;
    private Date date;
    private String duration;
    @ManyToOne()
    private Person person;
}
