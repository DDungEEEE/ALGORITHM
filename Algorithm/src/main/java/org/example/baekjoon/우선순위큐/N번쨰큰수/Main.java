package org.example.baekjoon.우선순위큐.N번쨰큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for(int i = 0; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                long num = Integer.parseInt(st.nextToken());

                if(queue.size() >= N){
                    if(queue.peek() < num){
                        queue.poll();
                        queue.add(num);
                    }
                }else{
                    queue.add(num);
                }

            }
        }

        System.out.println(queue.poll());

    }
}
