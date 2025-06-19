package org.example.programmers.level2;

import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int parkLength = park.length;
        int answer = -1;

        // 큰 것부터 수행
        Arrays.sort(mats);

        for(int i = 0; i < parkLength; i++){
            for(int j = 0; j < parkLength; j++){
                if(park[i][j].equals("-1")){
                    answer = getMaxMatSize(mats, park, i, j);
                }

            }
        }
        return answer;
    }

    public int getMaxMatSize(int[] mats, String[][] park, int x, int y){
        int result = 0;

       for(int mat: mats){
           if(x + mat > park.length || y + mat > park[0].length){
               return -1;
           }else{
               for(int i = x; i < x + mat; i++){
                   for(int j = y; j < y + mat; j++){
                       if(!park[i][j].equals("-1")){
                           return -1;
                       }else{
                           result = Math.max(result, mat);
                       }
                   }
               }
           }
       }
        return result;
    }
}