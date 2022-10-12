package src.oldAlgo;/* 그룹단어 체커
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 
각 문자가 연속해서 나타나는 경우만을 말한다. 
예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, 
kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
*/

import java.io.*;

public class BJ1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean check() throws IOException { // 그룹단어 인지/아닌지만 판단
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i); // 현재 문자 저장

            // 이전 문자와 현재 문자가 같다면, 해당문자가 중복된 문자인지 검사하지 않는다
            // 이전 문자과 현재 문자가 다르다면, 해당문자가 중복된 문자인지 여부를 검사한다. (뜯어져나온 중복인지 확인)

            if (prev != now) { // 앞 문자와 같지 않다면
                // 중복여부 검사
                if (check[now - 'a'] == false) { // 현재 문자가 처음 나오는(f) 경우
                    check[now - 'a'] = true; // t로 바꿔주고
                    prev = now; // 다른 다음글자와 비교하기위해 prev를 변경해준다
                } else {// 현재 문자가 이전에(뜯어져서) 이미 나온경우
                    return false; // 그룹단어가 아닌게된다
                }

            } else { // 앞문자와 같아서 연속된 경우
                continue; // 중복여부 검사 안함
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int groupSum = 0;

        for (int i = 0; i < N; i++) {
            if (check() == true) { // true면 그룹단어 인 것
                groupSum++; // 그룹단어 카운트
            }
        }
        System.out.println(groupSum);

    }
}
