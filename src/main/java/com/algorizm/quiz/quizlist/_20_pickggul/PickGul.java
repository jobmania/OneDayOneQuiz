package com.algorizm.quiz.quizlist._20_pickggul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PickGul {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k =4;
        int[] arr1 = {1, 3, 2, 5, 4, 5, 2, 3 };  // 3개
        System.out.println("종류 최소 갯수는 " + solution.solution( k,arr1));

    }


}
class Solution {
    public int solution(int k, int[] tangerine) {
        // 출력  크기 초과 ..
        int answer = 0;
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (Integer integer : tangerine) {
            // 값에 따라 몇개를 들고 있는지 확인.
            hashMap1.put(integer, hashMap1.getOrDefault(integer,0)+1);
        }

        List<Integer> keySet = new ArrayList<>(hashMap1.keySet());
        // value값순으로 내림차순
        keySet.sort(((o1, o2) -> hashMap1.get(o2).compareTo(hashMap1.get(o1))));
        System.out.println("keySet = " + keySet);
        
        int count = 0;
        while(true){
            k -= hashMap1.get(keySet.get(count));
            if(k <= 0) {
                answer++;
                break;
            }

            answer++;
            count++;
        }




        return answer;
    }
}
