package org.example.baekjoon.백트래킹.N과M4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] nums = input.split(" ");

        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        result = new int[M];

        backTracking(1, 0, result);
    }

    static void backTracking(int start, int depth, int[] arr){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++){
            result[depth] = i;

            backTracking(i, depth + 1, result);
        }
    }
}
