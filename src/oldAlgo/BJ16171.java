package src.oldAlgo;
/*나는 친구가 적다(small)
친구가 적은 성민이는 수업에 결석해도 시험이나 과제에 대한 정보를 제대로 얻을 수 없었다. F 학점을 받을 위기까지 아슬아슬하게 결석일 수를 유지하던 성민이는, 어느 날 갑자기 영문도 모른 채 쪽지시험을 보게 되었다!

갑작스러운 쪽지 시험으로 마음이 급해진 성민이는 매직아이를 사용해 벼락치기를 하기로 한다.

성민이가 듣는 과목의 교과서는, 알파벳 소문자(a-z)와 알파벳 대문자(A-Z)로만 이루어져 있다. 성민이가 교과서에서 찾고자 하는 키워드도 역시 알파벳 소문자와 대문자로만 이루어져 있다. 하지만, 성민이에겐 큰 문제가 생겼다. 결석한 날의 수업 내용을 친구에게 빌려 필기를 하던 중, 교과서에 숫자(0-9)를 적어버린 것이다.

키워드를 찾기 힘들어 패닉에 빠진 성민이는 몇 안 되는 친구인 당신에게 도움을 요청했다. 성민이를 도와, 교과서에서 성민이가 찾고자 하는 키워드의 존재 여부를 알려주자.
*/

import java.io.*;

public class BJ16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String strCheck = br.readLine();

        String removeNum = str.replaceAll("[0-9]", "");

        if (removeNum.contains(strCheck)) {
            System.out.println('1');
        } else {
            System.out.println('0');
        }
    }
}
