// 2+1 세일
// https://www.acmicpc.net/problem/11508
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P11508 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] list = new Integer[N];

        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순 정렬
        Arrays.sort(list, Collections.reverseOrder());

        int won = 0;
        // 10, 9, 4, 2, 6, 4, 3
        // (10, 3, 2), (4, 6, 4), (9)
        for(int i = 0; i < N; i++) {
            // 3개씩 묶어서 가장 싼 것을 무료로 
            if((i + 1) % 3 != 0) {// 3번째마다 무료 처리
                won += list[i];
            }
        }
        System.out.println(won);
    }
}
