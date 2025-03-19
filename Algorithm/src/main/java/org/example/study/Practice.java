package org.example.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Practice {
    public static void main(String[] args) {

        getStudentCnt(1);
    }
    public static void getStudentCnt(int ban){
        ArrayList<ArrayList<Integer>> gradeHeights = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(170);
        list1.add(180);
        list1.add(173);
        list1.add(175);
        list1.add(177);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(160);
        list2.add(165);
        list2.add(167);
        list2.add(186);

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(158);
        list3.add(177);
        list3.add(187);
        list3.add(176);

        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(173);
        list4.add(182);
        list4.add(181);

        ArrayList<Integer> list5 = new ArrayList<Integer>();
        list5.add(170);
        list5.add(180);
        list5.add(165);
        list5.add(177);
        list5.add(172);

        gradeHeights.add(list1);
        gradeHeights.add(list2);
        gradeHeights.add(list3);
        gradeHeights.add(list4);
        gradeHeights.add(list5);

        ArrayList<Integer> findHeights = gradeHeights.get(ban - 1);
        findHeights.sort(Collections.reverseOrder());

        System.out.println(Arrays.toString(findHeights.toArray()));
    }
}
