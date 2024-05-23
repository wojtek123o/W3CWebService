package org.example.jaxws.server;

import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;


public class PersonRepositoryImpl implements PersonRepository{

    private List<Person> personList;

    public PersonRepositoryImpl() {
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
    public Person getPerson(int id) throws PersonNotFoundEx {
        for(Person person: personList){
            if(person.getId() == id) {
                return person;
            }
        }
        throw new PersonNotFoundEx();
    }

    @Override
    public Person addPerson(int id, String name, int age) throws PersonExistsEx {
        for(Person person: personList){
            if(person.getId() == id) {
                throw new PersonExistsEx();
            }
        }
        Person person = new Person(id,name,age);
        personList.add(person);
        return person;
    }

    @Override
    public boolean deletePerson(int id) throws PersonNotFoundEx {
        for(Person person: personList){
            if(person.getId() == id) {
                personList.remove(person);
                return true;
            }
        }
        throw new PersonNotFoundEx();
    }

    @Override
    public Person updatePerson(int id, String name, int age) throws PersonNotFoundEx {
        for(int i = 0; i < personList.size(); i++){
            Person person = personList.get(i);
            if(person.getId() == id) {
                person.setFirstName(name);
                person.setAge(age);
                return person;
            }
        }
        throw new PersonNotFoundEx();
    }

    @Override
    public int countPersons() {
        return personList.size();
    }
}
