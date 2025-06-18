package org.example.study;

import java.time.Instant;

public class Base extends Super{
    private final Instant instant = Instant.now();

    @Override
    public void overrideMe(){
        System.out.println("hi");

    }

    public static void main(String[] args) {
        Base base = new Base();
        base.overrideMe();
    }
}


