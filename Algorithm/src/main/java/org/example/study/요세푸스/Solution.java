package org.example.study.요세푸스;

import java.util.LinkedList;
import java.util.Queue;

public  class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5, 2));;
    }
    public static int solution(int N, int K){
        Queue<Integer> human = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            human.add(i);
        }

        while(human.size() != 1){
            for(int i = 0; i < K; i++){
                Integer man = human.poll();
                if(i < K - 1){
                    human.add(man);
                }
            }
        }

        return human.peek();
    }
}
