package com.algorizm.quiz._프로그래머스_quizlist._33_리코쳇;

public class Reco {
    public static void main(String[] args) {

        String[] array1 = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] array2 = {".D.R", "....", ".G..", "...D"};
        System.out.println("1번 = " + Solution.solution(array1));
        System.out.println("2번 = " + Solution.solution(array2));

    }
}
class Solution {
    public static int solution(String[] board) {
        int answer = 0;

        for (int i = 0; i <board.length; i++) {
            String[] strings = board[i].split("");
            for (int j = 0; j <strings.length ; j++) {

            }
        }



        return answer;
    }
}
