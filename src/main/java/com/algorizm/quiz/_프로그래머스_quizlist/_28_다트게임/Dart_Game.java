package com.algorizm.quiz._프로그래머스_quizlist._28_다트게임;

public class Dart_Game {
    public static void main(String[] args) {
        String s1 = "1S2D*3T";  // 37
        String s2 = "1D2S#10S"; // 9
        String s3 = "1D#2S*3S"; // 3
        String s4 = "1D2S3T*"; //23
        String s5 = "1D2S#10S"; //5
        String s6 = "1T2D3D#"; //-4
        String s7 = "1D2S3T*"; //59

        Solution solution = new Solution();
//        System.out.println(solution.solution(s1));
        System.out.println(solution.solution(s2));
//        System.out.println(solution.solution(s3));
//        System.out.println(solution.solution(s4));
//        System.out.println(solution.solution(s5));
//        System.out.println(solution.solution(s6));
//        System.out.println(solution.solution(s7));


    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        int temp = 0;
        int[] roundScore = new int[3];
        int round = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c == '1') {
                if (dartResult.charAt(i + 1) == '0') {
                    temp = 10;
                    i++;
                }
                else {
                    temp = 1;
                }
            } else if (c == 'S') {
                roundScore[round] = temp;
                round++;
            } else if (c == 'D') {
                roundScore[round] = temp * temp;
                round++;
            } else if (c == 'T') {
                roundScore[round] = temp * temp * temp;
                round++;
            } else if (c == '#') {
                roundScore[round - 1] = -roundScore[round - 1];
            } else if (c == '*') {
                if (round == 1) {
                    roundScore[round - 1] = 2 * roundScore[round - 1];
                } else {
                    roundScore[round - 2] = 2 * roundScore[round - 2];
                    roundScore[round - 1] = 2 * roundScore[round - 1];
                }
            } else {
                temp = c - '0';
            }


        }

        answer = roundScore[0] + roundScore[1] + roundScore[2];
        return answer;
    }
}