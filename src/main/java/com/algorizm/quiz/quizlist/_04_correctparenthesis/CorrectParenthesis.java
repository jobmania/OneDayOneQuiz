package com.algorizm.quiz.quizlist._04_correctparenthesis;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909

public class CorrectParenthesis {
    public static void main(String[] args){
        CorrectParenthesisSolution correctParenthesisSolution = new CorrectParenthesisSolution();
        String s1 = "()()";
        String s2 = "())(()";
        String s3 = ")()(";
        String s4 = "(()(";
        boolean answer = correctParenthesisSolution.solution(s2);
        System.out.println(answer);

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
