package org.example.baekjoon.백트래킹.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기
        for (int i = 0; i < 9; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        solve(0, 0);
    }

    static void solve(int row, int col) {
        if (col == 9) {
            solve(row + 1, 0);
            return;
        }

        if (row == 9) {
            printBoard();
            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isValid(row, col, num)) {
                    board[row][col] = num;
                    solve(row, col + 1);
                    board[row][col] = 0;
                }
            }
        } else {
            solve(row, col + 1);
        }
    }

    static boolean isValid(int row, int col, int num) {
        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 3x3 박스 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    static void printBoard() {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}