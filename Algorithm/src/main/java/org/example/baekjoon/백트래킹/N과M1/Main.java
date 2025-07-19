package org.example.baekjoon.백트래킹.N과M1;

import java.util.Scanner;

public class Main {
    private static int[] result;
    static boolean[] visited;
    static int M;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] nums = input.split(" ");

        // 1부터 N까지 자연수
        N = Integer.parseInt(nums[0]);

        // 중복 없이 M 개를 고른 수열
        M = Integer.parseInt(nums[1]);

        result = new int[M];
        visited = new boolean[N + 1];

        backTracking(0, 1);

    }
    static void backTracking(int depth, int start){

        if(depth == M){
            for(int i : result){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++){
            result[depth] = i;
            backTracking(depth + 1, i );
        }
    }
}
