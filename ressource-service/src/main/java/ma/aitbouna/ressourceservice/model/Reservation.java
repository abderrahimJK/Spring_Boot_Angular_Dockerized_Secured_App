package ma.aitbouna.ressourceservice.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    private Long id;
    private String name;
    private String context;
    private Date date;
    private String duration;
}
