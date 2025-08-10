package org.example.baekjoon.분할정복.색종이만들기;

import java.util.Scanner;

public class Main {
    static int[][] paper;
    static int blueC = 0;
    static int whiteC = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        paper = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        cut(0, 0, N);

        System.out.println(whiteC);
        System.out.println(blueC);

    }

    static void cut(int x, int y, int size){
        if(isSameColor(x, y, size)){
            if(paper[x][y] == 1){
                blueC++;
                return;
            }else{
                whiteC++;
                return;
            }
        }

        // 일치하지 않을 경우 4등분 한다.
        // 왼쪽 상단, 오른쪽 상단, 왼쪽 하단, 오른쪽 하단
        cut(x, y, size / 2);
        cut(x + size / 2, y, size / 2);
        cut(x, y + size/2, size / 2);
        cut(x + size / 2, y + size / 2, size / 2);

    }

    static boolean isSameColor(int x, int y, int size){
        int firstPaper = paper[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(paper[i][j] != firstPaper) return false;
            }
        }
        return true;
    }
}