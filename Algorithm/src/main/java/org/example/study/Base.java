package org.example.study;

import java.time.Instant;

public class Base extends Super{
    private final Instant instant = Instant.now();

    public Base(){
        System.out.println("지금 시간은: " +instant);
    }

    @Override
    public void overrideMe(){
        System.out.println("hi");

    }

    public static void main(String[] args) {
        Base base = new Base();
        base.overrideMe();
    }
}


