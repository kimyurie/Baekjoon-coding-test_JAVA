// 동전 0
// https://www.acmicpc.net/problem/11047
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    
        
        int N = Integer.parseInt(st.nextToken()); // 동전 종류 
        int K = Integer.parseInt(st.nextToken()); // 동전 합 // 4200

        Integer[] list = new Integer[N];

        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        // list 내림차순으로
        Arrays.sort(list, Collections.reverseOrder());

        int num = 0;

        for(int i = 0; i < N; i++) {
            if(list[i] <= K) { // <= 4200
               // 4200 / 1000 = 4
               num += K / list[i];
               // 4200 % 1000 = 200 
               K %= list[i];
            }
        }
        System.out.println(num);
    }
}
