package com.algorizm.quiz._프로그래머스_quizlist._04_스택_큐_올바른_괄호;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.Stack;

public class CorrectParenthesis {
    public static void main(String[] args){
        CorrectParenthesisSolution correctParenthesisSolution = new CorrectParenthesisSolution();
        String s1 = "()()";
        String s2 = "())(()";
        String s3 = ")()(";
        String s4 = "(()(";
//        boolean answer = correctParenthesisSolution.solution(s3);
//        System.out.println(answer);

        Solution solution = new Solution();
        System.out.println(solution.solution(s3));

    }
}
// (                )
class CorrectParenthesisSolution {
    boolean solution(String s) {
            int left=0;
            int right=0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='('){
                    left++;
                }else {
                    right++;
                }
                if (right > left){
                    return false;
                }
            }
            return left == right;
        }

}

class Solution {
    boolean solution(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            try {
                if('('==(s.charAt(i))) stack.push("엄");
                if(')'==(s.charAt(i))) stack.pop();
            }catch (Exception e){
                return false;
            }

        }
        return stack.isEmpty();

    }
}
