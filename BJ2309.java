/* 일곱 난쟁이
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 
뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다. ㅋㅋ
아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
*/

import java.util.*;

public class BJ2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] a = new int[n];
        int sum = 0;

        for(int i =0; i<n;i++){
            a[i] = sc.nextInt(); // 난쟁이 키 배열에 저장
            sum = sum + a[i]; // 난쟁이 키 모두 합
        }

        Arrays.sort(a); // 오름차순 정렬

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) { // i 다음 부터 시작
                        // 1 2 /1 3/ 1 4/ 1 5 ... 다 빼본다
                if(sum - a[i] - a[j] == 100) { 

                    for(int k=0; k<n; k++) {
                        if (i == k || j == k){ // i가 k랑 같거나 j가 k랑 같거나 하면 
                            continue; // 출력하지 못하게 continue로 보내버린다.
                        }

                        System.out.println(a[k]); //2명 아닌애들 출력
                    }

                    System.exit(0); //정상종료
                }
            }
        }
    }
}
