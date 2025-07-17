package org.example.baekjoon.백트래킹.N과M2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] result;
    static boolean[] visited;
    static Map<Integer, Boolean> isVisited = new HashMap<>();

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

        backTracking(0, result);
    }

    static void backTracking(int depth, int[] arr){
        if(depth == M){
            isVisited.put(arr[0], true);

            Arrays.stream(arr)
//                    .sorted()
                    .forEach(i -> System.out.print(i + " "));
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){


            if(visited[i] || isVisited.get(i) != null)
                continue;
            result[depth] = i;
            // 사용된 숫자 기록
            visited[i] = true;
            backTracking(depth + 1, result);
            // 이전의 i값의 재귀가 끝났으므로 방문 기록 제거
            visited[i] = false;

        }
    }
}
