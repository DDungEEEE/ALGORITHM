package org.example.programmers;

import java.beans.BeanInfo;
import java.util.Vector;

public class DeliveryPickup {
    public static void main(String[] args) {

        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        System.out.println(solution(mats, park));
    }
    public static int solution(int[] mats, String[][] park){
        // 매트의 개수
        int matSize = mats.length;
        int parkLength = park.length;
        int answer = -1;

        // park의 길이만큼 수행
        for(int i=0; i<parkLength; i++){
            for(int j=0; j<park[i].length; j++){
                // 만약 자리가 비어있으면 수행
                if(park[i][j].equals("-1")){
                    // 매트의 크기가 큰 것부터 수행
                    for(int k = matSize-1; k >= 0; k--){
                        int[] startPark = {i, j};
                        if(isSuccess(startPark, mats[k], park)){
                            if(mats[k] > answer){
                                answer = mats[k];
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isSuccess(int[] startPark, int matSize, String[][] park){
        if((startPark[0] + matSize) > park.length){
            return false;
        }
        if((startPark[1] + matSize) > park[0].length){
            return false;
        }

        for(int i=startPark[0]; i<startPark[0] + matSize; i++){
            for(int j=startPark[1]; j < startPark[1]+matSize; j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }


}