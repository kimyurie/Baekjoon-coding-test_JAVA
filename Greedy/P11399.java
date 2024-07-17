// ATM
// https://www.acmicpc.net/problem/11399
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 걸리는 시간에 따라 오름차순 정렬 
public class P11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 5
        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()); // [3,1,4,3,2]
        }

        Arrays.sort(list); // [1,2,3,3,4]

        int sum = 0;
        int time = 0;  // 현재 사람까지의 누적 시간 저장

        for(int i = 0; i < N; i++) {
            time += list[i]; // 현재 사람의 인출 시간 + 누적 시간 
            sum += time;
        }

        System.out.println(sum);
    }
}


