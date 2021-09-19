
/*단어 정렬
알파벳 소문자로 이루어진 N개의 단어가 들어오면 
아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로
단, 같은 단어가 여러번 입력된 경우에는 한 번씩만 출력
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        // 정렬조건을 Comparator를 사용해서 정의해 주었다.
        Arrays.sort(str, new Comparator<String>() {

            public int compare(String str1, String str2) {

                if (str1.length() == str2.length()) { // 단어 길이가 같은 경우

                    return str1.compareTo(str2); // 사전 순으로 정렬
                    // 사전순으로 정렬할 때는 compareTo()메소드를 쓰면된다.
                    // 이 메소드 또한 반환값은 int형으로 나온다.
                } else {
                    return str1.length() - str2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        // 많은 문자열을 한 번에 더할 때 쓴다.
        // String과 문자열을 더할 때 새로운 객체를 생성하는 것이아니라 기존의 데이터에 더하는 방식
        // 속도가 빠르고 상대적으로 부하가 적다.
        // append()는 문자열을 더하는 역할
        // 문자열을 출력하기 위해서는 sysoyt(sb.toString())

        sb.append(str[0]).append('\n');

        for (int i = 1; i < N; i++) {
            if (!str[i].equals(str[i - 1])) { // 중복되지 않는 단어만 출력
                sb.append(str[i]).append('\n');
            }
        }
        System.out.println(sb);

    }
}
