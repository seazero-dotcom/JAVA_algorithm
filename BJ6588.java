/* 골드바흐의 추측
1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.

4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 
또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.

이 추측은 아직도 해결되지 않은 문제이다.

백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.
*/

import java.util.*;
public class BJ6588 {
    public static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] check = new boolean[MAX+1];

        ArrayList<Integer> primeNumber = new ArrayList<Integer>();

        check[0] = check[1] = true; //소수가 아닌거

        //에라토스테네스의 체를 사용한다
        for(int i = 2; i*i<= MAX; i++){
            if(check[i]== true){ // 소수 아니면
                continue; // 다시 포문 도는거 
            }

            primeNumber.add(i); // 소수면 add된다 (위에 if문을 들어가지 못한 애들)

            for(int j = i+i;j<=MAX; j+=i){
                check[j]= true; // 2의 배수 소수 아닌 것으로 바꿈
            }
        }

        // A + B = N (A가 소수 일때 B도 소수인가 ? N은 짝수이다.)
        while(true){
            int n  = sc.nextInt();
            if(n == 0){
                break;
            }
            for(int i =1; i<primeNumber.size();i++){
                int p = primeNumber.get(i); // 소수 가져오기
                if(check[n-p] == false){ // n-p가 소수면 (B가 소수인것)
                    System.out.println(n + " = " + p + " + " + (n-p));
                    break;
                }
            }
        }

    }
}
