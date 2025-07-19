package org.example.baekjoon.백트래킹.NQueen;

import java.util.Scanner;

public class Main {
    static int N;
    static int count = 0;
    static boolean[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 체스판 크기
        N = scanner.nextInt();

        board = new boolean[N][N];
        backTracking(0);

        System.out.println(count);
    }

    public static void backTracking(int depth){
        //모든 행에 퀸을 배치했을 때
        if(depth == N){
            count ++;
            return;
        }

        // 한 행에 하나씩 놓을거다.
        for(int i = 0; i < N; i ++){
            //퀸을 놓을 수 있을 때
            if(canPutQueen(i, depth)){
                // 체스판에 퀸을 놓는다.
                board[i][depth] = true;
                backTracking(depth + 1);
                board[i][depth] = false;
            }

        }
    }

    public static boolean canPutQueen(int col, int row){
        for(int i = )
    }


}