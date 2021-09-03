/* 리모컨
수빈이는 TV를 보고 있다. 
수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. 
+를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 
채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 
어떤 버튼이 고장났는지 주어졌을 때, 
채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 

수빈이가 지금 보고 있는 채널은 100번이다. 
*/

import java.util.*;

public class BJ1107 {

    static boolean[] broken = new boolean[10];
    static int possible(int c){
        if(c==0){
            if(broken[0]){
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while(c>0){
            if(broken[c%10]){
                return 0;
            }
            len += 1;
            c /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] brokenBUTTON = new boolean[M];

        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            brokenBUTTON[x] = true; //고장남
        }

        int answer = N - 100; //숫자 버튼 안 눌렀을 때

        if(answer < 0){
            answer = - answer; // 음수이면 양수로 전환해준다
        }

        for(int i =0;i<=1000000; i++){
            int c = i;
            int len = possible(c); // 누를 수 있는 숫자의 개수

            if(len>0){
                int press = c - N;
                if(press < 0){
                    press = -press;
                }
                if(answer > len + press){
                    answer = len + press;
                }
            }
        }
        System.out.println(answer);
    }
}
