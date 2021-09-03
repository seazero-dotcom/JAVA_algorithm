/* 약수의 합
두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다. 
예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다. 
자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다. 
x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.

자연수 N이 주어졌을 때, g(N)을 구해보자.
 */

import java.io.*;
import java.util.*;

public class BJ17425 {
    //1 : 1
    //2 : 1 2
    //3 : 1 3
    //4 : 1 2 4
    //5 : 1 5
    //6 : 1 2 3 6
    //7 : 1 7

    //2의 배수는 2를 약수로 갖는 수 2 4 6
    //3의 배수는 3을 약수로 갖는 수 3 6
    // 배열f의 인덱스는 [약수를 구하고자 하는 수]
    //2의 배수인 2 4 6은 2를 약수로 가지고 있는 수이다. 
    // 배열f 2 4 6에 2씩 일괄적으로 더해준다.
    // 1은 모든 수의 약수이기때문에 넣어두고 시작한다.
    // 배열f에 누적해서 더한다.
    // 그 다음 다른 배열g에 앞서 누적해서 더한 배열f들은 다시 더해서 총 합을 구한다.
    
    /* 테케를 받고 n을 입력 받을 때마다 전체를 한번씩 돌려주면 n^2을 넘어가게 된다
        여기서는 시간제한을 1초로 주었다.
        100000000(1억) = O(N)1초
        O(N^2)는 10000(1만)이 1초이다. O(NlogN)은 500만이 1초
        입력받는 자연수n의 최대 크기가 1000000(100만)이므로 MAX로 입력받으로 ㄱㅊ은듯 */
   
        static final int MAX = 1000000; //long이 8bytes로  - ,808 ~ 9,223,372,036,854,775,807
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long[] f = new long[MAX+1];
        for(int i = 1;i<=MAX;i++){
            f[i] = 1;
        }
        for(int j = 2;j<=MAX;j++){
            for(int k = 1;j*k <=MAX; k++){
                f[j*k] = f[j*k] + j; // 약수들 누적 합
            }
        }

        long[] g = new long[MAX+1];
        for(int x=1;x<=MAX;x++){
            g[x] = g[x-1] + f[x];
        }

        // for(int p : g){
        //     System.out.println("["+p+"]");
        // }

        // String Line이므로 Integer.parseInt를 이용하여 형변환해야함
        int TC = Integer.parseInt(br.readLine()); // 테케 입력받기
        while(TC-- > 0){
            int n = Integer.parseInt(br.readLine()); // 자연수n입력받고
            bw.write(g[n]+"\n"); // 위에서 다 저장해뒀으니까 한방에 불러오기 
            // 자동개행기능이 없으므로 \n로 줄바꿈을 해줘야함 or bw.newLine()
        }
        bw.flush(); //남아있는 데이터를 모두 출력시킴   

    }
}

