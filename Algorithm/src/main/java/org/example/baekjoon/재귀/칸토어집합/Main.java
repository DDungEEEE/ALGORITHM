package org.example.baekjoon.재귀.칸토어집합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int length = (int) Math.pow(3, n);
            char[] str = new char[length];

            // 모두 '-'로 채움
            for (int i = 0; i < length; i++) {
                str[i] = '-';
            }

            cantorSet(str, 0, length);

            System.out.println(new String(str));
        }

        scanner.close();
    }

    public static void cantorSet(char[] str, int start, int length){
        // 길이가 3보다 작으면 더 이상 나눌 수 없으므로 종료
        if(length < 3){
            return;
        }
        // 길이를 3으로 나눈 몫
        int left = length / 3;

        // 현재 위치를 기준으로 가운데 인덱스 계산
        int mid = start + left;
        // 가운데 부분을 공백으로 변경
        for(int i = mid; i < mid + left; i++){
            str[i] = ' ';
        }

        // 왼쪽 부분과 오른쪽 부분에 대해 재귀 호출
        cantorSet(str, start, left);
        cantorSet(str, start + 2 * left, length / 3);
    }
}
