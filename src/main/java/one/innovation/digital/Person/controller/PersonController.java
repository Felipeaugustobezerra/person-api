package one.innovation.digital.Person.controller;


import lombok.AllArgsConstructor;
import one.innovation.digital.Person.dto.request.PersonDTO;
import one.innovation.digital.Person.dto.response.MessageResponseDTO;
import one.innovation.digital.Person.exception.PersonNotFoundException;
import one.innovation.digital.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpConstraint;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController{

    private PersonService personService;

    /*@Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//para mostrar o codigo 201 de criado
    //valid para usar a validacao para todos os campos
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
       return personService.createPerson(personDTO);
    }
    @GetMapping
    public List<PersonDTO> listAll(){
       return personService.listAll();
    }
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id,personDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }
}


