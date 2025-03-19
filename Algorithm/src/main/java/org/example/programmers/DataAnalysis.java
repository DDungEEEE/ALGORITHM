package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataAnalysis {

    public static void main(String[] args) {

    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
       List<String> categories =new ArrayList<>(List.of("code", "date", "maximum", "remain"));
        //ext : 추출 기준, val_ext : 기준값, sort_by : 정렬 기준

        int categoryIdx = categories.indexOf(ext);
        int sortIdx = categories.indexOf(sort_by);
        int[][] result = Arrays.stream(data).filter(o1 -> o1[categoryIdx] < val_ext).sorted((o1, o2) -> Integer.compare(o1[sortIdx], o2[sortIdx])).toArray(int[][]::new);
        return result;

    }
}
