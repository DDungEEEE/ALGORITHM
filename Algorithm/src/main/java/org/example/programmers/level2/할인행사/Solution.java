package org.example.programmers.level2.할인행사;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {
                "chicken", "apple", "apple", "banana", "rice", "apple",
                "pork", "banana", "pork", "rice", "pot", "banana",
                "apple", "banana"
        };

        System.out.println(solution(want, number, discount));
    }
    public static int solution(String[] want, int[] number, String[] discount){
        Map<String, Integer> reqDiscount = new HashMap<>();
        Map<String, Integer> curDiscount = new HashMap<>();

        for(int i = 0; i < want.length; i++){
            reqDiscount.put(want[i], number[i]);
            curDiscount.put(want[i], 0);
        }

        int answer = 0;

        for(int i = 0; i < discount.length; i++){


            if(i >= 10) {
                if(curDiscount.containsKey(discount[i - 10])) {
                    curDiscount.put(discount[i - 10], curDiscount.get(discount[i - 10]) - 1);
                }
            }
            if(curDiscount.containsKey(discount[i])){
                curDiscount.put(discount[i], curDiscount.get(discount[i]) + 1);
            }

            int result = curDiscount.entrySet().stream().map(entry -> {
                String key = entry.getKey();
                Integer value = entry.getValue();

                return value >= reqDiscount.get(key);
            }).filter(o -> !o).collect(Collectors.toList()).size();

            if(result == 0){
                answer++;
            }
        }

        return answer;
    }
}
