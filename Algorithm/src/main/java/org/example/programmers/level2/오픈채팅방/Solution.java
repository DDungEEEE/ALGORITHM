package org.example.programmers.level2.오픈채팅방;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] records = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        String[] recordss = solution(records);

        for (String record : recordss) {
            System.out.println(record);
        }
    }
    public static String[] solution(String[] record){
        Map<String, String> nickNameMap = new HashMap<>();
        Queue<String> messages = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for(String s : record){
            String[] str = s.split(" ");
            if(str.length > 2){
                String message = str[0];
                String uid = str[1];
                String nickName = str[2];
                if(message.equals("Change")){
                    //이름 변경할 때
                    nickNameMap.put(uid , nickName);
                }else{
                    nickNameMap.put(uid, nickName);
                    // uid + Enter 이런식으로 들어감
                    messages.add(uid + " " + message);
                }
            }else{
                String message = str[0];
                String uid = str[1];
                // uid + Enter 이런식으로 들어감
                messages.add(uid + " " + message);
            }


        }

        while (!messages.isEmpty()) {
            String[] str = messages.poll().split(" ");
            String uid = str[0];
            String message = isInOut(str[1]);

            if(message.length() > 2){
                result.add(nickNameMap.get(uid) + message);
            }
        }
        return result.toArray(String[]::new);
    }

    public static String isInOut(String str){
        if(str.length() == 5){
            if(str.startsWith("E")){
                return "님이 들어왔습니다.";
            }else{
                return "님이 나갔습니다.";
            }
        }else{
            return "ch";
        }
    }
}
