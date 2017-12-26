package com.pavelchak.DTO;

import com.pavelchak.controller.BookController;
import com.pavelchak.domain.Person;
import com.pavelchak.exceptions.NoSuchBookException;
import com.pavelchak.exceptions.NoSuchPersonException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class TestPersonDTO extends ResourceSupport {
    Person person;
    public TestPersonDTO(Person person)  {
        this.person=person;
    }

    public Long getPersonId() {
        return person.getId();
    }

    public String getSurname() {
        return person.getSurname();
    }

    public String getName() {
        return person.getName();
    }

    public String getEmail() {
        return person.getEmail();
    }

    public String getCity() {
        if(person.getCity()==null) return "";
        return person.getCity().getCity();
    }

    public String getStreet() {
        return person.getStreet();
    }

    public String getApartment() {
        return person.getApartment();
    }
}
