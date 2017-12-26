package com.pavelchak.service;

import com.pavelchak.repository.CityRepository;
import com.pavelchak.repository.PersonRepository;
import com.pavelchak.domain.City;
import com.pavelchak.domain.Person;
import com.pavelchak.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestPersonService {
    @Autowired
    PersonRepository personRepository;

    public Person getPersonsBySurname(String surname) {
        return personRepository.getPersonsBySurname(surname);
    }

    public Person getPersonsBySurnameAndName(String surname, String name) {
        return personRepository.getPersonsBySurnameAndName(surname, name);
    }

    public Person getPersonsBySurname2(String surname) {
        return personRepository.getPersonsBySurname2(surname);
    }

    public Person getPersonsByEmail(String email) {
        return personRepository.getPersonsByEmail(email);
    }

    public List<Person> getPersonsTop(int topNumber) {
        return personRepository.getPersonsTop(topNumber);
    }

    public List<Person> getPersonsBySurnameLike(String surname) {
        return personRepository.getPersonsBySurnameLike(surname);
    }

    public List<Person> getPersonsRandom() {
        return personRepository.getPersonsRandom();
    }

    public List<Person> getPersonsSearch(Person person) {
        return personRepository.getPersonsSearch(person);
    }


    public int setFixedNameForPerson(String name, String surname) {
        return personRepository.setFixedNameForPerson(name, surname);
    }

    public int deletePersonByCity(long cityId) {
        return personRepository.deletePersonByCity(cityId);
    }

}
