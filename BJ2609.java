/* 최대공약수와 최소공배수
 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
*/

import java.util.*;

public class BJ2609 {
        //GCD 2부터 min(a,b)까지 모든 정수로 나누어 보는 방법
        //유클리드 호제법 : a를 b로 나눈 나머지를 r이라고 했을 때
        //GCD(a,b) = GCD(b,r)과 같다. r이 0이면 그 때 b가 최대공약수이다.
        //GCD(24,16)=GCD(16,8)=GCD(8,0)=8
 
        public static int GCD(int a, int b){
            if(b == 0){
                return a;
            }else{
                return GCD(b, a%b);
            }
        }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int G = GCD(a,b);
        int LCM = a * b/G; // LCM(a,b) = GCD * a/GCD * b/GCD

        System.out.println(G);
        System.out.println(LCM);
    }
}
