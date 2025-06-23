package org.example;
import java.util.*;
import java.util.stream.Stream;

/**
 * 그냥 여러가지 library를 연습하는 클래스
 * 여러가지 알고리즘을 연습하는 클래스
 * 자료형을 연습하는 클래스
 */
public class Practice {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Stream<Map.Entry<String, Integer>> enryStream = map.entrySet().stream();
        Set<String> keyStream = map.keySet();
        Stream<Integer> valueStream = map.values().stream();
    }
}
