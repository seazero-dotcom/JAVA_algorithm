package src.oldAlgo;/* 1
2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 
1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.
*/

import java.util.*;

public class BJ4375 {
    public static void main(String[] args) {
        // (A*B)%C = (A%C * B%C)%C
        // (A+B)%C = (A%C + B%C)%C
        //커질수 있는 수만 나머지를 먼저 해주고 10과 1은 한번에 계산하고 나눠준다
        //1 % 7 = 1
        //11 % 7 = 4 = ( 1 * 10 + 1 ) % 7 = ( (1%7) * 10 + 1 ) % 7
        //111 % 7 = 6 = ( 11 * 10 +1 ) % 7 = ( (11%7) * 10 + 1 ) % 7
        //1111 % 7 = 5

        Scanner sc = new Scanner(System.in);

        //hasNextInt()는 
        // Scanner에서 정수를 입력받은 경우 True를 
        //정수를 입력받지 않은 경우 false의 값을 반환받는 메소드이다
        while(sc.hasNextInt()){  //받은 수가 끝날때 까지
            int n = sc.nextInt();
            int num = 0;
            
            for(int i = 1; ;i++){  //1의 개수 카운트 역할
                num = num * 10 + 1;
                num = num % n; //전의 1%n값을 여기에서 num에 저장하므로써 
                                //다음 11에서 num*10+1에서 num 값에 1%n 결과가 바로 들어하는 것이다
                if(num == 0){
                    System.out.println(i); //1의 개수 출력
                    break;
                }
            }

        }
    }
}
