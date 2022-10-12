package src.oldAlgo;
/*나이트의 이동
체스판 위에 한 나이트가 놓여져 있다. 
나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 
나이트가 이동하려고 하는 칸이 주어진다. 
나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
*/

import java.io.*;
import java.util.*;

public class BJ7562 {
    static int tc; // 테케
    static int n; // 변의 길이
    static int startX, startY; // 시작 좌표
    static int endX, endY; // 도착 좌표

    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 }; // (10, 10)일 때 10시 방향, 11시 방향, 1시 방향, 2시, 4시, 5시, 7시, 8시
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    static int[][] visited = new int[301][301]; // 거리측정과 방문기록 동시

    static class Knight {
        int x, y;

        public Knight(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tc = Integer.parseInt(br.readLine());

        while (tc-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            fillVisited();

            bfs(startX, startY, endX, endY);

            System.out.println(visited[endX][endY]);
            // bw.write(visited[endX][endY]);
            // bw.flush();
        }

        // bw.close();
        br.close();
    }

    public static void fillVisited() {
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                visited[i][j] = -1;
            }
        }
    }

    public static void bfs(int a, int b, int c, int d) { // startX, startY, endX, endY
        Queue<Knight> que = new LinkedList<>();
        que.add(new Knight(a, b)); // startX, startY
        visited[a][b] = 0; // 방문했다 이말이야

        while (!que.isEmpty()) {
            Knight k = que.poll(); // 가장 먼저 보관한 값 꺼내 > 1회전때는 startX, startY이 들어있겠지?

            if (k.x == c && k.y == d) { // 꺼낸게 endX, endY와 같으면 빠져나옴
                break;
            }

            for (int i = 0; i < 8; i++) { // 8방향 돌아다니기
                int nx = k.x + dx[i];
                int ny = k.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n // 범위 안에 들어가고
                        && (visited[nx][ny] == -1 || visited[k.x][k.y] + 1 < visited[nx][ny])) { // 방문 안했거나 0+1 < 0

                    visited[nx][ny] = visited[k.x][k.y] + 1;
                    que.add(new Knight(nx, ny));
                }
            }
        }
    }

}

// import java.io.*;
// import java.util.*;

// public class src.oldAlgo.BJ7562 {
// static final int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
// static final int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

// public static void main(String args[]) throws IOException {
// // Scanner sc = new Scanner(System.in);
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

// // int t = sc.nextInt();
// int tc = Integer.parseInt(br.readLine()); // 테케

// while (tc-- > 0) {
// int n = Integer.parseInt(br.readLine()); // 한 변의 길이
// StringTokenizer st = new StringTokenizer(br.readLine());
// int startX = Integer.parseInt(st.nextToken()); // 현재 위치 x
// int startY = Integer.parseInt(st.nextToken()); // 현재 위치 y
// st = new StringTokenizer(br.readLine());
// int endX = Integer.parseInt(st.nextToken()); // 이동할 위치 x
// int endY = Integer.parseInt(st.nextToken()); // 이동할 위치 y

// int[][] d = new int[n][n];
// for (int i = 0; i < n; i++) {
// Arrays.fill(d[i], -1);
// }

// Queue<Integer> q = new LinkedList<>();
// q.add(startX);
// q.add(startY);
// d[startX][startY] = 0;
// while (!q.isEmpty()) {
// int x = q.remove();
// int y = q.remove();
// for (int k = 0; k < 8; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];
// if (0 <= nx && nx < n && 0 <= ny && ny < n) {
// if (d[nx][ny] == -1) {
// d[nx][ny] = d[x][y] + 1;
// q.add(nx);
// q.add(ny);
// }
// }
// }
// }
// // System.out.println(d[ex][ey]);
// bw.write(d[endX][endY]);
// }

// bw.flush();
// bw.close();
// br.close();
// }
// }
