package org.example.baekjoon.동적계획법.평범한_배낭;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int max = sc.nextInt();
        int[][] arr = new int[N][2];

        // 현재 무게와 가치를 넣을 Map
        Map<Integer, Integer> dp = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 초기 상태 설정
        dp.put(0, 0);

       for(int[] bag : arr){
           int weight = bag[0];
           int value = bag[1];

           // 동시성 문제로 인한 복사 map
           Map<Integer, Integer> curDp = new HashMap<>(dp);

           for(Map.Entry<Integer, Integer> entry : curDp.entrySet()){
               //현재 무게와 가치 가져오기
               int curWeight = entry.getKey();
               int curValue = entry.getValue();

               // bag 배열에 담겨있는 무게와 가치 더함
               int nextWeight = curWeight + weight;
               int nextValue = curValue + value;

               if(nextWeight <= max){
                   dp.put(nextWeight, Math.max(nextValue, dp.getOrDefault(nextWeight, 0)));
               }
           }
       }

       int result = Collections.max(dp.values());
        System.out.println(result);
    }
}
