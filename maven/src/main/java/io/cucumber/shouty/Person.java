package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private List<String> messagesHears;
    private List<String> messagesShouts;
    private String name;

    public Person(String name) {
        this.name = name;
        messagesHears = new ArrayList<>();
        messagesShouts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessagesHears(List<String> messagesHears) {
        this.messagesHears = messagesHears;
    }

    public void setMessagesShouts(List<String> messagesShouts) {
        this.messagesShouts = messagesShouts;
    }

    public List<String> getMessagesHears() {
        return messagesHears;
    }

    public void addMessagesHears(String messagesHear) {
        this.messagesHears.add(messagesHear);
    }

    public List<String> getMessagesShouts(){
        return messagesShouts;
    }

    public void addMessagesShouts(String messageShout){
        this.messagesShouts.add(messageShout);
    }

    public void moveTo(Integer distance){
        System.out.println(name + " is located " + distance + " metres from");
    }
    public void shout(String message){
        System.out.println(message);
    }
}
