package com.algorizm.quiz.quizlist.rollcake;


// https://school.programmers.co.kr/learn/courses/30/lessons/132265


import java.util.Arrays;
import java.util.HashSet;

public class RollCake {
    public static void main(String[] args){
       SolutionRollCake solutionRollCake = new SolutionRollCake();
       int[] array = {1,2, 1, 3, 1, 4, 1, 2};
       int[] array2 = {1,2,3,1,4};

      int answer = solutionRollCake.solution(array);
        System.out.println(answer);
    }
}

class SolutionRollCake {
        public int solution(int[] topping) {

            int [] arr =Arrays.stream(topping).distinct().toArray();  // 중복 제거한 배열
            System.out.println(arr);

            int answer = -1;
            return answer;
        }

}
