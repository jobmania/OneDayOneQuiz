package com.algorizm.quiz._프로그래머스_quizlist._36_괄호회전하기;

import java.util.Stack;

public class Rotate {
    public static void main(String[] args) {
        String str1 = "[](){}";
        String str2 = "}]()[{";
        String str3 = "[)(]";
        String str4 = "}}}";


        Solution solution = new Solution();

        System.out.println(solution.solution(str1));
        System.out.println(solution.solution(str2));
        System.out.println(solution.solution(str3));
        System.out.println(solution.solution(str4));

    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        if (checkStack(s)) {
            answer++;
        }

        for (int i = 1; i < s.length(); i++) {
            s = rotateString(s);
            if (checkStack(s)) {
                answer++;
            }
        }


        return answer;
    }

    private String rotateString(String s) {
        char firstChar = s.charAt(0);
        return s.substring(1) + firstChar;
    }

    private boolean checkStack(String s) {


        Stack<String> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    switch (c) {
                        case "]":
                            checkPeekAndDelete(stack, "[");
                            break;
                        case "}":
                            checkPeekAndDelete(stack, "{");
                            break;
                        case ")":
                            checkPeekAndDelete(stack, "(");
                            break;
                    }
                } else {
                    stack.push(c);
                }

            }
        }
        return stack.isEmpty();
    }

    private static void checkPeekAndDelete(Stack<String> stack, String close) {
        if (stack.peek().equals(close)) {
            stack.pop();
        }
    }

}