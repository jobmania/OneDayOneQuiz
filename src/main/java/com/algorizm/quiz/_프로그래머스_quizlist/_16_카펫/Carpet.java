package com.algorizm.quiz._프로그래머스_quizlist._16_카펫;

public class Carpet {
    public static void main(String[] args){
        CarpetSolution solution = new CarpetSolution();
        int s1 = 24;
        int s2 = 24;
        int[] answer = solution.solution(s1,s2);
        System.out.println("answer[0]  answer[1] = " + answer[0] + "," + answer[1]);

    }
}

class CarpetSolution {
    public int[] solution(int brown, int yellow) {
        int x = 1;  // 가로
        int y = 1;  // 세로
        
        
        loop1 :  //루프문을 붙여줘 해당 루프문에서 탈출 
        for (x = 3; x < 5001; x++) {
            for (y = 3; y <= x; y++) {
                if (brown == 2*x+2*y-4 && yellow==x*y-brown) {
                    
                    break loop1;
                }
            }
        }

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int[] answer = {x,y};
        return answer;
    }
}