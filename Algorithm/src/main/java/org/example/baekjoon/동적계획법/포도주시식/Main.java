package org.example.baekjoon.동적계획법.포도주시식;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] wines = new int[N + 1];
        for(int i = 1; i <= N; i++){
            wines[i] = Integer.parseInt(sc.nextLine());
        }

        if(N == 1){
            System.out.println(wines[1]);
        }else if(N == 2){
            System.out.println(wines[1] + wines[2]);
        }else{
            // 3잔 연속으로 먹으면 안된다.
            // ex) 1,2,3 이 있을 경우
            // 1, 2 를 마심 -> 이번잔을 안마신다. 즉, n-1 잔까지의 최댓값을 유지 = dp[n-1]

            // 2, 3 을 마심 -> wine[n-1] + wine[n] -> 이건  1번째를 마셨을 수도 있으니까, 그것을 방지하기 위하여
            // 1번째를 안마셨다는 조건을 주기 위해 dp[n-3]을 넣어준다. -> dp[n-3] + wine[n-1] + wine[n] n-2번째 와인을
            // 제외함으로써 3잔 연속 마신다는 조건 충족

            // 1, 3을 마심 -> dp[n-2] + wine[n]
            // 필요한 값 -> dp[n-1]. dp[n-2], dp[n-3]
            //dp[n-2]
            int a = wines[1];
            //dp[n-1]
            int b = wines[1] + wines[2];
            //dp[n-3]
            int c = 0;
            int result = 0;
            for(int i = 3; i <= N; i++){
                result = Math.max(b,
                        Math.max(
                                wines[i - 1] + wines[i] + c,
                                a + wines[i]
                        ));

                c = a;
                a = b;
                b = result;
            }

            System.out.println(result);
        }

    }
}
