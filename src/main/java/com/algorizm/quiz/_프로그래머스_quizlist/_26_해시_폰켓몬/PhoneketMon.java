package com.algorizm.quiz._프로그래머스_quizlist._26_해시_폰켓몬;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneketMon {
    public static void main(String[] args) {
        int[] num1 = {3, 1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.solution(num1));



    }
}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> hashMap =new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
        }


        List<Integer> list = new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            list.add(integer);
        }

        if(list.size() > nums.length/2 ){
            return  nums.length/2;
        }

        answer = list.size();

        return answer;
    }
}