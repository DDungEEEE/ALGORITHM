package org.example.programmers.level2.메뉴리뉴얼;

import java.util.*;

public class Solution {
    public String[] solution(String[] orders, int[] course){
        List<String> answer = new ArrayList<>();

        for (int c : course) {
            Map<String, Integer> map = new HashMap<>();

            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                dfs(arr, 0, c, new StringBuilder(), map);
            }

            int max = map.values().stream().max(Integer::compareTo).orElse(0);

            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) {
                        answer.add(key);
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    static void dfs(char[] arr, int idx, int len, StringBuilder sb, Map<String, Integer> map){

        if(sb.length() == len){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for(int i = idx; i < arr.length; i++){
            sb.append(arr[i]);
            dfs(arr, i + 1, len, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
