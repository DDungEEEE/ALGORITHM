package org.example.baekjoon.백트래킹.N과M3;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] nums = input.split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        result = new int[M];

        backTracking(0);
        System.out.print(sb);
    }

    static void backTracking(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++){
            result[depth] = i;
            backTracking(depth + 1);
        }
    }
}
