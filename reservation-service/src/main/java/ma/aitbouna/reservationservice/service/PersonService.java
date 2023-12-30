package ma.aitbouna.reservationservice.service;


import ma.aitbouna.reservationservice.entities.Person;
import ma.aitbouna.reservationservice.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository reservationRepository) {
        this.personRepository = reservationRepository;
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public Person findById(Long id){
        return personRepository.findById(id).get();
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }
}
