package org.example.study.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class YosePussy {
    public static void main(String[] args) throws IOException {
        //요세푸스 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int K = Integer.parseInt(st.nextToken()); // 제거할 순서

        Queue<Integer> human = new LinkedList<>();
        // 1부터 N까지 사람을 큐에 넣기
        for (int i = 1; i <= N; i++) {
            human.offer(i);
        }
        // 뺀 사람 순차적으로 넣기
        List<Integer> result = new ArrayList<>();

        int index = 0;
        while (human.size() > 0){
            Integer out = human.poll();
            index++;
            // K번째 사람을 제거
            if(index == K){
                result.add(out);
                //index 초기화
                index = 0;
            }
            // 만약 K번째가 아니라면 다시 큐에 넣기
            else{
                human.offer(out);
            }
        }
        System.out.println("<" + result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
                + ">");
    }
}
