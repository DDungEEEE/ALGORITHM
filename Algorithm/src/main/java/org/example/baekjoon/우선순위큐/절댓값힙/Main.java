package org.example.baekjoon.우선순위큐.절댓값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> {
                    if(Math.abs(a) == Math.abs(b)){
                        return a - b;
                    }else{
                        return Math.abs(a) - Math.abs(b);

                    }
                }
        );
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i ++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(queue.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(queue.poll()).append("\n");
                }
            }else{
                queue.add(num);
            }
        }

        System.out.println(sb);
    }
}
