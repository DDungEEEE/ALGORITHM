package org.example.baekjoon.누적합.체스판칠하기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] board = new char[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine().trim();
            for (int j = 1; j <= M; j++) {
                board[i][j] = str.charAt(j - 1);
            }
        }

        // 검은색으로 시작할 때, 다시 칠해야 하는 칸 수 누적
        int[][] black = new int[N + 1][M + 1];
        // 하얀색으로 시작할 때, 다시 칠해야 하는 칸 수 누적
        int[][] white = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 검은색으로 시작할 떄 -> 홀수 W, 짝수 B
                char startBlack = ((i + j) % 2 == 0) ? 'B' : 'W';
                // 하얀색으로 시작할 떄 -> 홀수 B, 짝수 W
                char startWhite = ((i + j) % 2 == 0) ? 'W' : 'B';

                //각 체스판의 기대색과 일치할 경우 -> 0 else 1
                int needB = (board[i][j] == startBlack) ? 0 : 1;
                int needW = (board[i][j] == startWhite) ? 0 : 1;

                black[i][j] = black[i - 1][j] + black[i][j - 1] - black[i - 1][j - 1] + needB;
                white[i][j] = white[i - 1][j] + white[i][j - 1] - white[i - 1][j - 1] + needW;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int x2 = K; x2 <= N; x2++) {
            int x1 = x2 - K + 1;
            for (int y2 = K; y2 <= M; y2++) {
                int y1 = y2 - K + 1;

                int repaintB = sum(black, x1, y1, x2, y2);
                int repaintW = sum(white, x1, y1, x2, y2);

                min = Math.min(min, Math.min(repaintB, repaintW));
            }
        }

        System.out.println(min);
    }

    static int sum(int[][] board, int x1, int y1, int x2, int y2) {
        return board[x2][y2] - board[x1 - 1][y2] - board[x2][y1 - 1] + board[x1 - 1][y1 - 1];
    }
}
