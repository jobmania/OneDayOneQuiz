package com.algorizm.quiz._프로그래머스_quizlist._47_두원사이의_정수쌍;

public class Clean {
    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;  // 20
        Solution solution = new Solution();
//        long solution1 = solution.solution(r1, r2);
//        System.out.println("solution1 = " + solution1); //x좌표와 y좌표가 모두 정수인 점의 개수를 return
        // 20


        Solution2 solution2 = new Solution2();
        long solution3 = solution2.solution(r1, r2);
        System.out.println("solution3 = " + solution3);
    }
}

//  1<=r1
class Solution { //  1 사분면만 구해보자 (x축 기준) - > 효율성 통과 실패
    public long solution(int r1, int r2) {
        long answer = 0;

        int squareR1 = (int) Math.pow(r1, 2);
        int squareR2 = (int) Math.pow(r2, 2);

        for(int i = 1 ; i <= r2 ; i++  ){ // x축 기준으로 x는 1부터 시작.
            for (int j = 0 ; j <= r2 ; j++){ //

                int distance = (int) (Math.pow(i, 2) + Math.pow(j, 2));

                if( squareR1 <= distance && distance <= squareR2){
                    answer++;
                }


            }
        }



        return 4* answer;
    }
}

class Solution2 { // 1사분면만 계산하자
    public long solution(int r1, int r2) {
        long answer = 0;

        double inner = Math.pow(r1, 2);
        double outer = Math.pow(r2, 2);

        // a^2 = c^2-b^2
        for(int i = 1 ; i <=r2 ; i++ ){
            int bigY = (int) Math.floor(Math.sqrt(outer - Math.pow(i, 2))); // 외측은 내림
            int smallY = (int) Math.ceil(Math.sqrt(inner - Math.pow(i, 2))); // 내측은 올림

            // 두 수의 사이값 추출

            answer += bigY-smallY+1;

        }

        return 4 * answer;
    }


}