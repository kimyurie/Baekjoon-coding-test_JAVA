// 알바생 강호
// https://www.acmicpc.net/problem/1758
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P1758 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 손님 수 
        Integer[] list = new Integer[N]; // 각 손님이 주려고 생각한 팁 저장 배열
        
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        // 팁 내림차순 정렬
        Arrays.sort(list, Collections.reverseOrder());

        long maxTip = 0;

        // 각 손님의 순서 계산해 팁 최대화
        for(int i = 0; i < N; i++) {
            // i번째 손님 팁 계산
            // 손님이 주려고 했던 팁 - (받은 순서 - 1)
            int tip = list[i] - i;

            // 계산된 팁이 음수가 아니면 최대 팁에 추가 
            if(tip > 0) {
                maxTip += tip;
            }
        }
        System.out.println(maxTip);
    }
}
