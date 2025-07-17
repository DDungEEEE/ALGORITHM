package org.example.baekjoon.재귀.하노이의탑;

import java.util.Scanner;

/**
 * 하노이의 탑
 * 모든 원판들을 1번 -> 3번으로 옮긴다
 */
public class Main {
    // System.out.println 사용 -> 시간 초과로 인해 StringBuilder 사용
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 원판 개수

        System.out.println(count);  // 이동 횟수 출력
        move(n, 1, 3);
        System.out.print(sb);
    }
    // n개의 원판을 from → to로 옮기는 함수
    public static void move(int n, int from, int to) {

        int other = 6 - from - to;  // 나머지 기둥 번호

        // 첫 번째 -> 가운데 원판으로 이동
        if (n > 1) {
            move(n - 1, from, other);
        }
        // 2. 가장 큰 원판을 목적지로
        sb.append(from + " " + to + "\n");
        count++;
        // 가운데 원판 -> 목적지로 이동
        if (n > 1) {
            move(n - 1, other, to);
        }
    }
}
