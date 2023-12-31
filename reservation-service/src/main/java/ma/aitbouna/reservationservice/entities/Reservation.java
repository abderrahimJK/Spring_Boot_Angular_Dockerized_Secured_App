package ma.aitbouna.reservationservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.aitbouna.reservationservice.model.Ressource;

import java.util.Date;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String context;
    private Date date;
    private int duration;
    private Long personId;
    private Long resourceId;
    @Transient
    private Ressource resource;
}
