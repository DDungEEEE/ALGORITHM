package org.example.programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Function {
    public int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> answer = new ArrayDeque<>();

        int n = progresses.length;

        int[] days = new int[n];

        // 작업마다 소요일 계산
        for(int i=0; i<n; i++){
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int firstDay = days[0];
        int count = 1;

        for(int i=1; i<n; i++){
            // 첫번째 작업보다 소요일이 짧거나 같으면 배포 가능
            if(days[i] <= firstDay){
                count++;
            } else {
                // 배포 불가능하면 현재까지 배포 가능한 작업 수를 저장하고, 카운트 초기화
                answer.add(count);
                firstDay = days[i];
                count = 1;
            }
        }

        //마지막 배포할 기능 수를 추가
        answer.add(count);
        // 결과를 배열로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
