// 로프
// https://www.acmicpc.net/problem/2217
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2217 {
    // 10 10 가능
    // 10 15 -> 하나당 감당 무게 25 / 2 = 12  ---> 불가
    // 15 15 불가 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 로프의 개수
        int[] ropes = new int[N]; // 각 로프가 버틸 수 있는 최대 중량 저장 배열

        for(int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine()); // [10, 15]
        }

        Arrays.sort(ropes); // 로프 오름차순 정렬 10 15 

        int maxWeight = 0;

        for(int i = 0; i < N; i++) { // 0, 1
            // (N - i)는 현재 로프와 그 이후의 로프들의 개수
            // 2 - 0 , 2 - 1 
            int currentWeight = ropes[i] * (N-i); 
            // 10 * 2 = 20
            // 15 * 1 = 15

            if(currentWeight > maxWeight) {
                maxWeight = currentWeight; 
            }  
        }
        System.out.println(maxWeight); // 20
    }
}
