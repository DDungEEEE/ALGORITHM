package org.example.baekjoon.백트래킹.스타트와링크;


import java.util.Scanner;

public class Main {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();

       backTracking(0, 0);
        System.out.println(minResult);
    }

    static void backTracking(int depth, int start) {
        if (depth == N / 2) {
            calculateDifference();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
               backTracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void calculateDifference() {
        int startTeam = 0, linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += board[i][j] + board[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += board[i][j] + board[j][i];
                }
            }
        }

        minResult = Math.min(minResult, Math.abs(startTeam - linkTeam));
    }
}