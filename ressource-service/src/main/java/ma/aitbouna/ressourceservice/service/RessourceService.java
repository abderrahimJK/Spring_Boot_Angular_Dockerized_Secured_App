package ma.aitbouna.ressourceservice.service;

import ma.aitbouna.ressourceservice.entities.Ressource;
import ma.aitbouna.ressourceservice.repository.RessourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceService {

    RessourceRepository ressourceRepository;

    public RessourceService(RessourceRepository ressourceRepository) {
        this.ressourceRepository = ressourceRepository;
    }

    public Ressource save(Ressource ressource){
        return ressourceRepository.save(ressource);
    }

    public Ressource findById(Long id){
        return ressourceRepository.findById(id).get();
    }

    public List<Ressource> findAll(){
        return ressourceRepository.findAll();
    }
}
