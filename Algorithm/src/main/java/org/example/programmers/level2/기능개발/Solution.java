package org.example.programmers.level2.기능개발;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
    public static int[] solution(int[] progress, int[] speeds){
        Queue<Integer> answer = new ArrayDeque<>();
        List<Integer> days = new ArrayList<>();
        for(int program : progress){
            answer.add(program);
        }

        while (!answer.isEmpty()){
            for(int i = 0; i < progress.length; i++){
                answer.add(answer.poll() + speeds[i]);
            }

            int count = 0;
            while (!answer.isEmpty() && answer.peek() >= 100){
                answer.poll();
                count++;
            }

            if(count >= 1){
                days.add(count);
            }
        }

        return days.stream().mapToInt(Integer::intValue).toArray();
    }
}
