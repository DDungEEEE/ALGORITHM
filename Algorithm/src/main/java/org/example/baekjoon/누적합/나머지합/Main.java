package org.example.baekjoon.누적합.나머지합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 원소 개수
        int M = Integer.parseInt(st.nextToken()); // 나눌 값

        long[] prefixMods = new long[N + 1]; // 누적합의 나머지 저장
        long[] modCount = new long[M];       // 나머지별 개수 카운트

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long num = Long.parseLong(st.nextToken()) % M; // 현재 수의 나머지
            prefixMods[i] = (prefixMods[i - 1] + num) % M; // 누적합 나머지
            modCount[(int) prefixMods[i]]++; // 해당 나머지 카운트 증가
        }

        long result = 0;

        // 같은 나머지 값들 중 2개 뽑는 경우의 수 더하기
        for (long count : modCount) {
            result += (count * (count - 1)) / 2;
        }

        result += modCount[0];

        System.out.println(result);
    }

}
