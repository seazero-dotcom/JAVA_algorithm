package src.oldAlgo;/* 숫자의 합
N개의 숫자가 공백 없이 쓰여있다. 
이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
*/

import java.util.*;

public class BJ11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String number = sc.next();
        // 스트링을 한글자씩 배열에 저장한다음에 배열을 돌아가면서 누적합
        
        int sum = 0;
        //int[] number3 = new int[N];

        for (int i = 0; i < N; i++) {
            //String은 Integer.parseInt()로 int변환 가능
            //char는 Character.getNumericValue()로 int로 변환함
            //number3[i] = Character.getNumericValue(number.charAt(i));
            sum += Character.getNumericValue(number.charAt(i)); //한줄로 표현하기
        }

        System.out.println(sum);
    }
}
