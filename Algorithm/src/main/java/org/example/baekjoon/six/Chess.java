package org.example.baekjoon.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Chess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalScore = 0.0; // 학점 * 점수 누적합
        double totalCredit = 0.0; // 학점 누적합 (P 제외)

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            String creditStr = st.nextToken();
            String grade = st.nextToken();

            if (grade.equals("P")) continue; // 학점이 숫자가 아님 → 건너뜀

            double credit = Double.parseDouble(creditStr);
            double score = parseToScore(grade);

            totalScore += credit * score;
            totalCredit += credit;
        }

        double average = totalScore / totalCredit;
        System.out.printf("%.6f", average); // 소수점 6자리까지 출력

    }

    public static double parseToScore(String grade) {
        switch (grade) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            case "F":  return 0.0;
            default:   return 0.0; // 예외 방지용
        }
    }
}
