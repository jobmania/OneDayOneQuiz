package com.algorizm.quiz._프로그래머스_quizlist._35_Hindex;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5}; // 3
        int[] arr2 = {0, 0, 0, 0, 0}; // 0
        int[] arr3 = {25, 8, 5, 3, 3}; // 3

        Solution solution = new Solution();
        System.out.println(solution.solution(arr));
        System.out.println(solution.solution(arr2));
        System.out.println(solution.solution(arr3));
    }



}
class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        // { 0 ,1 ,3 ,5 ,6  }

        for (int i = citations.length-1 ; i >= 0; i--) {
            answer++;

            int citation = citations[i];
            if(citation < answer) {
               answer--;
                break;
            }

        }



        return answer;
    }
}