package org.example.programmers.level1.실패율;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int[] solution(int N, int[] stages){
        // N -> 총 스테이지 개수 1, 2, 3, 4, 5
        // stages -> 해당 스테이지에 도달한 사람
        Map<Integer, Integer> players = new HashMap<>();
        Map<Integer, Double> fail = new HashMap<>();

        for(int i = 1; i <= N + 1; i++){
            players.put(i, 0);
        }
        //스테이지에 해당하는 플레이어의 수를 Map구조로 저장
        for(int i = 0; i < stages.length; i++){
            players.put(stages[i], players.get(stages[i]) + 1);
        }
        int totalPeople = stages.length;

        for(int i = 1; i <= N; i++){
            // 해당 스테이지의 사람 수
            Integer user = players.get(i);
            //해당 스테이지의 사람 수 / 도전한 사람 총 수
            fail.put(i, (double) user / totalPeople);
            // 해당 스테이지는 다른사람들은 다 클리어했기 떄문에 제외
            totalPeople -= user;
        }

        return fail.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
