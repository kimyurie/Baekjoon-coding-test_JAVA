package String.문장속단어;

import  java.util.*;

public class Main {
    public String solution(String str) {
        String answer = "";
        /*int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");

        for(String x : s) {
            int len = x.length();
            if(len > m) {
                m = len;
                answer = x;
            }
        }*/

        int m = Integer.MIN_VALUE, pos;
        // 띄어쓰기 발견 못하면 -1을 리턴, 발견하면 index 번호 리턴
        while((pos = str.indexOf(' '))!= -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m) { // > 해야지 길이가 같을 시 앞쪽 단어 반환
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        // 마지막 단어 처리
        if(str.length() > m) answer=str;
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(T.solution(str));
    }
}
