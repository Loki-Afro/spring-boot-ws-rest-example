package com.github.zarathustra616.webservice.endpoint;


import https.github_com.zarathustra616.sample.schema.beans.AddPersonRequest;
import https.github_com.zarathustra616.sample.schema.beans.AddPersonResponse;
import https.github_com.zarathustra616.sample.schema.beans.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
//best way would be to get the ws-methods from an interface to implement a client on that interface
public class PersonServiceEndpoint {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceEndpoint.class);

    public final static String  NAMESPACE        = "https://github.com/Zarathustra616/sample/schema/beans";
    public static final String  ADD_PERSON_REQUEST = "add-person-request";

    @PayloadRoot(localPart = ADD_PERSON_REQUEST, namespace = NAMESPACE)
    @ResponsePayload
    public AddPersonResponse addPerson(@RequestPayload final AddPersonRequest request) {
        Person person = request.getPerson();
//        handle person somehow
        String name = person.getName();
        if (name != null && name.equals("Zarathustra")) {
            log.info("Person " + name + " is your god");
        } else {
            log.info(name + " is not god");
        }
        AddPersonResponse response = new AddPersonResponse();
        response.setPerson(person);
        return response;
    }
}
