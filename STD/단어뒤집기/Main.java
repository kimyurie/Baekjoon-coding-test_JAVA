// https://cote.inflearn.com/contest/10/problem/01-04
package STD.단어뒤집기;

import java.util.*;

public class Main {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        /* StringBuilder 쓰는 이유?
        문자열 객체가 계속 만들어지지 않고 처음 만들어진 문자열 객체 하나로 변형해 써서 메모리 낭비 x
        => String 연산 많아질 시 사용*/

       /* for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }*/

        for(String x : str) {
            char[] s = x.toCharArray();
            int lt = 0; // 맨 왼쪽 인덱스
            int rt = x.length() - 1; // 맨 오른쪽 인덱스
            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            // String.valueOf(s) : s배열을 String화 시킴
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        for(String x : T.solution(n, str)) {
            System.out.println(x);
        }
    }
}
