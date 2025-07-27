package org.example.study.다단계칫솔판매;

import java.io.IOException;
import java.util.HashMap;

public class Solution {

    static HashMap<String, String> parentMap = new HashMap<>();
    static HashMap<String, Integer> resultMap = new HashMap<>();

    /**
     * 이 문제를 풀기 위한 사전 지식
     *  1. 트리 구조의 재귀 함수
     *  2. 추천자, 판매원의 10% 판매 수익 분배 과정
     *  3. 추천자 판매원의 트리 구조
     */
    public static void main(String[] args) throws IOException {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        for(int i = 0; i < enroll.length; i++){
            // 판매자 -> 추천자 Map put
            resultMap.put(enroll[i], 0);
            parentMap.put(enroll[i], referral[i]);
        }

        for(int i = 0; i < seller.length; i++){
            solution(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = resultMap.get(enroll[i]);
            System.out.println(enroll[i] + " → " + resultMap.get(enroll[i])); // 확인용
        }



    }

    public static void solution(String seller, int profit){
        int commission = profit / 10;

        // 부모 노드인 미호일 경우 return
        if(seller.equals("-")){
            return;
        }

        if(commission < 1){
            resultMap.put(seller, resultMap.getOrDefault(seller, 0) + profit);
        }else{
            resultMap.put(seller, resultMap.getOrDefault(seller, 0) + profit - commission);
        }

        solution(parentMap.get(seller), commission);
    }

}
