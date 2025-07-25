package org.example.baekjoon.백트래킹.N과M2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] nums = input.split(" ");

        // 1부터 N까지 자연수
        N = Integer.parseInt(nums[0]);

        // 중복 없이 M 개를 고른 수열
        M = Integer.parseInt(nums[1]);

        result = new int[M];

        backTracking(1, 0, result);
    }

    static void backTracking(int start, int depth, int[] arr){
        if(depth == M){
            Arrays.stream(arr)
                    .sorted()
                    .forEach(i -> System.out.print(i + " "));

            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++){
            result[depth] = i;

            backTracking(i + 1, depth + 1, result);
        }
    }
}
