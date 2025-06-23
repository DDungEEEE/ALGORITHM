package org.example.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OpenChatting {
    public static void main(String[] args) {
        OpenChatting openChatting = new OpenChatting();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = openChatting.solution(record);
        for (String s : result) {
            System.out.println(s);
        }
    }
    public String[] solution(String[] record){
        List<String[]> userLog = new ArrayList<>();

        //uid와 닉네임을 저장하기 위한 Map
        Map<String, String> nickName = new HashMap<>();


        for(String user : record){
            String[] records = user.split(" ");
            // Enter로 시작
            if(records[0].equals("Enter")){
                // uid, 닉네임 저장
                nickName.put(records[1], records[2]);

                userLog.add(new String[]{records[1], "님이 들어왔습니다."});
            }else if(records[0].equals("Leave")){
                userLog.add(new String[]{records[1], "님이 나갔습니다."});
            }
            // Change로  -> 닉네임 바꿔줌
            else{
                nickName.put(records[1], records[2]);
            }
        }

        // 결과를 저장할 List
        String[] result = userLog.stream().map(log -> {
            String userId = log[0];
            String equalUid = nickName.keySet().stream().filter(userId::equals).findFirst().get();

            return nickName.get(equalUid) + log[1];
        }).toArray(String[]::new);

        return result;
    }
}
