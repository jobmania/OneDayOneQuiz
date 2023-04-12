package com.algorizm.quiz._프로그래머스_quizlist._09_짝지어_제거하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeleteCouple {
    public static void main(String[] args){
    String s1 = "baabaa";
    DeleteCoupleSolution deleteCoupleSolution = new DeleteCoupleSolution();
    int answer = deleteCoupleSolution.solution2(s1);
        System.out.println("answer = " + answer);

    }
}

class DeleteCoupleSolution
{
    public int solution(String s)  // 시간초과..(효율성)
    {
        int answer = 0;
        List<String> array = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {  //리스트에 넣고.
            array.add(String.valueOf(s.charAt(i)));
        }
        int count = 0;
        while (count != s.length()) {
            for (int i = 1; i < array.size(); i++) {
                if (array.get((i - 1)).equals(array.get(i))) {
                    array.remove(i - 1);
                    array.remove(i - 1);
                    break;
                }
            }
            count++;
        }

        if (array.size() == 0) {
            answer = 1;
        }
        return answer;
    }


    public int solution2(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int  i = 0 ; i < s.length() ; i ++ ){
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek()!=c){ //비어있거나, 상단의 값 출력
                stack.push(c);
            }else {
                stack.pop();
            }


        }
        if(stack.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}

