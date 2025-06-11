package org.example.study.hash;

import java.util.HashMap;

public class DiscountRegister {
    public int solution(String[] want, int[]  number, String[] discount){
        int count = 0;
        int answer = 0;

        HashMap<String, Integer> wantNum = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantNum.put(want[i], number[i]);
            count += number[i];
        }

        HashMap<String, Integer> copyNum = new HashMap<>();
        for (int i = 0; i < count && i < discount.length; i++) {
            copyNum.put(discount[i], copyNum.getOrDefault(discount[i], 0) + 1);
        }
        if (isMatched(wantNum, copyNum)) answer++;

       for(int i=count; i<discount.length; i++){
           copyNum.put(discount[i], copyNum.getOrDefault(discount[i], 0) + 1);
           String removedItem = discount[i - count];
           copyNum.put(removedItem, copyNum.get(removedItem) - 1);

           if (copyNum.get(removedItem) == 0) {
               copyNum.remove(removedItem); // 깔끔하게 제거
           }

           // 윈도우가 원하는 조건과 맞는지 검사
           if (isMatched(wantNum, copyNum)) answer++;
       }

        return answer;
    }

    public boolean isMatched(HashMap<String, Integer> wantNum, HashMap<String, Integer> copyNum) {
       if(wantNum.size() != copyNum.size()){
           return false;
       }
       for(String key : wantNum.keySet()){
           if(!wantNum.get(key).equals(copyNum.get(key))){
               return false;
           }
       }
        return true;
    }
}
