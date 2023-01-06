package com.algorizm.quiz.quizlist._01_maxmin;

import java.util.Arrays;


public class MaxAndMin {
    public static void main(String[] args){

        String s1 = "1 2 3 4";
        String s2 = "-1 -2 -3 -4";
        String s3 = "-1 -1";

        SolutionMaxAndMin solutionMaxAndMin = new SolutionMaxAndMin();
        String answer = solutionMaxAndMin.solution(s2);
        System.out.println(answer);

    }
}

class SolutionMaxAndMin {
        public String solution(String s) {
            String[] arr = s.split(" ");
            int[] newArr = new int[arr.length];
            for(int i = 0 ; i<arr.length ; i++){
               newArr[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(newArr);
            //

            int a1 = newArr[0];
            int a2 = newArr[arr.length-1];

            return String.valueOf(a1)+ " "+ String.valueOf(a2);
        }
}
