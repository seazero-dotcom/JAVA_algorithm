package src.oldAlgo;/* 소수찾기
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
*/
import java.util.*;

public class BJ1978 {

    
    public static boolean is_prime(int x){ //테케 문제니까 다 저장 해두고 찾기
        
        if(x <= 1){
            return false; // 소수가 아니다
        } else if( x==2 ){
            return true; // 소수다
        }

        for(int i = 2; i*i <= x; i++){ // i = 2 부터 루트N 까지만 돌아도 구할 수 있다.
            if( x % i == 0){
                return false; //아니다
            }
        }
        return true; //소수다
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 테케 수 입력받기
        
        int primeCnt = 0; // 소수 개수 카운트

        while( n-- > 0){ // 테케 만큼 돌리면서 입력 받기
            if(is_prime(sc.nextInt())){ //숫자 한 개씩 입력
                primeCnt += 1; //소수면 카운트 ~
            }
        }
        System.out.println(primeCnt);
    }
    
}
