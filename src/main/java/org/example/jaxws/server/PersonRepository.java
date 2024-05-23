package org.example.jaxws.server;

import java.util.List;

public interface PersonRepository {
    List<Person> getAllPersons();
    Person getPerson(int id) throws PersonNotFoundEx;
    Person addPerson(int id, String name, int age) throws PersonExistsEx;
    boolean deletePerson(int id) throws PersonNotFoundEx;
    Person updatePerson(int id, String name, int age) throws PersonNotFoundEx;
    int countPersons();
}
