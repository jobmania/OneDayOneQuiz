package com.algorizm.quiz._프로그래머스_quizlist._45_추억점수;

import java.util.Arrays;
import java.util.HashMap;

public class Memory {
    public static void main(String[] args) {

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = { {"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        Solution solution = new Solution();
        int[] solution1 = solution.solution(name, yearning, photo);
        System.out.println("solution1 = " + Arrays.toString(solution1));


    }
}

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> map =new HashMap<>();

        for(int i = 0 ; i < name.length ; i ++){
            map.put(name[i], yearning[i]);
        }

        int i = 0;
        for(String[] pic : photo){
            int sum = 0;
            for(String s : pic){
                Integer integer = map.get(s);
                // 없다면 null을 0 처리
                if(integer!=null){
                    sum += integer;
                }
            }
            answer[i] = sum;
            i++;
        }


        return answer;
    }
}