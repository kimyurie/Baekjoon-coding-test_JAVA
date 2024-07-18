// 에너지 드링크
// https://www.acmicpc.net/problem/20115
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P20115 {
     // 에너지 드링크 양 최대
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] list = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()); // [3,2,10,9,6]
        }

        // 내림차순 정렬 
        Arrays.sort(list, Collections.reverseOrder()); // [10, 9, 6, 3, 2]

        // 10, 9 -> 4.5 + 10  = 14.5
        // 14.5 , 6 -> 14.5 + 3 = 17.5
        // 17.5, 3 -> 17.5 + 1.5 = 19
        // 19, 2 -> 19 + 1 = 20

       double total = list[0]; // 10

       for(int i = 1; i < N; i++) {
            total += list[i] / 2.0;
       }
       System.out.println(total); // 20.0
    }
}
