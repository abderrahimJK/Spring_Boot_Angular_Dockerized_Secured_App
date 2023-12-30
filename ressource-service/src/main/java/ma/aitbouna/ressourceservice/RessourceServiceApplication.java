package ma.aitbouna.ressourceservice;

import ma.aitbouna.ressourceservice.entities.MatType;
import ma.aitbouna.ressourceservice.entities.Ressource;
import ma.aitbouna.ressourceservice.service.RessourceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RessourceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RessourceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RessourceService ressourceService){
        return args -> {
            ressourceService.save(new Ressource(null, "Camera", MatType.MATERIEL_INF0));
            ressourceService.save(new Ressource(null, "Stand", MatType.MATERIEL_INF0));
            ressourceService.save(new Ressource(null, "Car", MatType.MATERIEL_AUDIO_VUSUEL));
        };
    }

}
