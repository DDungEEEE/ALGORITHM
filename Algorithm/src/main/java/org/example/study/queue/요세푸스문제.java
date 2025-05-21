package org.example.study.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class
요세푸스문제 {
    public static void main(String[] args) {
        solution(5, 2);
    }
    public static void solution(int N, int K){
        Queue<Integer> humans = new ArrayDeque<>();

        // 사람을 1번째~N번째 까지 삽입
        for(int i=1; i<=N; i++){
            humans.add(i);
        }

        while (humans.size() >= K){
            for(int i=1; i<=K; i++){
                Integer man = humans.poll();
                if(i != K){
                    humans.add(man);
                }
            }
        }

        System.out.println(humans.toString());
    }
}
