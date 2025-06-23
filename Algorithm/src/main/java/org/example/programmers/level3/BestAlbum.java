package org.example.programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> generesCountMap = new HashMap<>();
        Map<String, List<Integer[]>> generesIndexMap = new HashMap<>();
        // 장르별 재생 횟수를 저장하는 Map
        for (int i = 0; i < genres.length; i++) {
            // 장르별 재생 횟수와 인덱스를 저장
            if (generesIndexMap.get(genres[i]) == null) {
                ArrayList<Integer[]> integers = new ArrayList<>();
                integers.add(new Integer[]{i, plays[i]});

                generesIndexMap.put(genres[i], integers);
            } else {
                generesIndexMap.get(genres[i]).add(new Integer[]{i, plays[i]});
            }

            if (generesCountMap.get(genres[i]) == null) {
                generesCountMap.put(genres[i], plays[i]);
            } else {
                generesCountMap.put(genres[i], generesCountMap.get(genres[i]) + plays[i]);
            }
        }
        List<String> orderedGenre = generesCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();

        for (String g : orderedGenre) {
            List<Integer[]> songs = generesIndexMap.get(g);

            songs.sort((a, b) -> {
                if (a[1].equals(b[1])) {
                    return a[0] - b[0]; // 재생 횟수가 같으면 인덱스 순으로 정렬
                }
                return b[1] - a[1]; // 재생 횟수 내림차순 정렬
            });

            answer.add(songs.get(0)[0]); // 가장 많이 재생된 곡의 인덱스 추가
            if (songs.size() > 1)                     // 2등이 있으면
                answer.add(songs.get(1)[0]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
