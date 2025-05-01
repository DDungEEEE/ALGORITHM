package org.example.baekjoon.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CoinPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }
    static int[] solution(int[] prices){
        // 시간 초과 나옴
//        Map<Integer, Integer> result = new HashMap<>();
//
//        for(int i=0; i<prices.length; i++){
//            result.put(i, 0);
//            for(int j=i+1; j<prices.length; j++){
//                result.put(i, result.get(i)+1);
//                if(prices[i] > prices[j]){
//                    break;
//                }
//            }
//        }
//        int[] resultArray = new int[prices.length];
//        for(int i=0; i<prices.length; i++){
//            resultArray[i] = result.get(i);
//        }
//        return resultArray;
        int[] solution = new int[prices.length];
        Stack<Integer> time = new Stack<>();
        for(int i=0; i<prices.length; i++){
            while(!time.isEmpty() && prices[time.peek()] > prices[i]){
                Integer pop = time.pop();
                solution[pop] = i - pop;
            }
            time.push(i);
        }

        Integer lastValue = time.peek();
        while (!time.isEmpty()){
            Integer index = time.pop();
            solution[index] = lastValue - index;
        }

        return solution;
    }
}
