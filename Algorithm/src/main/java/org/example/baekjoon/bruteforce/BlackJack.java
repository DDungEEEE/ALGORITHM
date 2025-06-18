package org.example.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // n -> 카드 개수
        int n = Integer.parseInt(st.nextToken());
        // m -> 최대치
        int m = Integer.parseInt(st.nextToken());
        // 3ㅐ
        int answer = 0;

        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //각 카드마다 시행
        for(int i=0; i<cards.length; i++){
            for(int j=i+1; j<cards.length; j++){
                for(int k=j+1; k<cards.length; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= m){
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
