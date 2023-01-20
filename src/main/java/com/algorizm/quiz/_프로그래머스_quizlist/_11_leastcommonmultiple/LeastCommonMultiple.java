package com.algorizm.quiz._프로그래머스_quizlist._11_leastcommonmultiple;

import java.util.Arrays;
import java.util.HashMap;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        LeastCommonMultipleSolution solution = new LeastCommonMultipleSolution();
        int[] array1 = {2,6,8,14};
        System.out.println("답은  " + solution.solution(array1));

    }
}

class LeastCommonMultipleSolution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);   //배열 오름차순
        int count = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        int value1=arr[0];
        int value2=arr[1];

        while (true){

            map.put(arr[count], value1);
            map.put(arr[count+1], value2);

            if(map.get(arr[count]).equals(map.get(arr[count+1]))){
                answer = map.get(arr[count]);

            }else if(map.get(arr[count]) > map.get(arr[count+1])){
                value2 = map.get(arr[count+1])+arr[count+1];
                map.put(arr[count],value2);
                continue;
            }else {
                value1 = map.get(arr[count])+arr[count];
                map.put(arr[count],value1);
                continue;
            }

            count++;
            if(count==arr.length-1) break;
            arr[count] = answer;
            value1 = answer;
            value2 = arr[count+1];
        }


        return answer;
    }
}