package org.example.programmers;

import java.util.*;

public class GiftAlgorithm {
    public int solution(String[] friends, String[] gifts){
        // User Index 저장
        Map<String, Integer> userIndex = new HashMap<>();
        int friendC = friends.length;
        //유저의 선물 주고받는 점수 계산
        Map<String, Integer> giftScore = new HashMap<>();

        for(String friend:friends){
            giftScore.put(friend, 0);
        }

        for(int i=0; i<friendC; i++){
            userIndex.put(friends[i], i);
        }

        int[][] giftLog = new int[friendC][friendC];

        for(int i=0; i<gifts.length; i++){
            String[] s = gifts[i].split(" ");

            String giveU = s[0];
            String recU = s[1];

            Integer giveUIn = userIndex.get(giveU);
            Integer recUIn = userIndex.get(recU);

            giftScore.put(giveU, giftScore.get(giveU) + 1);
            giftScore.put(recU, giftScore.get(recU) - 1);

            giftLog[giveUIn][recUIn]++;
        }

        int[] results = new int[friendC];

        for(int i=0; i<friendC; i++){
            for(int j=0; j<friendC; j++){
                if(i == j)continue;
                int give = giftLog[i][j];
                int rec = giftLog[j][i];
                if(give > rec){
                    results[i]++;
                }else if(give == rec && (giftScore.get(friends[i]) > giftScore.get(friends[j]))){
                    results[i]++;
                }
            }
        }
    return Arrays.stream(results).max().orElse(0);
    }
}
