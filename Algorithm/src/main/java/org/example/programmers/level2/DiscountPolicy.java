package org.example.programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DiscountPolicy {

    public int solution(String[] want, int[]  number, String[] discount){
        // 사고 싶은 물품 Map
        Map<String, Integer> wantMap = new HashMap<>();
        //날짜 수를 처리하기위한 변수
        int result = 0;


        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for(int i = 0; i < discountLength - productCount + 1; i++){
            // 할인 물품을 저장하기 위한 Map
            Map<String, Integer> discountMap = new HashMap<>();
            // 현재 날짜부터 productCount만큼의 물품을 확인
            for(int j=i; j < i + productCount; j++){
                String currentProduct = discount[j];
                // 할인 물품 Map에 추가
                discountMap.put(currentProduct, discountMap.getOrDefault(currentProduct, 0) + 1);
            }

            if(discountMap.equals(wantMap)){
                result++;
            }
        }
        System.out.println(result);
    }
}
