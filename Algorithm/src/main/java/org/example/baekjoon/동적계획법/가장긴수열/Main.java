package org.example.baekjoon.동적계획법.가장긴수열;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        for(int i = 0; i < N; i++){
            List<Integer> lcs = new ArrayList<>();
            int cur = arr[i];
            lcs.add(cur);

            Map<Integer, Boolean> nums= new HashMap<>();
            nums.put(cur, true);
            for(int j = 0; j < N; j++){
                int next = arr[j];

                if(nums.get(next)){
                    continue;
                }

                nums.put(next, true);
                if(cur < next) {
                    lcs.add(next);
                }
            }
            result = Math.max(result, lcs.size());
        }
        System.out.println(result);
    }
}
