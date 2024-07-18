// 잃어버린 괄호
// https://www.acmicpc.net/problem/1541
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 괄호 쳐서 식의 값을 최소로
public class P1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // "55-50+40"

        //  1. '-' 기준으로 문자열 분할 
        String[] sub = input.split("-"); // ["55", "50+40"]

        int result = 0;

        for(int i = 0; i < sub.length; i++) {
            int sum = 0;
            // 2. '+' 기호를 기준으로 나눔
            String[] add = sub[i].split("\\+"); 
            // ["55"] 
            // ["50", "40"]

            for(int j = 0; j < add.length; j++) {
                sum += Integer.parseInt(add[j]); 
                // sum = 55
                // sum = 90
            }

            if(i == 0) {
                result += sum; // 55
            }else {
                result -= sum;
                // result = 55 - 90 = -35
            }
        }

        System.out.println(result); // -35

    }
}
