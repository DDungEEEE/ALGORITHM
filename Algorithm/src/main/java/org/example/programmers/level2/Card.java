package org.example.programmers.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Card {
    public static void main(String[] args) {

    }

    static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> card2Queue = new ArrayDeque<>(Arrays.asList(cards2));

        Queue<String> card1Queue = new ArrayDeque<>(Arrays.asList(cards1));

        Queue<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));
        while (!goalQueue.isEmpty()){
            String currentWord = goalQueue.poll();

            if(!card1Queue.isEmpty() && card1Queue.peek().equals(currentWord)){
                card1Queue.poll();
            } else if (!card2Queue.isEmpty() && card2Queue.peek().equals(currentWord)) {
                card2Queue.poll();
            } else {
                    return "No";
            }
        }

        return "Yes";

    }
}
