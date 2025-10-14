package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StepDefinitions {
    List<Person> persons = new ArrayList<>();
    Integer distance = 0;
    @Given("{person} is located {int} metres from Sean")
    public void lucy_is_located_metres_from_sean(Person person,Integer distance) {
        person.moveTo(distance);

        this.distance=distance;
        persons.add(person);
        persons.add(new Person("Sean"));
    }
    @Given("a person named {person}")
    public void a_person_named(Person person){
        persons.add(person);
    }
    @When("{personShout} shouts {string}")
    public void shouts(Person personShout, String message ) {
        personShout.shout(message);
        persons.forEach(p->{
            if (p.getName().equals(personShout.getName())){
                p.addMessagesShouts(message);
            }
            if (p.getName().equals("Lucy")&&distance<50){
                p.addMessagesHears(message);
            }
        });


    }
    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        Person personHears = new Person("Lucy");
        Person personShouts = new Person("Sean");
        persons.forEach(person -> {
            if (person.getName().equals(personHears.getName())){
                personHears.setMessagesHears(person.getMessagesHears());
            }
            if (person.getName().equals(personShouts.getName())){
                personShouts.setMessagesShouts(person.getMessagesShouts());
            }
        });
        assertEquals(personHears.getMessagesHears(),personShouts.getMessagesShouts());
    }

    @Then("Lucy hears different Sean's message")
    public void lucyHearsDifferentSeanSMessage() {
        Person personHears = new Person("Lucy");
        Person personShouts = new Person("Sean");
        persons.forEach(person -> {
            if (person.getName().equals(personHears.getName())){
                personHears.setMessagesHears(person.getMessagesHears());
            }
            if (person.getName().equals(personShouts.getName())){
                personShouts.setMessagesShouts(person.getMessagesShouts());
            }
        });
        assertNotEquals(personHears.getMessagesHears(),personShouts.getMessagesShouts());
    }
}
