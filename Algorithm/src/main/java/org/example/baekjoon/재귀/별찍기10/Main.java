package org.example.baekjoon.재귀.별찍기10;

import java.io.*;
import java.util.Arrays;

public class Main {

    static char[][] starArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        starArray = new char[N][N]; //별 찍는 배열

        fillStar(0, 0, N);

        //별 출력하기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(starArray[i][j]);
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    public static void fillStar(int x, int y, int size) {
        // size == 1이면 별
        if (size == 1) {
            starArray[x][y] = '*';
            return;
        }

        // 현재 블록을 3 * 3 으로 나눔
        int block = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 중앙 블록이면 공백으로 채움
                if (i == 1 && j == 1) {
                    blank(x + i * block, y + j * block, block);
                } else {
                    fillStar(x + i * block, y + j * block, block);
                }
            }
        }
    }

    // (x, y)에서 시작하는 size x size 영역을 공백으로 채움
    public static void blank(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                starArray[i][j] = ' ';
            }
        }
    }
}