/* 약수
양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 
어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
*/

import java.util.*;


public class BJ1037 {
    public static void main(String[] args) {
        // 양수 A가 24의 진짜 약수가 되려면 24가 A의 배수이고, A가 1과 24가 아니어야 한다.
        // 24의 진짜 약수가 모두 주어질 때, 24를 구하는 프로그램을 작성하시오.
        // 24의 약수 : 1, 2, 3, 4, 6, 8, 12, 24
        // 24의 진짜 약수 : 2, 3, 4, 6, 8, 12
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] realYaksu = new int[n];

        for(int i = 0; i<n; i++){
            realYaksu[i] = sc.nextInt();
        }

        Arrays.sort(realYaksu); // 오름차순

        // for(int j : realYaksu){
        //     System.out.println("["+j+"]");
        // }
        
        System.out.println(realYaksu[0]*realYaksu[n-1]);
        // 제일 앞이 작은거 제일 마지막이 큰 수인데
        // 약수를 오름차순해서 대칭으로 곱하면 무슨 수의 약수인지 알 수 있잖아 
        // 그걸 생각한고 푼 것

    }
}

/* 백준씨 코드
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        //공 무게 맞추기 느낌이네
        int small, big;
        small = big = a[0];
        for (int i=1; i<n; i++) {
            if (small > a[i]) 
                small = a[i];
            if (big < a[i]) 
                big = a[i];
        }
        System.out.println(small*big);
    }
}
 */
