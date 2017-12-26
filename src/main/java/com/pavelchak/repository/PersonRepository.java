package com.pavelchak.repository;

import com.pavelchak.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "SELECT * FROM Person ORDER BY name LIMIT :topNumber", nativeQuery = true)
    List<Person> getPersonsTop(@Param("topNumber") int topNumber);

    @Query("SELECT p FROM Person p WHERE p.surname = :surname")
    Person getPersonsBySurname(@Param("surname") String surname);

    @Query(value = "SELECT p FROM Person p WHERE p.surname = ?1 AND p.name = ?2")
    Person getPersonsBySurnameAndName(String surname, String name);

    Person getPersonsBySurname2(String surname);

    Person getPersonsByEmail(@Param("email") String email);

    @Query("SELECT p FROM Person p WHERE p.surname LIKE %?1%")
    List<Person> getPersonsBySurnameLike(String surname);


    @Query("SELECT p FROM Person p WHERE p.id >= 10.0*?#{T(java.lang.Math).random()}")
    List<Person> getPersonsRandom();

    @Query("SELECT p FROM Person p WHERE p.surname = :#{#person.surname} AND p.name = :#{#person.name}")
    List<Person> getPersonsSearch(@Param("person") Person person);

    @Transactional
    @Modifying()
    @Query("UPDATE Person p SET p.name = ?1 WHERE p.surname = ?2")
    int setFixedNameForPerson(String name, String surname);

    @Transactional
    @Modifying()
    @Query("DELETE FROM Person p WHERE p.city.id = ?1")
    int deletePersonByCity(long cityId);



}
