package org.example.baekjoon.백트래킹.N과M1;

import java.sql.SQLOutput;

public class Practice {
    static int[] arr = {1, 2, 3, 4};
    static int M = 2;
    static int N = arr.length;

    public static void main(String[] args) {
        backTracking(0, 0, new int[M]);

    }

    // depth: 지금까지 선택한 개수
    // start: 다음에 고를 인덱스의 시작점
    // result : 선택된 수열을 저장할 배열
    public static void backTracking(int depth, int start, int[] result) {
        if(depth == M){
            for(int num : result){
                System.out.println(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < N; i++){
            result[depth] = arr[i];
            backTracking(depth + 1, i + 1, result);
        }
    }
}
