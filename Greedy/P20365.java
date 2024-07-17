// 블로그2
// https://www.acmicpc.net/problem/20365
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20365 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 문자 수 

        String colors = br.readLine(); // BBRBRBBR

        // 각 색 카운트
        int blue= 0;
        int red = 0;

        // 초기 색깔 설정
        char currentColor = colors.charAt(0); // B

        // 초기 색깔 기반으로 블록 수 증가
        if(currentColor == 'B') {
            blue++; 
        }else {
            red++;
        }

        // 색이 변경되는 지점 찾기 
        for(int i = 1; i < N; i++) { 
            if(colors.charAt(i) != currentColor) {  // 색이 변경되는 지점
                currentColor = colors.charAt(i); // 초기 색깔 갱신

                if(currentColor == 'B') {
                    blue++;
                }else{
                    red++;
                }

            }
        }

        // 작은값 기준으로 최소 작업 횟수 계산 
        int min = Math.min(blue, red) + 1; // (3,3) + 1 = 4
        System.out.println(min); // 4
    }
}
