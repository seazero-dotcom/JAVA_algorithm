package src.oldAlgo;
/* 단지번호붙이기
<그림 1>과 같이 정사각형 모양의 지도가 있다. 
1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
*/
import java.io.*;
import java.util.*;

public class BJ2667 {
    public static int dx[] = { 0, 0, 1, -1 };
    public static int dy[] = { 1, -1, 0, 0 };
    public static int[] danji;
    public static int N;
    public static int apartNum = 0; // 아파트 단지 번호의 수
    public static boolean[][] visited; // 방문여부
    public static ArrayList<String> Apt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Apt = new ArrayList<String>();
        visited = new boolean[N][N];
        danji = new int[N + 1]; // 단지에 아파트 몇 채 있는지 카운트 담기

        for (int i = 0; i < N; i++) { // 아파트 위치 입력받기
            Apt.add(br.readLine());
        }

        ArrayList<Integer> answerAptList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && Apt.get(i).charAt(j) == '1') {
                    apartNum = 0;
                    DFS(i, j);
                    answerAptList.add(apartNum);
                }
            }
        }

        bw.write(String.valueOf(answerAptList.size()) + "\n");

        Collections.sort(answerAptList);
        for (int i : answerAptList) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true; // 방문하면 True
        apartNum += 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) { // 지도 범위 안에 들었는지 확인
                if (Apt.get(nx).charAt(ny) == '1' && !visited[nx][ny]) { // 아파트가 있고, 방문안한 곳
                    DFS(nx, ny);
                }
            }
        }

    }
}
