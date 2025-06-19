package org.example.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int count = 0;
        while (N > 0){
            // N을 5의 배수일경우
            if(N % 5 == 0){
                count += N / 5;
                break;
                // 5개, 3개로 나누어 떨어지는 경우
            }
            N -= 3;
            count++;
        }

        if(N < 0){
            count = -1;
        }

        System.out.println(count);
    }
}
