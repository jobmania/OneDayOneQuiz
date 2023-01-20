package com.algorizm.quiz._프로그래머스_quizlist._12_expectbracket;

import java.util.HashMap;

public class expectBracket {
    public static void main(String[] args) {
        ExpectBracketSolution expectBracketSolution = new ExpectBracketSolution();
        int n1 = 8;
        int a1 = 4;
        int b1 = 7;
        System.out.println("answer = " + expectBracketSolution.solution(n1,a1,b1));

    }
}

class ExpectBracketSolution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        HashMap<Integer, Integer> mapA = new HashMap<>();
        mapA.put(a,a);
        HashMap<Integer, Integer> mapB = new HashMap<>();
        mapB.put(b,b);

        while(true){
            int [][] array2 = new int[n/2][2];
            for (int i = 0 ; i < n/2 ; i ++) {
                array2[i][0]=2*i+1;
                array2[i][1]=2*i+2;
                if(mapA.get(a) == 2*i+1  || mapA.get(a) == 2*i+2 ) mapA.put(a,i+1);
                if(mapB.get(b) == 2*i+1  || mapB.get(b) == 2*i+2 ) mapB.put(b,i+1);
            }
            answer++;

            if(mapA.get(a).equals(mapB.get(b))){
                break;
            }else {
                if(n%2==1) n = n/2+1;
                else n = n/2;
            }


        }


        return answer;
    }



    public int solution2(int n, int a, int b)
    {
        // 깔끔...
        int round = 0;
        while(a != b)
        {
            a = a/2 + a%2;
            b = b/2 + b%2;
            round++;
        }
        return round;
    }





}