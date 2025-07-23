package org.example.baekjoon.백트래킹.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기
        for (int i = 0; i < 9; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

    }

    public static void sudoku(int depth){
        // 모든 행의 스도쿠를 다 채웠을 경우
        if(depth == 9){
            for(int i = 0; i < 9; i ++){
                for (int j = 0; j < 9; j++){
                    sb.append(board[i][j]);
                }
                sb.append("/n");
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean canPutNum(int col, int row, int num){
        for(int i = col; i < 9; i++){
            
        }
    }
}