package org.example.study.모의고사;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4,2};

        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Map<Integer, Integer> score = new HashMap<>();
        score.put(1, 0);
        score.put(2, 0);
        score.put(3, 0);

        for(int i = 0; i < answers.length; i++){
            if(first[i % 5] == answers[i]){
               score.put(1, score.get(1) + 1);
            }

            if(second[i % second.length] == answers[i]){
                score.put(2, score.get(2) + 1);
            }

            if(third[i % third.length] == answers[i]){
                score.put(3, score.get(3) + 1);
            }
        }

        int maxScore = score.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        int[] result = score.entrySet().stream()
                .filter(e -> e.getValue() == maxScore)
                .map(Map.Entry::getKey)
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(result));
    }
}
