package org.example.baekjoon.백트래킹.N과M1;

import java.sql.SQLOutput;

public class Practice {
    static int[] arr = {1, 2, 3, 4};
    static int M = 3;
    static int N = arr.length;

    public static void main(String[] args) {
        backTracking(0, 0, new int[M]);

    }

    static void backTracking(int start, int depth, int[] result){
        if(depth == M){
            for(int i : result){
                    System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < N; i++){
            result[depth] = arr[i];
            backTracking(i + 1, depth + 1, result);
        }
    }

}
