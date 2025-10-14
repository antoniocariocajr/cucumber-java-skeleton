package io.cucumber.shouty.support;

import  io.cucumber.java.ParameterType;
import io.cucumber.shouty.Person;

public class ParameterTypes {

    @ParameterType("Lucy|Sean")
    public Person person(String name){
        return new Person(name);
    }
    @ParameterType("Lucy|Sean")
    public Person personShout(String name){
        return new Person(name);
    }
    @ParameterType("Lucy|Sean")
    public Person personHear(String name){
        return new Person(name);
    }
}
