package org.example.programmers.level2.주식가격;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] solution(int[] prices){
        int[] times = new int[prices.length];
        Deque<Integer> store = new ArrayDeque<>();

        // 이건 배열을 통해 해결 O(N제곱)
//        for(int i = 0; i < prices.length; i++){
//            int count = 0;
//            for(int j = i + 1; j <prices.length; j++){
//                if(prices[i] <= prices[j]){
//                    count++;
//                }else{
//                    count++;
//                    break;
//                }
//            }
//            times[i] = count;
//        }

        for(int i = 0; i < prices.length; i++){
            // 가격이 작아질 시에
            while(!store.isEmpty() && prices[i] < prices[store.peek()]){
                // 현재 idx - 이전의 idx
                Integer j = store.pop();
                prices[j] = i - j;
            }
            store.push(i);
        }

        while(!store.isEmpty()){
            Integer i = store.pop();
            times[i] = prices.length - i - 1;
        }
        return times;
    }
}
