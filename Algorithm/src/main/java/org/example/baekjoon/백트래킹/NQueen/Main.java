package org.example.baekjoon.백트래킹.NQueen;

import java.util.Scanner;

public class Main {
    static int N;
    static int count = 0;
    static boolean[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        board = new boolean[N][N];
        backTracking(0);

        System.out.println(count);
    }

    static void backTracking(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = true; // 퀸 놓기
                backTracking(row + 1);
                board[row][col] = false; // 퀸 제거
            }
        }
    }

    // 현재 행, 열 위치에 퀸을 놓아도 괜찮은지 검사
    static boolean isSafe(int row, int col) {

        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i]) return false;
        }

        for (int i = 1; row - i >= 0 && col + i < N; i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }
}