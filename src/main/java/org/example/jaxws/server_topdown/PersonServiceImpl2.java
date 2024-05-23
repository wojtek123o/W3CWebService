package org.example.jaxws.server_topdown;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.jaxws.server_topdown.Person;
import org.example.jaxws.server_topdown.PersonExistsEx;
import org.example.jaxws.server_topdown.PersonNotFoundEx;
import org.example.jaxws.server_topdown.PersonService;
import org.example.jaxws.server_topdown.*;

import java.util.List;

@WebService(serviceName = "PersonService", endpointInterface = "org.example.jaxws.server_topdown.PersonService")
public class PersonServiceImpl2 implements PersonService {

    private PersonRepository2 dataRepository = new PersonRepositoryImpl2();

    @WebMethod
    public List<Person> getAllPersons() {
        System.out.println("...called getAllPersons");
        return dataRepository.getAllPersons();
    }

    @WebMethod
    public Person getPerson(int id) throws PersonNotFoundEx_Exception {
        System.out.println("...called getPerson id= "+id);
        return dataRepository.getPerson(id);
    }

    @WebMethod
    public Person addPerson(int id, String name, int age) throws PersonExistsEx_Exception {
        System.out.println("...called addPerson id= "+id);
        return dataRepository.addPerson(id, name, age);
    }

    @WebMethod
    public boolean deletePerson(int id) throws PersonNotFoundEx_Exception {
        System.out.println("...called deletePerson id= "+id);
        return dataRepository.deletePerson(id);
    }

    @WebMethod
    public int countPersons() {
        System.out.println("...called countPersons");
        return dataRepository.countPersons();
    }
}
