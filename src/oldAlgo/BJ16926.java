package src.oldAlgo;/* 배열 돌리기 1
크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 다음과 같이 반시계 방향으로 돌려야 한다.

A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
   ↓                                       ↑
A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
   ↓         ↓                   ↑         ↑
A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
   ↓                                       ↑
A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
예를 들어, 아래와 같은 배열을 2번 회전시키면 다음과 같이 변하게 된다.

1 2 3 4       2 3 4 8       3 4 8 6
5 6 7 8       1 7 7 6       2 7 8 2
9 8 7 6   →   5 6 8 2   →   1 7 6 3
5 4 3 2       9 5 4 3       5 9 5 4
 <시작>         <회전1>        <회전2>
배열과 정수 R이 주어졌을 때, 배열을 R번 회전시킨 결과를 구해보자.
*/

import java.io.*;

public class BJ16926 {
    static int N;
    static int M;
    static int R;
    static int[][] A;
    static int[][] B;
    static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]); // 행
        M = Integer.parseInt(st[1]); // 열
        R = Integer.parseInt(st[2]); // 회전수

        A = new int[N][M];

        // 배열 받고
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }
        /*
         * B[i] = A[k+i]; k%배열의 크기가 A[k][j] (k<=j<M-k) A[N-k-1][j] (k<=j<M-k)
         * A[i][k](k<=i<N-k) A[i][M-k-1] (k<=i<N-k)
         */

        /*
         * 행 열 중 작은 수를 2로 나눈 나머지가 그룹의 개수이다 5행 4열/2 --> 2그룹 # # | # # # # | # # # # | # #
         * # # | # # # # | # #
         **** 
         * [[[[ min(N, M) mod 2 = 0 ]]]]**** 작은수가 2의 배수여야함 이런 조건이 있기 때문에 안 됨 5행/2 --> XX
         * 6열 # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
         */

        int group = Math.min(N, M) / 2;
        temp = A;
        for (int l = 0; l < R; l++) { // 회전 수
            B = new int[N][M];

            for (int k = 0; k < group; k++) { // 0~K번째 그룹 돌기

                for (int j = k + 1; j < M - k; j++) { // 첫 행
                    B[k][j - 1] = temp[k][j];
                }
                for (int i = k; i < N - k - 1; i++) { // 첫 열
                    B[i + 1][k] = temp[i][k];
                }
                for (int j = k; j < M - k - 1; j++) { // 맨 아래 행
                    B[N - k - 1][j + 1] = temp[N - k - 1][j];
                }
                for (int i = N - k - 1; i > k; i--) { // 맨 오른쪽 열
                    B[i - 1][M - k - 1] = temp[i][M - k - 1];
                }

            }
            temp = new int[N][M];
            temp = B;
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                bw.write(temp[i][j] + " ");

            }
            bw.newLine();
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
