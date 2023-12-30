package ma.aitbouna.ressourceservice.service;

import ma.aitbouna.ressourceservice.model.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "reservation-service")
public interface ReservationRestClientService {

    @PostMapping("/api/reservation/{id}")
    public Reservation createReservationForResource(@PathVariable Long id);

}
