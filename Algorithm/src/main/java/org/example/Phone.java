package org.example;

public abstract class Phone {

    String owner;

    Phone(String owner){
        this.owner = owner;
    }

    void turnOn(){
        System.out.println("폰 전원 킴");
    }

    void turnOff(){
        System.out.println("폰 전원 끔");
    }
}
