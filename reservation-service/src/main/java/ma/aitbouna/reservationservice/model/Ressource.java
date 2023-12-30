package ma.aitbouna.reservationservice.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ressource {

    private Long id;
    private String name;
    private String type;
}
