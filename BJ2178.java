
/* 미로탐색
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, 
(1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
*/

import java.io.*;
import java.util.*;

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ2178 {
    static int N;
    static int M;
    static ArrayList<String> maze;
    static boolean[][] visited;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 최단거리 문제이기 때문에 BFS으로 풀어야한다. DFS로 하면 시간초과가 난다.
        // DFS는 stack과 재귀함수(Recursion)로 가능하지만, BFS는 Queue로 구현한다.

        maze = new ArrayList<String>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            maze.add(br.readLine());
        }

        BFS();

        bw.write(String.valueOf(distance[N - 1][M - 1]));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS() {
        Queue<Coordinate> q = new LinkedList<Coordinate>();
        q.add(new Coordinate(0, 0));
        distance[0][0] = 1;
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Coordinate coordinate = q.remove();
            int x = coordinate.x;
            int y = coordinate.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maze.get(nx).charAt(ny) == '1' && !visited[nx][ny]) {
                        q.add(new Coordinate(nx, ny));
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }
    }
}
