package org.example.baekjoon.재귀.피보나치수5;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));

    }

    static int solution(int n){
        // 피보나치 수열의 첫 번째와 두 번째 항은 각각 0과 1
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return solution(n - 1) + solution(n - 2);
    }
}
