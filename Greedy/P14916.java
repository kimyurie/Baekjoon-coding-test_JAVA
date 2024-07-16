// 거스름돈
// https://www.acmicpc.net/problem/14916
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 거스름돈 액수

        int result = -1; // 결과 저장 변수, 초기값 -1로 설정
        int five = n / 5; // 최대 5원 동전 갯수 // 13 / 5 = 2

        // 5원짜리 동전 개수 줄여가며 가능한 조합 찾음
        while(five >= 0) {
            int remainder = n - (five * 5); // 13 - 2 * 5 = 3 // 13 - 1 * 5 = 8
            if(remainder % 2 == 0) { // 3 % 2 != 0  // 8 % 2 == 0
                result = five + (remainder / 2); // 1 + (8 / 2) = 1 + 4 = 5
                break; 
            }
            five--; // 5원짜리 동전 개수 하나 줄이고 다시 시도  // 1
        }
        System.out.println(result); // 5
    }
}
