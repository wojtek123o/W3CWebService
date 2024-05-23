package org.example.jaxws.client;

import org.example.jaxws.server_topdown.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PS2Client {
    public static void main(String[] args) throws MalformedURLException, PersonNotFoundEx_Exception, PersonExistsEx_Exception {
        int num = -1;
        URL adr = new URL("http://localhost:8082/personservice?wsdl");
        PersonService_Service pService = new PersonService_Service();
        PersonService personServiceProxy = pService.getPersonServiceImplPort();

        num = personServiceProxy.countPersons();
        System.out.println("Num of Persons = " +num);

        List<Person> personList = personServiceProxy.getAllPersons();
        for (Person person: personList) {
            System.out.println("Id: "+person.getId() +", Name: " +person.getFirstName() +", Age: " +person.getAge());
        }

        System.out.println("Get person id");
        Person person1 = personServiceProxy.getPerson(2);
        System.out.println("Person with id " +person1.getId()+": Id: "+person1.getId() +", Name: " +person1.getFirstName() +", Age: " +person1.getAge());

        System.out.println("Adding person");
        personServiceProxy.addPerson(4,"Maciek", 21);
        List<Person> personList2 = personServiceProxy.getAllPersons();
        for (Person person: personList2) {
            System.out.println("Id: "+person.getId() +", Name: " +person.getFirstName() +", Age: " +person.getAge());
        }

        System.out.println("Deleting person");
        personServiceProxy.deletePerson(4);
        List<Person> personList3 = personServiceProxy.getAllPersons();
        for (Person person: personList3) {
            System.out.println("Id: "+person.getId() +", Name: " +person.getFirstName() +", Age: " +person.getAge());
        }
    }
}
