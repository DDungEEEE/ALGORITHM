package org.example.study.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Marathon {
    public String solution(String[] participant, String[] completion){
        Map<String, Integer> participants = new HashMap<>();
        for(String p :participant){
            participants.put(p, participants.getOrDefault(p, 0) + 1);
        }

        for(String c : completion){
            participants.put(c, participants.get(c)-1);
        }

        return participants.keySet()
                .stream()
                .filter(key -> participants.get(key) >0)
                .findFirst()
                .orElse(null);
    }
}
