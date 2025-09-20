package org.example.baekjoon.우선순위큐.최대힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num == 0){
                if(queue.isEmpty()){
                    // 비어있으면 0을 넣음
                    sb.append(0).append("\n");

                }else{
                    // 비어있지 않을 경우 제일 큰 값을 넣는다.
                    sb.append(queue.poll()).append("\n");
                }
            }else{
                queue.add(num);
            }
        }

        System.out.println(sb);
    }
}
