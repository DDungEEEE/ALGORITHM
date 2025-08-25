package org.example.baekjoon.분할정복.종이의개수;

import java.util.Scanner;

public class Main {
    static int[][] papers;

    static int countZ; // 0 개수
    static int countO; // 1개수
    static int countM; // -1 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        papers = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                papers[i][j] = sc.nextInt();
            }
        }

        cutting(0, 0, N);


        System.out.println(countM + "\n" + countZ + "\n" + countO);
    }

    static void cutting(int row, int col, int size){
        if(isSamePaper(row, col, size)){
            switch (papers[row][col]){
                case 1:
                    countO++;
                    break;
                case 0:
                    countZ++;
                    break;
                case -1:
                    countM++;
                    break;
            }
            return;
        }

        for(int i = 0; i < 3; i++){
           cutting(row, col + size / 3 * i, size / 3); // 위쪽 줄
           cutting(row + size / 3, col + size / 3 * i, size / 3); // 중간 줄
           cutting(row + size / 3 * 2, col + size / 3 * i, size / 3); // 아래 줄

        }
    }

    static boolean isSamePaper(int row, int col, int size){
        int num = papers[row][col];

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(papers[i][j] != num)
                    return false;
            }
        }
        return true;
    }
}
