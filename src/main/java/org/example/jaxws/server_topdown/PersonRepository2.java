package org.example.jaxws.server_topdown;

import org.example.jaxws.server_topdown.Person;
import org.example.jaxws.server_topdown.PersonExistsEx_Exception;
import org.example.jaxws.server_topdown.PersonNotFoundEx_Exception;

import java.util.List;

public interface PersonRepository2 {
    List<Person> getAllPersons();
    Person getPerson(int id) throws PersonNotFoundEx_Exception;
    Person addPerson(int id, String name, int age) throws PersonExistsEx_Exception;
    boolean deletePerson(int id) throws PersonNotFoundEx_Exception;
    int countPersons();
}
