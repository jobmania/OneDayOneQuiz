package com.algorizm.quiz._프로그래머스_quizlist._17_다음_큰_숫자;



public class nextBigNum {
    public static void main(String[] args){
        SolutionnextBigNum solution = new SolutionnextBigNum();
        int s1 = 15;
        int answer = solution.solution(s1);
        System.out.println("answer = " + answer);
        // 4 100 -> 8 1000
        // 3 11 -> 5 101
        // 5 101 -> 6 110
        // 100101 -> 100110
    }
}

class SolutionnextBigNum {
    public int solution(int n) {
        String beforeNumBinary =Integer.toBinaryString(n);
        int countOne = 0;
        int nextNumCountOne = 0;
        int nextNum = 0;


//        for(int i = 0 ; i< beforeNumBinary.length() ; i++){
//            if(beforeNumBinary.split("")[i].equals("1")) countOne++;
//        }
        countOne = beforeNumBinary.length() - beforeNumBinary.replace("1", "").length();


        while (countOne != nextNumCountOne) {
            nextNum = n + 1;
            int sum = 0;
            String afterNumBinary = Integer.toBinaryString(nextNum);

//            for(int i = 0 ; i< afterNumBinary.length() ; i++){
//                if(afterNumBinary.split("")[i].equals("1")) sum++;
//            }
//            nextNumCountOne = sum;
            nextNumCountOne = afterNumBinary.length() - afterNumBinary.replace("1", "").length();

            n++;
        }
        return nextNum;
    }
}
