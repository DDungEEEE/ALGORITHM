package org.example.baekjoon.동적계획법.타일01;

import java.util.Scanner;

public class Main {
    static int[] nums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // N < 3 일 때 오버플로우 방지용
        nums = new int[Math.max(3, N + 1)];

        nums[1] = 1;
        nums[2] = 2;

        for(int i = 3; i <= N; i++){
                /**
                 * 오버플로우를 막기 위해 각 길이의 경우의 수를 구할 떄마다 나눠준다.
                 * (a + b) % m = (a % m + b % m) % m 공식으로 인해 상관 X
                 */
                nums[i] = (nums[i - 1] + nums[i - 2]) % 15746;
        }

        System.out.println(nums[N]);
    }
}
