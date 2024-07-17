// 서강근육맨
// https://www.acmicpc.net/problem/20300
package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P20300 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] list = new long[N];


        for(int i = 0; i < N; i++) {
            list[i] = sc.nextLong();
        }

        Arrays.sort(list); // [1,2,3,4,5]

        // 1 4 선택 / 2 3 선택 / 5 선택
        long M = 0;

        if(N % 2 == 0) {
            for(int i = 0; i < N / 2; i++) {
                M = Math.max(M, list[i] + list[N - 1 - i]);
            }
        }else{
            // 중앙에 있는 한 개의 운동기구를 미리 M에 할당
            M = list[N - 1]; // list[5 - 1] = list[4] = 3

            for(int i = 0; i < (N - 1) / 2; i++) { // i = 0 ~ 1
                M = Math.max(M, list[i] + list[N - 2 - i]);
                // list[0] + list[3] = 1 + 4 = 5 = M
                // list[1] + list[2] = 2 + 3 = 5 = M
            }
        }
        System.out.println(M); // 5
    }
}
