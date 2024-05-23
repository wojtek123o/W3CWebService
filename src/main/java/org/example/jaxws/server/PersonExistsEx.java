package org.example.jaxws.server;

import jakarta.xml.ws.WebFault;

@WebFault
public class PersonExistsEx extends Exception{
    public PersonExistsEx() {
        super("This person already exists");
    }
}
