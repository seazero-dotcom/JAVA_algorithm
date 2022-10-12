package src.oldAlgo;

import java.io.BufferedReader;

/*비밀번호 발음하기
좋은 패스워드를 만드는것은 어려운 일이다. 대부분의 사용자들은 buddy처럼 발음하기 좋고 기억하기 쉬운 패스워드를 원하나, 이런 패스워드들은 보안의 문제가 발생한다. 어떤 사이트들은 xvtpzyo 같은 비밀번호를 무작위로 부여해 주기도 하지만, 사용자들은 이를 외우는데 어려움을 느끼고 심지어는 포스트잇에 적어 컴퓨터에 붙여놓는다. 가장 이상적인 해결법은 '발음이 가능한' 패스워드를 만드는 것으로 적당히 외우기 쉬우면서도 안전하게 계정을 지킬 수 있다. 

회사 FnordCom은 그런 패스워드 생성기를 만들려고 계획중이다. 당신은 그 회사 품질 관리 부서의 직원으로 생성기를 테스트해보고 생성되는 패스워드의 품질을 평가하여야 한다. 높은 품질을 가진 비밀번호의 조건은 다음과 같다.

1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
이 규칙은 완벽하지 않다;우리에게 친숙하거나 발음이 쉬운 단어 중에서도 품질이 낮게 평가되는 경우가 많이 있다.
*/

import java.io.*;

public class BJ4659 {
    static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        boolean canUse;

        while (true) {
            str = br.readLine(); // 암호받고
            canUse = false; // 조건 3개 맞지 않으면 f

            if (str.equals("end")) {
                break;
            }

            int vowelO = 0;
            int vowelE = 0;
            // 조건1
            for (int i = 0; i < str.length(); i++) {
                if (checkVowel(str.charAt(i))) { // 조건1을 만족하고 돌아오면
                    canUse = true; // 조건1 맞으니까 true로 변경
                    break;
                }
            }

            if (!canUse) { // 조건1이 false면 is not
                System.out.println("<" + str + "> is not acceptable.\n");
            } else {
                for (int i = 0; i < str.length(); i++) {
                    char strChar = str.charAt(i);

                    // 조건2
                    if (i != str.length() - 1 && strChar == str.charAt(i + 1) && strChar != 'o' && strChar != 'e') {
                        canUse = false;
                        break;
                    }

                    // 조건3
                    boolean vowel = checkVowel(strChar);
                    if (vowel) {
                        vowelO++;
                        vowelE = 0;
                    } else {
                        vowelE++;
                        vowelO = 0;
                    }

                    if (vowelO == 3 || vowelE == 3) {
                        canUse = false;
                        break;
                    }

                }

                if (canUse) {
                    System.out.println("<" + str + "> is acceptable.\n");
                } else {
                    System.out.println("<" + str + "> is not acceptable.\n");

                }
            }
        }
        br.close();

    }

    static boolean checkVowel(char check) {

        if (check == 'a' || check == 'e' || check == 'i' || check == 'o' || check == 'u') {
            return true;
        }

        return false;
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }

}
