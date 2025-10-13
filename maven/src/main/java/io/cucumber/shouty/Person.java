package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<String> messagesHears;
    private String name;

    public Person(String name) {
        this.name = name;
        messagesHears = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessagesHears() {
        return messagesHears;
    }

    public void addMessagesHears(String messagesHear) {
        this.messagesHears.add(messagesHear);
    }

    public void moveTo(Integer distance){
        System.out.println(name + " is located " + distance + " metres from");
    }
    public void shout(String message){
        System.out.println(message);
    }
}
