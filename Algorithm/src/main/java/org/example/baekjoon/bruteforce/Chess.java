package org.example.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Chess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int x = Integer.parseInt(size[0]);
        int y = Integer.parseInt(size[1]);

        char[][] board = new char[x][y];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < x; i++) {
            String row = br.readLine();
            board[i] = row.toCharArray();
        }
        for (int i = 0; i < x - 7; i++) {
            for (int j = 0; j < y - 7; j++) {
                result = Math.min(result, checkChess(board, i, j));
            }
        }
        System.out.println(result);

    }

    public static int checkChess(char[][] board, int x, int y) {
        int result = 0;
        char startChar = board[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // 시작 위치와 같은 색상이어야 함
                boolean shouldBeSame = ((x + y) % 2) == ((i + j) % 2);
                if(shouldBeSame){
                    if(board[i][j] != startChar) {
                        result++;
                    }
                }else{
                    if(board[i][j] == startChar) {
                        result++;
                    }
                }
            }
        }
        return Math.min(result, 64 - result);
    }
}
