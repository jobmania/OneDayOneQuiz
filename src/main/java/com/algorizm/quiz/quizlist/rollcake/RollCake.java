package com.algorizm.quiz.quizlist.rollcake;


// https://school.programmers.co.kr/learn/courses/30/lessons/132265


import java.util.*;
import java.util.stream.Collectors;

public class RollCake {
    public static void main(String[] args) {
        SolutionRollCake solutionRollCake = new SolutionRollCake();
        int[] array = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] array2 = {1, 2, 3, 1, 4};

        int answer = solutionRollCake.solution2(array2);
        System.out.println(answer);
    }
}

class SolutionRollCake {
    public int solution(int[] topping) {

        int answer = 0;
  //// 시간초과 매번 배열을 만들어서 시간초과 많이 생기는 듯.

        for (int i = 1; i < topping.length; i++) {
            // 배열을 2개로 분리하기
            int[] array1 = Arrays.copyOfRange(topping, 0, i + 1);
            int[] array2 = Arrays.copyOfRange(topping, i + 1, topping.length);

            // Set 구조를 활용한 중복 제거
            Set<Integer> set1 = Arrays.stream(array1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(array2).boxed().collect(Collectors.toSet());

            // 중복 제거된 값을 비교
            if (set1.size() == set2.size()) {
                answer++;
            }

        }

        return answer;
    }

    public int solution2(int[] topping) {
        int answer = 0;

       List<Integer> array1 = new ArrayList<>();
       List<Integer> array2 = new ArrayList<>();
        for (int j : topping) {
            array2.add(j);
        }

        for(int i = 0 ; i < topping.length ; i++ ){
            array1.add(topping[i]);
            array2.remove(0);

            HashSet<Integer> set1 = new HashSet<>(array1);
            HashSet<Integer>  set2 = new HashSet<>(array2);

            if(set1.size()==set2.size()) answer++;

        }


        return answer;

    }
    public int solution3(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashSet<Integer> set1 = new HashSet<>();









        return answer;
    }
}
