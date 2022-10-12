package src.oldAlgo;/* 소수 구하기
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
*/

import java.util.*;

public class BJ1929 {
    static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //소수 찾기에서는 에라토스테네스의 체를 사용한다

        boolean[] check = new boolean[MAX+1]; // 지움 : ture, 지우지 않음 : false

        check[0] = check[1] = true; //소수가 아닌것 지우고 시작

        for(int i = 2; i*i <= MAX; i++){
            if(check[i] == false){ // false가 디폴트 값

                for(int j = i+i; j<=MAX; j+=i){ // 4 6 8 10 12 14 16 ...
                    check[j] = true; //배수들 지워버리기(ture)
                }
            }
        }

        int M = sc.nextInt();
        int N = sc.nextInt();
        for(int i =M; i<=N; i++){
            if(check[i]==false){ // 소수인것만 false로 남아있음
                System.out.println(i);
            }
        }
    }
}
