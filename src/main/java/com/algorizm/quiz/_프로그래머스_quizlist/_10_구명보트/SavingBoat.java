package com.algorizm.quiz._프로그래머스_quizlist._10_구명보트;

import java.util.ArrayList;
import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885?language=java
public class SavingBoat {
    public static void main(String[] args){
    SavingBoatSolution solution = new SavingBoatSolution();
    int [] array1 = {70, 50,80};
    int limit = 100;
    System.out.println("답은 " + solution.solution(array1,limit));
    }
}

class SavingBoatSolution {
    public int solution(int[] people, int limit) {
        int answer = 0;  //70, 50, 80, 50   ->  3 // 최대 2명

        Arrays.sort(people); // 오름차순
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int person : people) {
            arrayList.add(person);
        }

        for(int i = 0 ; i < arrayList.size() ; i ++){
            if(limit-arrayList.get(0)<arrayList.get(arrayList.size()-1)){ //혼자 보내는 사람
                answer++;
                arrayList.remove(arrayList.size()-1);
            }
        }

        while(arrayList.size() !=0){
            if(arrayList.size()==1){
                answer++;
                break;
            }

            if(arrayList.get(0)+arrayList.get(arrayList.size()-1)<=limit){
                arrayList.remove(arrayList.size()-1);
                arrayList.remove(0);
                answer++;
            }else {
                arrayList.remove(arrayList.size()-1);
                answer++;
            }
        }


        return answer;
    }
}

