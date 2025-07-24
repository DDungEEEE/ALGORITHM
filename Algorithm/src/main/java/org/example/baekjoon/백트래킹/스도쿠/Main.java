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
        sudoku(0, 0);

    }

    public static void sudoku(int col, int row){
        // 마지막 행까지 채웠을 경우
        if(col == 9){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }

        // 다음 위치 계산
        int nextCol = (row == 8) ? col + 1 : col;
        int nextRow = (row + 1) % 9;

        if(board[col][row] == 0){
            // 1부터 9까지 채워주기
            for(int i = 1; i <= 9; i ++){
                if(canPutNum(col, row , i)){
                    board[col][row] = i;
                    sudoku(nextCol, nextRow);
                    // 다시 원상복귀
                    board[col][row] = 0;
                }
            }
        } else {
            sudoku(nextCol, nextRow); // 빈칸이 아니라면 다음 칸으로 넘어감
        }
    }

    public static boolean canPutNum(int col, int row, int num){
        for(int i = 0; i < 9; i++){
            // 같은 행에 있는 경우
            if(board[col][i] == num || board[i][row] == num){
                return false;
            }
        }
        // 3x3 박스 안에 있는 경우
        int boxCol = (col / 3) * 3;
        int boxRow = (row / 3) * 3;

        for(int i = boxCol; i <boxCol + 3; i++){
            for(int j = boxRow; j < boxRow + 3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}