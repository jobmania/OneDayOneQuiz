package com.algorizm.quiz._프로그래머스_quizlist._18_이진_변환_반복하기;

//https://school.programmers.co.kr/learn/courses/30/lessons/70129

public class RepeatBinaryConversion {
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "110010101001";
        int[] answer = solution.solution(s);
        System.out.println(answer[0]);
        System.out.print(answer[1]);
    }


}

class Solution {
    public int[] solution(String s) {
        int countZero = 0;
        int countConversion= 0;

        StringBuffer str = new StringBuffer(s);
        while(!str.toString().equals("1")){
            int tempZero = 0;
            for(int i = 0 ; i <str.length() ; i ++ ){
                if( str.charAt(i) == '0'){
                    countZero++;
                    tempZero++;
                }
                if(i == str.length()-1){
                    countConversion++;
                    int tempS = str.length()-tempZero; // 6
                    str.delete(0,str.length()); // 다지우기
                    String binaryString = Integer.toBinaryString(tempS); // 이진법
                    str.append(binaryString);
                    break;
                }
            }

        }

        return new int[]{countConversion, countZero};
    }
}