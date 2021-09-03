/* 날짜 계산
준규가 사는 나라는 우리가 사용하는 연도와 다른 방식을 이용한다. 
준규가 사는 나라에서는 수 3개를 이용해서 연도를 나타낸다. 
각각의 수는 지구, 태양, 그리고 달을 나타낸다.

지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M이라고 했을 때, 
이 세 수는 서로 다른 범위를 가진다. (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)

우리가 알고있는 1년은 준규가 살고있는 나라에서는 1 1 1로 나타낼 수 있다. 
1년이 지날 때마다, 세 수는 모두 1씩 증가한다. 만약, 어떤 수가 범위를 넘어가는 경우에는 1이 된다.

예를 들어, 15년은 15 15 15로 나타낼 수 있다. 
하지만, 1년이 지나서 16년이 되면 16 16 16이 아니라 1 16 16이 된다. 
이유는 1 ≤ E ≤ 15 라서 범위를 넘어가기 때문이다.

E, S, M이 주어졌고, 1년이 준규가 사는 나라에서 1 1 1일때, 
준규가 사는 나라에서 E S M이 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램을 작성하시오.
*/

import java.util.*;

public class BJ1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        // 15%15==0     28%28==0
        // 16%15==1
        // 17%15==2
        // 18%15==3
        // 19%15==4
        // 20%15==5
        // ...
        // 28%15==13
        // 29%15==14    55%28==27
        // 30%15==0     56%28==0

        int e=1, s=1, m=1; //1부터 같이 시작해서 입력받은 수 까지 돌게한다

        for(int i=1;;i++){
            if(e==E && s==S && m==M){ // 입력받은 수가 나오면
                System.out.println(i); // 몇 바퀴(==몇년) 돌았는지 출력
                break;
            }
            
            //증가증가
            e +=1;
            s+=1;
            m+=1;

            // 각자의 기준 넘어가서 바로 다음수는 1로 다시시작
            if(e==16){
                e=1;
            }
            if(s==29){
                s=1;
            }
            if(m==20){
                m=1;
            }
        }
    }
}
