package com.pavelchak.controller;

import com.pavelchak.DTO.PersonDTO;
import com.pavelchak.DTO.TestPersonDTO;
import com.pavelchak.domain.Person;
import com.pavelchak.exceptions.NoSuchBookException;
import com.pavelchak.exceptions.NoSuchCityException;
import com.pavelchak.exceptions.NoSuchPersonException;
import com.pavelchak.service.TestPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class TestPersonController {
    @Autowired
    TestPersonService testPersonService;

    @GetMapping(value = "/test/personSurname/{surname}")
    public TestPersonDTO getPersonsBySurname(@PathVariable String surname) {
        Person persons = testPersonService.getPersonsBySurname(surname);
        return new TestPersonDTO(persons);
    }

    @GetMapping(value = "/test/personSurnameName/{surname}/{name}")
    public TestPersonDTO getPersonsBySurname(@PathVariable String surname, @PathVariable String name) {
        Person persons = testPersonService.getPersonsBySurnameAndName(surname, name);
        return new TestPersonDTO(persons);
    }

    @GetMapping(value = "/test/personSurname2/{surname}")
    public TestPersonDTO getPersonsBySurname2(@PathVariable("surname") String surname) {
        Person persons = testPersonService.getPersonsBySurname2(surname);
        return new TestPersonDTO(persons);
    }

    @PostMapping(value = "/test/personEmail")
    public TestPersonDTO getPersonsByEmail(@RequestBody String p) {
        Person person = testPersonService.getPersonsByEmail(p);
        return new TestPersonDTO(person);
    }


    @GetMapping(value = "/test/personSurnameTop/{topNumber}")
    public List<TestPersonDTO> getPersonsTop(@PathVariable int topNumber) throws NoSuchPersonException, NoSuchBookException {
        List<Person> persons = testPersonService.getPersonsTop(topNumber);

        List<TestPersonDTO> personsDTO = new ArrayList<>();
        for (Person entity : persons) {
            personsDTO.add(new TestPersonDTO(entity));
        }
        return personsDTO;
    }

    @GetMapping(value = "/test/personSurnameLike/{surname}")
    public List<TestPersonDTO> getPersonsBySurnameLike(@PathVariable String surname) {
        List<Person> persons = testPersonService.getPersonsBySurnameLike(surname);
        List<TestPersonDTO> personsDTO = new ArrayList<>();
        for (Person entity : persons) {
            personsDTO.add(new TestPersonDTO(entity));
        }
        return personsDTO;
    }

    @GetMapping(value = "/test/random")
    public List<TestPersonDTO> getPersonsRandom() {
        List<Person> persons = testPersonService.getPersonsRandom();
        List<TestPersonDTO> personsDTO = new ArrayList<>();
        for (Person entity : persons) {
            personsDTO.add(new TestPersonDTO(entity));
        }
        return personsDTO;
    }

    @PutMapping(value = "/test/updateperson/{surname}/{name}")
    public int setFixedNameForPerson(@PathVariable String surname, @PathVariable String name) {
        return testPersonService.setFixedNameForPerson(surname, name);
    }

    @DeleteMapping(value = "/test/deleteperson/{city_id}}")
    public int deletePersonByCity(@PathVariable long city_id) {
        return testPersonService.deletePersonByCity(city_id);
    }


}
