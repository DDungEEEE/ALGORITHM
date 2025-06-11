package org.example.programmers.level2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int bridgeLength, int weight, int[] truckWeights) {

        int time = 0;
        int currentWeight = 0;

        Queue<Integer> waitCar = new LinkedList<>();
        for (int truckWeight : truckWeights) {
            waitCar.offer(truckWeight);
        }

        // moveCarQueue: 다리를 건너는 트럭의 무게를 저장
        Queue<Integer> moveCarQueue = new LinkedList<>();
        // timeQueue: 각 트럭의 다리 위에 남은 시간 저장
        Queue<Integer> timeQueue = new LinkedList<>();

        while (!waitCar.isEmpty() || !moveCarQueue.isEmpty()) {
            time++;

            // 다리를 건넌 트럭이 있으면 제거
            if (!timeQueue.isEmpty() && timeQueue.peek() == time) {
                currentWeight -= moveCarQueue.poll();
                timeQueue.poll();
            }

            // 대기 중인 트럭이 다리에 진입 가능하면 진입
            if (!waitCar.isEmpty() && currentWeight + waitCar.peek() <= weight) {
                int truck = waitCar.poll();
                currentWeight += truck;
                moveCarQueue.offer(truck);
                timeQueue.offer(time + bridgeLength);
            }
        }

        return time;
    }

}

