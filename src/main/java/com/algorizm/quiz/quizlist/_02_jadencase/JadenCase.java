package com.algorizm.quiz.quizlist._02_jadencase;

//https://school.programmers.co.kr/learn/courses/30/lessons/12951

public class JadenCase {
    public static void main(String[] args){
        SolutionJadenCase solutionJadenCase = new SolutionJadenCase();
        String s1 = "3peoPle  unFollowed me";
        String s2 = "for the last week  kK";
        String answer = solutionJadenCase.solution2(s2);
        System.out.println(answer);

    }
}

class SolutionJadenCase{
    public String solution1(String s) {
        String allSmall=s.toLowerCase();
        String [] arr = allSmall.split(" ");

        for(int i =0 ; i< arr.length ; i ++) {
            String [] arrays = arr[i].split("");
            arrays[0] = arrays[0].toUpperCase();
            arr[i] = String.join("",arrays);
        }
        return String.join(" ",arr);
        //// 테스트 케이스 4 실패
    }

    public String solution2(String s){
        StringBuffer sb = new StringBuffer();
        s = s.toLowerCase();
        sb.append(Character.toUpperCase(s.charAt(0)));
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ' ') sb.append(" ");
            else if(s.charAt(i - 1) == ' ')
                sb.append(Character.toUpperCase(s.charAt(i)));
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
