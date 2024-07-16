// 폴리오미노
// https://www.acmicpc.net/problem/1343
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1343 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine(); // XXXXXX
        StringBuilder result = new StringBuilder(); // 결과 저장

        int i = 0;
        while(i < board.length()) { // i < 6
            if(board.charAt(i) == 'X') {
                int count = 0; // 연속된 X개수 세기 위한 변수

                // 1. 연속된 'X'의 길이를 센다
                while(i < board.length() && board.charAt(i) == 'X') {
                    count++;
                    i++;
                }

                // 2. 연속된 'X'의 길이가 2와 4로 나누어지지 않는 경우 -1을 반환
                if(count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                // 3. 연속된 'X'의 길이에 따라 'AAAA'와 'BB'배치
                // 4의 배수만큼 'AAAA' 배치
                while(count >= 4) {
                    result.append("AAAA");
                    count -= 4;
                }

                // 남은 'X'가 2개일 경우 'BB' 배치
                if(count == 2) {
                    result.append("BB");
                }
            }else{
                // 'X'가 아닌 경우 '.'를 그대로 결과에 추가
                result.append(board.charAt(i));
                i++;
            }
        }

        System.out.println(result.toString());

    }
}
