package ma.aitbouna.reservationservice.service;

import ma.aitbouna.reservationservice.model.Ressource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ressource-service")
public interface RessourceRestClientService {

//    @GetMapping("/api/conference/{id}")
//    public Conference getConferenceById(@PathVariable Long id);
    @GetMapping("/api/ressources")
    public List<Ressource> ressourceList();
}
