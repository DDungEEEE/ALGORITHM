package org.example.baekjoon.동적계획법.RGB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N][3];

        // 0 -> r , 1 -> g , 2 -> b 각각의 최솟값 저장할 rgb 배열
        int[][] costs = new int[N][3];

        for(int i = 0; i < N; i++){
            String[] rgbs = br.readLine().split(" ");

            rgb[i][0] = Integer.parseInt(rgbs[0]);
            rgb[i][1] = Integer.parseInt(rgbs[1]);
            rgb[i][2] = Integer.parseInt(rgbs[2]);
        }

        costs[0][0] = rgb[0][0];
        costs[0][1] = rgb[0][1];
        costs[0][2] = rgb[0][2];

        for(int i = 1; i < N; i++){
            costs[i][0] = Math.min(costs[i - 1][1], costs[i - 1][2]) + rgb[i][0];
            costs[i][1] = Math.min(costs[i - 1][0], costs[i - 1][2]) + rgb[i][1];
            costs[i][2] = Math.min(costs[i - 1][1], costs[i - 1][0]) + rgb[i][2];
        }

        int result = Math.min(Math.min(costs[N-1][0], costs[N-1][1]), costs[N-1][2]);
        System.out.println(result);
    }
}
