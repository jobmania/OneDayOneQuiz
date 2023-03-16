package com.algorizm.quiz._프로그래머스_quizlist._32_틱택토;

public class TicTacTo {
    public static void main(String[] args) {

        String[] board1 = {"O.X", ".O.", "..X"};
        String[] board2 = {"OOO", "...", "XXX"};
        String[] board3 = {"...", ".X.", "..."};
        String[] board4 = {"...", "...", "..."};
        String[] board5 = {"XXX", "...", "OOO"};
        String[] board6 = {"XXX", "XOO", "OOO"}; // 예외 케이스 !!!

        // 시작은 O

        System.out.println(Solution.solution(board6)); // 1(정상), 0 , 0 , 1

    }
}


// 1. X > O 이라면 FAIL
// 2. O가 승리 일경우 O > X
// 3. X가 승리일 경우 0 = X

// 결과가 맞다고 하고 이전 상황으로 거슬러 올라가 맞는지 판별하면 끝입니다
// or 오히려 정상 케이스만 반납을한다면?
class Solution {
    public static int solution(String[] board) {
        int sumO = 0;
        int sumX = 0;
        String[][] array = new String[3][3];

        for (int i = 0; i < board.length; i++) {
            String[] strings = board[i].split("");
            for (int j = 0; j < strings.length; j++) {
                String s = strings[j];
                array[i][j]=s;

                if(s.equals("O")){
                    sumO++;
                } else if (s.equals("X")) {
                    sumX++;
                }
            }
        }

        // 1. X > O 또는 O가 X보다 1이상 크면 FAIL
        if(sumX > sumO){
            return 0;
        }else if(sumO > sumX + 1){
            return 0;
        }

        // 2. O의 승리와 X의 승리는 병렬적이면 안됨

        if(winCase(array,"O")&&winCase(array,"X")){
            return 0;
        }

        // 3. O가 승리 일경우 O > X,
        // 승리조건
        if(winCase(array,"O")) {
            if(sumO>sumX){
                return 1;
            }else {
                return 0;
            }
        }

        // 4. X가 승리 일경우 O == X
        if (winCase(array,"X")) {
            if(sumX==sumO){
                return 1;
            }else {
                return 0;
            }
        }

        return 1;
    }

    private static boolean winCase(String[][] array, String s) {
        // 조건 8가지
        if( getValue(array,0, 0, s)&&getValue(array,0,1,s)&&getValue(array,0,2,s)){
            return true;
        }

        if( getValue(array,0, 0, s)&&getValue(array,1,1,s)&&getValue(array,2,2,s)){
            return true;
        }

        if( getValue(array,0, 0, s)&&getValue(array,1,0,s)&&getValue(array,2,0,s)){
            return true;
        }

        if( getValue(array,1, 0, s)&&getValue(array,1,1,s)&&getValue(array,1,2,s)){
            return true;
        }

        if( getValue(array,2, 0, s)&&getValue(array,2,1,s)&&getValue(array,2,2,s)){
            return true;
        }

        if( getValue(array,0, 1, s)&&getValue(array,1,1,s)&&getValue(array,2,1,s)){
            return true;
        }

        if( getValue(array,0, 2, s)&&getValue(array,1,2,s)&&getValue(array,2,2,s)){
            return true;
        }

        if( getValue(array,0, 2, s)&&getValue(array,1,1,s)&&getValue(array,2,0,s)){
            return true;
        }

        return false;
    }

    private static boolean getValue(String[][] array, int x, int y, String s) {
        return array[x][y].equals(s);
    }
}