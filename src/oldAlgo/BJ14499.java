package src.oldAlgo;
/* 주사위 굴리기 */
import java.io.*;
import java.util.StringTokenizer;

public class BJ14499 {

    static int[][] map;
    static int[] dx = { 0, 0, -1, 1 }; // 동 서 북 남
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dice = new int[7];

    public static void eastOne() {

        int temp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = temp;

    }

    public static void westTwo() {

        int temp = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = temp;

    }

    public static void northThree() {

        int temp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = temp;
    }

    public static void southFour() {

        int temp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 가장 윗면이 1, 동쪽을 바라보는 방향이 3
        // 동 east 1, 서 west 2, 북 north 3, 남 south 4
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int x = Integer.parseInt(st.nextToken()); // 주사위 놓을 좌표
        int y = Integer.parseInt(st.nextToken()); // 주사위 놓을 좌표
        int K = Integer.parseInt(st.nextToken()); // 명령의 개수

        map = new int[N][M];

        for (int i = 0; i < N; i++) { // 지도 입력받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()); // 이동하는 명령을 순서대로 입력
        for (int i = 0; i < K; i++) { // 명령을 순서대로 이동하기

            int num = Integer.parseInt(st.nextToken());
            int nx = x + dx[num - 1];
            int ny = y + dy[num - 1];

            // 이 조건문 위치가 중요한 것 같다.
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue; // 지도 바깥으로 이동시키려 하는 경우에는 무시해
            }

            switch (num) {
                case 1:
                    eastOne();
                    break;
                case 2:
                    westTwo();
                    break;
                case 3:
                    northThree();
                    break;
                case 4:
                    southFour();
                    break;
            }
            x = nx;
            y = ny;

            // 이동한 칸에 쓰여있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } else {// 0이 아닌 경우에는 칸에 쓰여있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여있는 수는 0이 된다.
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

            bw.write(dice[1] + "\n");

        }
        br.close();
        bw.flush();

        bw.close();

    }
}
