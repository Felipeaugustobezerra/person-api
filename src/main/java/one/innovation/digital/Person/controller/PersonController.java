package one.innovation.digital.Person.controller;


import one.innovation.digital.Person.dto.response.MessageResponseDTO;
import one.innovation.digital.Person.entity.Person;
import one.innovation.digital.Person.repository.PersonRepository;
import one.innovation.digital.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//para mostrar o codigo 201 de criado
    public MessageResponseDTO createPerson(@RequestBody Person person){
       return personService.createPerson(person);
    }
}


