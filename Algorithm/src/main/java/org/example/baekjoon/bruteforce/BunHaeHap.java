package org.example.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BunHaeHap {
//어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은
// N과 N을 이루는 각 자리수의 합을 의미한다.
// 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
// 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
// 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의
// 경우에는 생성자가 없을 수도 있다.
// 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
//자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int copyN = N;

    int answer = N;
    while (copyN> 0){
        int temp = copyN;
        int sum = 0;
        //먼저 분해합을 구하기 위해서 copy 값 더해줌
        sum += copyN;
        // 각 자리수의 합을 구하기 위한 반복문
        while (temp > 0){
            int n = temp % 10;
            sum += n;
            temp /= 10;
        }
        if(sum == N){
            answer = Math.min(answer, copyN);
        }
        copyN--;
    }

    System.out.println(answer == N ? 0 : answer);
}

}
