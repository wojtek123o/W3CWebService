package org.example.jaxws.server_topdown;

import org.example.jaxws.server_topdown.Person;
import org.example.jaxws.server_topdown.PersonExistsEx_Exception;
import org.example.jaxws.server_topdown.PersonNotFoundEx_Exception;
import org.example.jaxws.server_topdown.PersonRepository2;

import java.util.ArrayList;
import java.util.List;


public class PersonRepositoryImpl2 implements PersonRepository2 {

    private List<Person> personList;

    public PersonRepositoryImpl2() {
        personList = new ArrayList<>();
        personList.add(new Person(1, "Mariusz",9));
        personList.add(new Person(2, "Tomek",8));
        personList.add(new Person(3, "Andrzej",7));
    }

    @Override
    public List<Person> getAllPersons() {
        return personList;
    }

    @Override
    public Person getPerson(int id) throws PersonNotFoundEx_Exception {
        for(Person person: personList){
            if(person.getId() == id) {
                return person;
            }
        }
        throw new PersonNotFoundEx_Exception();
    }

    @Override
    public Person addPerson(int id, String name, int age) throws PersonExistsEx_Exception {
        for(Person person: personList){
            if(person.getId() == id) {
                throw new PersonExistsEx_Exception();
            }
        }
        Person person = new Person(id,name,age);
        personList.add(person);
        return person;
    }

    @Override
    public boolean deletePerson(int id) throws PersonNotFoundEx_Exception {
        for(Person person: personList){
            if(person.getId() == id) {
                personList.remove(person);
                return true;
            }
        }
        throw new PersonNotFoundEx_Exception();
    }

    @Override
    public int countPersons() {
        return personList.size();
    }
}
