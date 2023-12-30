package ma.aitbouna.ressourceservice.web;

import ma.aitbouna.ressourceservice.entities.Ressource;
import ma.aitbouna.ressourceservice.service.RessourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RessourceRestController {
    private RessourceService ressourceService;

    public RessourceRestController(RessourceService ressourceService) {
        this.ressourceService = ressourceService;
    }

    @GetMapping("/ressources")
    public List<Ressource> keynotesList(){
        return ressourceService.findAll();
    }

    @GetMapping("/ressources/{id}")
    public Ressource ressourceById(@PathVariable Long id){
        return ressourceService.findById(id);
    }

    @PostMapping("/ressources")
    public void addRessource(@RequestBody Ressource ressources) {
        ressourceService.save(ressources);
    }
}
