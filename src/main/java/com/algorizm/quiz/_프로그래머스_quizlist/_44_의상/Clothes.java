package com.algorizm.quiz._프로그래머스_quizlist._44_의상;

import javax.sound.midi.Soundbank;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class Clothes {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        Solution solution = new Solution();
        int solution1 = solution.solution(clothes);
        int solution2 = solution.solution(clothes2);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}


class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0 ; i < clothes.length ; i ++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);

        }


        return answer;
    }
}