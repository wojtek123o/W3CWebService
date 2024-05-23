package org.example.jaxws.server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface PersonService {

    @WebMethod(action = "http://server.jaxws.example.org/PersonService/getAllPersons")
    List<Person> getAllPersons();

    @WebMethod(action = "http://server.jaxws.example.org/PersonService/getPerson")
    Person getPerson(@WebParam(name = "id") int id) throws PersonNotFoundEx;

    @WebMethod(action = "http://server.jaxws.example.org/PersonService/addPerson")
    Person addPerson(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "age") int age) throws PersonExistsEx;

    @WebMethod(action = "http://server.jaxws.example.org/PersonService/updatePerson")
    Person updatePerson(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "age") int age) throws PersonNotFoundEx;

    @WebMethod(action = "http://server.jaxws.example.org/PersonService/deletePerson")
    boolean deletePerson(@WebParam(name = "id") int id) throws PersonNotFoundEx;

    @WebMethod(action = "http://server.jaxws.example.org/PersonService/countPersons")
    int countPersons();
}
