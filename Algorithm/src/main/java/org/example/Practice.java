package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 그냥 여러가지 library를 연습하는 클래스
 * 여러가지 알고리즘을 연습하는 클래스
 * 자료형을 연습하는 클래스
 */
public class Practice {
    public static class Student implements Comparable<Student> {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }

        // 정렬 기준 정의
            @Override
            public int compareTo(Student other) {
                if (this.age != other.age) {
                    return this.age - other.age; // 나이 오름차순
                }
                return this.name.compareTo(other.name); // 이름 오름차순
            }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Charlie", 23),
                new Student("Alice", 20),
                new Student("Bob", 20),
                new Student("David", 22)
        );

        List<Student> sorted = new ArrayList<>(students);
        Collections.sort(sorted); // Comparable 기준대로 정렬

        sorted.forEach(System.out::println);
    }
}
