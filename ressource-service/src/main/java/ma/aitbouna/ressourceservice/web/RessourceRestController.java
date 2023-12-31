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

    @GetMapping("/resources")
    public List<Ressource> keynotesList(){
        return ressourceService.findAll();
    }

    @GetMapping("/resources/{id}")
    public Ressource ressourceById(@PathVariable Long id){
        return ressourceService.findById(id);
    }

    @PostMapping("/resources")
    public void addResource(@RequestBody Ressource resources) {
        ressourceService.save(resources);
    }
}
