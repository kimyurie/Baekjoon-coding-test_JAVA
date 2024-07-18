// 회의실 배정
// https://www.acmicpc.net/problem/1931
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의실을 사용할 수 있는 회의의 최대 개수
// (1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다.
public class P1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 11

        // 시작시간, 끝나는 시간 입력받음
        int[][] meetings = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간 
        }

        // 끝나는 시간 기준 정렬
        Arrays.sort(meetings, (a, b) -> {
            // 끝나는 시간이 같으면 시작 시간 기준 정렬
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });

        int count = 0; // 회의 최대 개수
        int endTime = 0; // 현재 회의 끝나는 시간

        // 회의 선택
        for(int i = 0; i < N; i++) {
            // 현재 회의 시작 시간이 이전 회의 끝나는 시간 이후라면
            if(meetings[i][0] >= endTime) {
                // 현재 회의 끝나는 시간을 업데이트
                endTime = meetings[i][1];
                count++; // 해당 회의 선택
            }
        }

        System.out.println(count); // 4
    }
}
