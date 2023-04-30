package com.algorizm.quiz._프로그래머스_quizlist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizSample {
    public static void main(String[] args){
        SolutionQuiz11 method = new SolutionQuiz11();
        int x1 = 2;
        int x2 = 4;
        int x3 = -4;
        int n1 = 5;
        int n2 = 3;
        int n3 = 3;

        long[] answer =  method.solution(x2,n2);
//        System.out.println(Arrays.toString(answer));

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        SolutionQuiz11.printPermutations(list,0,list.size()-1);

    }
}

class SolutionQuiz11 {
    public long[] solution(int x, int n) {
        long[] arr1 = new long[n];
        for(int i=0; i<n; i++){
            arr1[i]= (long)x*(i+1);
        }
        return arr1;
    }




    public static void printPermutations(List<Integer> list, int start, int end) {
        if(start == end) {
            System.out.println(list);
        } else {
            for(int i = start; i <= end; i++) {
                Collections.swap(list, start, i); // 두 요소의 위치를 바꿈
                printPermutations(list, start+1, end); // 다음 인덱스 재귀 호출
                Collections.swap(list, start, i); // 다시 두 요소의 위치를 바꿈 (원래대로)
            }
        }
    }
}

