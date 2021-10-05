/* 배열 돌리기 2
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
// import java.util.*;

public class BJ16927 {
    static int N;
    static int M;
    static int R;
    static int[][] A;
    static int[][] B;
    static int[][] C;
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

        int group = Math.min(N, M) / 2;
        C = new int[N][M];

        for (int l = 0; l < group; l++) { // 0~K번째 그룹 돌기

            temp = A;
            int len = ((N - l * 2) * 2 + (M - l * 2) * 2) - 4;

            for (int k = 0; k < R % len; k++) { // 회전 수
                B = new int[N][M];

                for (int j = l + 1; j < M - l; j++) { // 첫 행
                    B[l][j - 1] = temp[l][j];
                    C[l][j - 1] = B[l][j - 1];
                }
                for (int i = l; i < N - l - 1; i++) { // 첫 열
                    B[i + 1][l] = temp[i][l];
                    C[i + 1][l] = B[i + 1][l];
                }
                for (int j = l; j < M - l - 1; j++) { // 맨 아래 행
                    B[N - l - 1][j + 1] = temp[N - l - 1][j];
                    C[N - l - 1][j + 1] = B[N - l - 1][j + 1];
                }
                for (int i = N - l - 1; i > l; i--) { // 맨 오른쪽 열
                    B[i - 1][M - l - 1] = temp[i][M - l - 1];
                    C[i - 1][M - l - 1] = B[i - 1][M - l - 1];
                }

                temp = new int[N][M];
                temp = B;
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                bw.write(C[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
