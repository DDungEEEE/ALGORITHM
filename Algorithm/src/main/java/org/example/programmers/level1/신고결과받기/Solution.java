package org.example.programmers.level1.신고결과받기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 다시 풀어야 함 - pg.270
 */
public class Solution {

    public static int[] solution(String[] id_list, String[] report, int k){
        // 신고당한 횟수
        Map<String, Integer> reportedUser = new HashMap<>();
        Map<String, String> reportUser = new HashMap<>();
        Map<String, Integer> userIdx = new HashMap<>();

        for(int i = 0; i < id_list.length; i++){
            userIdx.put(id_list[i], i);
        }

        int[] result = new int[id_list.length];

        for(String str : report){
            String[] split = str.split(" ");

            String send = split[0];
            String received = split[1];

            reportedUser.put(received, reportedUser.getOrDefault(received, 0) + 1);
            //A^B^C^이렇게 공백으로 들어감
            reportUser.put(received, reportUser.getOrDefault(received, "") + send +" ");
        }

        reportedUser.entrySet().stream().forEach(user -> {
            // 일정 신고횟수를 넘겼을 경우
            if(user.getValue() >= k){
                String s = reportUser.get(user.getKey());
                // 정지 당한 애를 신고한 유저들 받은 메일 + 1
                String[] reportU = s.split(" ");

                for(String u : reportU){
                    result[userIdx.get(u)] += 1;
                }
            }
        });

        return result;
    }
}
