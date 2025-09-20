package org.example.baekjoon.우선순위큐.최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> result = new ArrayDeque<>();

        int count = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num == 0){
                count++;
                if(queue.isEmpty()){
                    // 비어있으면 0을 넣음
                    result.add(0);
                }else{
                    // 비어있지 않을 경우 제일 큰 값을 넣는다.
                    result.add(queue.poll());
                }
            }else{
                queue.add(num);
            }
        }

        for(int i = 0; i < count; i++){
            sb.append(result.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
