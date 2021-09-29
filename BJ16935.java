
/* 배열 돌리기3
크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 총 6가지가 있다.

1번 연산은 배열을 상하 반전시키는 연산이다.
2번 연산은 배열을 좌우 반전시키는 연산이다.
3번 연산은 오른쪽으로 90도 회전시키는 연산이다.
4번 연산은 왼쪽으로 90도 회전시키는 연산이다.
5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.
5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.
6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.
*/
import java.io.*;
import java.util.StringTokenizer;

public class BJ16935 {
    static int N;
    static int M;
    static int R;
    static int[][] A;
    static int[][] B;
    static int[][] temp;

    // 번호별로 움직이는 것 각각 구현하고
    public static void numOne() { // 상하
        N = A.length;
        M = A[0].length;
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                B[i][j] = A[N - i - 1][j]; // 상하로 움직이면 행이 달라진다
            }
        }
        A = B;
    }

    public static void numTwo() { // 좌우
        N = A.length;
        M = A[0].length;
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                B[i][j] = A[i][M - j - 1]; // 좌우로 움직이면 열이 달라진다
            }
        }
        A = B;

    }

    public static void numThree() { // 오른쪽 90
        N = A.length;
        M = A[0].length;
        B = new int[M][N];

        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                B[i][j] = A[N - j - 1][i]; // 오 90
            }
        }
        A = B;

    }

    public static void numFour() { // 왼쪽 90
        N = A.length;
        M = A[0].length;
        B = new int[M][N]; // 8 6

        for (int i = 0; i < M; i++) {// 8
            for (int j = 0; j < N; j++) {// 6
                B[i][j] = A[j][M - i - 1]; // 왼 90
            }
        }
        A = B;

    }

    public static void numFive() { // 1->2->3->4->1
        N = A.length;
        M = A[0].length;
        B = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                B[i][j + M / 2] = A[i][j]; // 2 <- 1
                B[i + N / 2][j + M / 2] = A[i][j + M / 2]; // 3 <- 2
                B[i + N / 2][j] = A[i + N / 2][j + M / 2]; // 4 <- 3
                B[i][j] = A[i + N / 2][j]; // 1 <- 4
            }
        }
        A = B;

    }

    public static void numSix() { // 1->4->3->2->1
        N = A.length;
        M = A[0].length;
        B = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                B[i + N / 2][j] = A[i][j]; // 4 <- 1
                B[i + N / 2][j + M / 2] = A[i + N / 2][j]; // 3 <- 4
                B[i][j + M / 2] = A[i + N / 2][j + M / 2]; // 2 <- 3
                B[i][j] = A[i][j + M / 2]; // 1 <- 2
            }
        }
        A = B;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        R = Integer.parseInt(st.nextToken()); // 수행해야하는 연산의 수
        A = new int[N][M];

        // 배열 받고
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        String[] numInput = br.readLine().split(" ");
        // 수행해야하는 연산들 switch case로 이동하기
        for (int i = 0; i < R; i++) {
            int num = Integer.parseInt(numInput[i]);

            switch (num) {
                case 1:
                    numOne();
                    break;

                case 2:
                    numTwo();
                    break;

                case 3:
                    numThree();
                    break;

                case 4:
                    numFour();
                    break;

                case 5:
                    numFive();
                    break;

                case 6:
                    numSix();
                    break;
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                bw.write(A[i][j] + " ");

            }
            bw.newLine();
        }

        bw.flush();

        br.close();
        bw.close();
    }

}
