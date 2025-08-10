package org.example.baekjoon.분할정복.쿼드트리;

import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        board = new int[N][N];

        for(int i = 0; i < N; i++){
            String input = sc.next(); // 공백 없이 N글자
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);
    }

    static void quadTree(int row, int col, int size){
        if(isSameNum(row, col, size)){
            if(board[row][col] == 1){
                sb.append(1);
                return;
            }else{
                sb.append(0);
                return;
            }
        }

        // 4분할 시작
        // 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른족 아래 순서로 나눔
        sb.append("(");

        quadTree(row, col, size / 2);

        quadTree(row, col + size / 2, size / 2);

        quadTree(row + size / 2, col, size / 2);

        quadTree(row + size / 2, col + size / 2, size / 2);

        // 4분할 종료
        sb.append(")");
    }


    static boolean isSameNum(int row, int col, int size){
        int firstNum = board[row][col];

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(board[i][j] != firstNum) return false;
            }
        }
        return true;
    }
}
