package org.example.programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class DiscountPolicy {

    public int solution(String[] want, int[]  number, String[] discount){
        // 사고 싶은 물품 Map
        Map<String, Integer> wantMap = new HashMap<>();
        //날짜 수를 처리하기위한 변수
        int result = 0;

        int productCount = 0;
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
            productCount += number[i];
        }
        int discountLength = discount.length;

//        for(int i = 0; i < discountLength - productCount + 1; i++){
//            // 할인 물품을 저장하기 위한 Map
//            Map<String, Integer> discountMap = new HashMap<>();
//            // 현재 날짜부터 productCount만큼의 물품을 확인
//            for(int j=i; j < i + productCount; j++){
//                String currentProduct = discount[j];
//                // 할인 물품 Map에 추가
//                discountMap.put(currentProduct, discountMap.getOrDefault(currentProduct, 0) + 1);
//            }
//
//            if(discountMap.equals(wantMap)){
//                result++;
//            }
//        }
        Map<String, Integer> discountMap = new HashMap<>();

        for(int i=0; i<discountLength; i++){
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);

            // 지정 productCount 넘어갈 경우 오래된 Data 제거
            if(i >= productCount){
                if(discountMap.get(discount[i-productCount]) == 1){
                    discountMap.remove(discount[i-productCount]);
                }else{
                    discountMap.put(discount[i-productCount], discountMap.get(discount[i-productCount]) - 1);
                }
            }

            if(isMatched(wantMap, discountMap)){
                result++;
            }

        }
        return result;
    }

    public static boolean isMatched(Map<String, Integer> wantMap, Map<String, Integer> discountMap){
        if(wantMap.size() != discountMap.size()) {
            return false;
        }
        int unMatchedSize = discountMap.entrySet()
                .stream()
                .filter(entry -> !(entry.getValue().equals(wantMap.get(entry.getKey()))))
                .collect(Collectors.toList())
                .size();
        System.out.println("unMatchedSize = " + unMatchedSize);
        return unMatchedSize == 0;
    }
}
