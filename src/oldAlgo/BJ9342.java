package src.oldAlgo;
/* 염색체
상근이는 생명과학 연구소에서 염색체가 특정한 패턴인지를 확인하는 일을 하고 있다. 염색체는 알파벳 대문자 (A, B, C, ..., Z)로만 이루어진 문자열이다. 상근이는 각 염색체가 다음과 같은 규칙을 만족하는지 검사해야 한다.

문자열은 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다.
그 다음에는 A가 하나 또는 그 이상 있어야 한다.
그 다음에는 F가 하나 또는 그 이상 있어야 한다.
그 다음에는 C가 하나 또는 그 이상 있어야 한다.
그 다음에는 {A, B, C, D, E, F} 중 0개 또는 1개가 있으며, 더 이상의 문자는 없어야 한다.
문자열이 주어졌을 때, 위의 규칙을 만족하는지 구하는 프로그램을 작성하시오.
*/
import java.io.*;

public class BJ9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.matches("^[A-F]?A+F+C+[A-F]?$")) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
        }

    }
}
