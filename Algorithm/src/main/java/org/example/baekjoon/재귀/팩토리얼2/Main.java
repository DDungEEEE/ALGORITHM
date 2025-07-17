package org.example.baekjoon.재귀.팩토리얼2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/27433
 * 팩토리얼 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));

    }

    static long solution(int n){
        if(n == 0){
            return 1;
        }

        return n * solution(n - 1);
    }
}
