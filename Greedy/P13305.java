// 주유소
// https://www.acmicpc.net/problem/13305
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N - 1]; // 각 도로간 길이들 

        for(int i = 0; i < N-1; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] list2 = new int[N]; // 각 도로의 리터당 가격

        for(int i = 0; i < N; i++) {                                                  
            list2[i] = Integer.parseInt(st2.nextToken());
        }

        int won = 0;
        int minPrice = list2[0]; // 현재까지의 최소 리터당 가격 // 5
        won += list[0] * minPrice; // 첫 도로의 비용 추가 
        
        // 두번째 도시부터 반복 시작 
        for(int i = 1; i < N - 1; i++) {
            if(list2[i] < minPrice) {                                      
                minPrice = list2[i]; // 더 저렴한 가격 발견시 최소 가격 업데이트
            }
            won += list[i] * minPrice;                                 
        }
        System.out.println(won);
    }
}
