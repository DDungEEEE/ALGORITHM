package org.example.baekjoon.이분탐색.K번째수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다.
         * 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.
         * 배열 A와 B의 인덱스는 1부터 시작한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long K = Long.parseLong(br.readLine());

        long left = 1;
        long right = K;
        long answer = 0;

        while (left <= right){
            int count = 0;

            long mid = (left + right) / 2;

            for(int i = 1; i <= N; i++){
                count += (int) Math.min((mid / i), N);
            }

            if(count >= K){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
