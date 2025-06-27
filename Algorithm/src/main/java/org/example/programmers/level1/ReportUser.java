package org.example.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class ReportUser {
    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];

        // 사용자에 해당하는 신고 Set
        Map<String, HashSet<String>> userReport = new HashMap<>();
        Map<String, Integer> reportedCount = new HashMap<>();

        for(String reports : report){
            String[] array = reports.split(" ");
            // 신고한 사람
            String repKey = array[0];
            // 신고 당한 사람
            String repVal = array[1];

            userReport.putIfAbsent(repKey, new HashSet<>());

            if(userReport.get(repKey).add(repVal)){
                reportedCount.put(repVal, reportedCount.getOrDefault(repVal, 0) + 1);
            }
        }

        List<String> outUsers = reportedCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for(int i=0; i< id_list.length; i++){
            String userId = id_list[i];
            int count = 0;

            Set<String> reported = userReport.getOrDefault(userId, new HashSet<>());
            for (String s : reported) {
                if (outUsers.contains(s)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
