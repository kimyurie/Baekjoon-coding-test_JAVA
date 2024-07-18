// A → B
// https://www.acmicpc.net/problem/16953
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16953 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 2
        int B = Integer.parseInt(st.nextToken()); // 162

        // 2 → 4 → 8 → 81 → 162
        // 100 → 200 → 2001 → 4002 → 40021

        int count = 1; // 연산 횟수

        while(B != A) {
            // 불가
            if(B < A) {
                count = -1;
                break;
            }

            // 162 → 81
            if(B % 2 == 0) {  // 162
                B /= 2; // 81
            // 81 → 8
            } else if(B % 10 == 1) { // 81
                B /= 10; // 8
            // 그외 불가
            } else{
                count = -1;
                break;
            }
            count++;
            
        }
        System.out.println(count);
    }
}
