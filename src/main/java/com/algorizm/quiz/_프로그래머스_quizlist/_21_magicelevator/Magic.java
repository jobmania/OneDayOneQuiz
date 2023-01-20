package com.algorizm.quiz._프로그래머스_quizlist._21_magicelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magic {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int s1 = 5555;  //20 - 4     // 2554 -> 3000 -400 -50  4  // 2669 -> 3000 -500  -50 -1  // 2712 -> 3000 -300 10 2  // 91 -> 101 -1 -100  / +10 -1 -100 = 3
        // 45일때
        //. 단, 엘리베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘리베이터는 움직이지 않습니다. 민수의 세계에서는 0층이 가장 아래층이며 엘리베이터는 현재 민수가 있는 층에 있습니다.
        System.out.println(solution.solution(s1));

    }
}

class Solution {
    public int solution(int storey) {
        int answer = 0;

        List<Integer> integerList = new ArrayList<>();
        int temp = storey;
        // 각 자리 숫 자를 넣기
        while (temp > 0) {
            integerList.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(integerList);
        // 3244라면 [ 3 2 4 4 ]으로 쌓임..
        // 6,7,8,9가 나온다면 -를 하는게 유리, 1,2,3,4 라면 +, 5에 따라 여려가지분기점이 생김.. 5의 앞자리가 5이상이면 무조건 +하는것이!
        for (int i = integerList.size() - 1; i >= 1; i--) {
            int temps = integerList.get(i);

            if (temps == 10) {
                int tempUpper = integerList.get(i - 1); // 앞자리 숫자
                tempUpper++;
                integerList.add(i - 1, tempUpper);
                continue;
            }

            //// 자릿수 비교

            if (temps > 5) {
                int tempUpper = integerList.get(i - 1);
                tempUpper++;
                integerList.add(i - 1, tempUpper);
                answer += 10 - temps;

            } else if (temps == 5) {
                int tempUpper = integerList.get(i - 1); // 앞자리 숫자
                if (tempUpper >= 5) { // 5보다 크다면 올림.
                    tempUpper++;
                    integerList.add(i - 1, tempUpper);
                }
                answer += temps;
            } else {
                answer += temps;
            }
        }

        // 마지막 자리
        if(integerList.get(0)==10){
            answer++;
        } else if (integerList.get(0)>5) {
            answer += 11-integerList.get(0);
        } else {
            answer += integerList.get(0);
        }


        return answer;
    }
}
