package org.example.baekjoon.우선순위큐.중앙값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            int printed = 0;
            int count = 0;

            while (count < K){
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()){
                    int num = Integer.parseInt(st.nextToken());

                    if(leftQueue.isEmpty() || leftQueue.peek() >= num){
                        leftQueue.add(num);
                    }else{
                        rightQueue.add(num);
                    }

                    if(leftQueue.size() > rightQueue.size() + 1){
                        rightQueue.add(leftQueue.poll());
                    }

                    if(rightQueue.size() > leftQueue.size()){
                        leftQueue.add(rightQueue.poll());
                    }


                    if (count % 2 == 0) {
                        sb2.append(leftQueue.peek()).append(" ");
                        printed++;
                        if (printed % 10 == 0) sb2.append("\n");
                    }

                    count++;
                    if(count == K) break;
                }
            }

            sb.append((K + 1) / 2).append("\n");
            sb.append(sb2.toString().trim());

            System.out.println(sb);
        }
    }
}
