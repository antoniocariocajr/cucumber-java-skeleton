package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    Person lucy = new Person("Lucy");
    Person sean = new Person("Sean");
    String messageFromSean;
    @Given("Lucy is located {int} metres from Sean")
    public void lucy_is_located_metres_from_sean(Integer distance) {

        lucy.moveTo(distance);
    }
    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        sean.shout(message);
        lucy.addMessagesHears(message);
        messageFromSean=message;
    }
    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {

        assertEquals(Collections.singletonList(messageFromSean),lucy.getMessagesHears());
    }
}
