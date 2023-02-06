package com.algorizm.quiz._프로그래머스_quizlist._30_Password;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Password {
    public static void main(String[] args) {
        String s1 = "z";
        String skip1 = "abcdefghij";
        int index = 20;

        Solution solution = new Solution();
        System.out.println(solution.solution(s1, skip1, index));

    }
}

class Solution {
    public String solution(String s, String skip, int index) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] sArr = s.split("");
        String[] skipArray = skip.split("");

        for (String s1 : skipArray) {
            alphabet = alphabet.replace(s1,"");
        }

        String[] alphabetArray = alphabet.split("");

        //   0 0 <0> 0

        for (int i = 0; i < s.length(); i++) {
            String s1 = sArr[i];

            int q1 = Arrays.asList(alphabetArray).indexOf(s1);
            System.out.println(q1);
            int q2 = q1 + index;  // 1000

            while (q2 >= alphabetArray.length) {
                q2 = -(alphabet.length() - q2);
            }
                sArr[i] = alphabetArray[q2];
        }
        return  Arrays.stream(sArr).collect(Collectors.joining());
    }
}