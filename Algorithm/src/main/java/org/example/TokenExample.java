package org.example;

import java.util.StringTokenizer;

public class TokenExample {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer;

        String str = "THIS WORD IS FUCKING GOOD";
        String[] result = str.split(" ");
        int i = 0;
        int count = result.length;
        while (count > 0){
            System.out.println(result[i]);
            i++;
            count--;
        }
    }
}
