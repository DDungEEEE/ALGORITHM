package org.example.study.행렬의곱셈;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        int[][] result = solution(arr, arr2);
        for(int[] a : result){
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2){
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                for(int k = 0; k < arr1[0].length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
