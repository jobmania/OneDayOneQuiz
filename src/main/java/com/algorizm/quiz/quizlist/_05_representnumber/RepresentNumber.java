package com.algorizm.quiz.quizlist._05_representnumber;
// https://school.programmers.co.kr/learn/courses/30/lessons/12924
public class RepresentNumber {
    public static void main(String[] args){
        RepresentNumberSolution solution = new RepresentNumberSolution();
        int n1 = 5;
        int answer = solution.solution(n1);
        System.out.println(answer);

    }
}

class RepresentNumberSolution {
    public int solution(int n) {
        int totalNum = 0;
        int count = 0;

        int i = n;
        while(i > 0){
           for(int j = i ; j > 0; j--){
               totalNum += j;
               if(totalNum==n){    // n과 같다면 for 문 나오기..
                   count++;
                   totalNum =0;
                   break;
               }
               if(totalNum>n){   //  초과시 for문 나오기..
                   totalNum=0;
                   break;
               }
               if(j==1){            // 끝까지 갔을때 totalNum 초기화.
                   totalNum = 0;
               }
           }
            i--;
        }
        return count;
    }
}