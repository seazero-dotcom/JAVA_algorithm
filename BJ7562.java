
/*나이트의 이동
체스판 위에 한 나이트가 놓여져 있다. 
나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 
나이트가 이동하려고 하는 칸이 주어진다. 
나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
*/
import java.io.*;
import java.util.*;

public class BJ7562 {
    static final int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static final int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String args[]) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            int[][] d = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], -1);
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(sx);
            q.add(sy);
            d[sx][sy] = 0;
            while (!q.isEmpty()) {
                int x = q.remove();
                int y = q.remove();
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (d[nx][ny] == -1) {
                            d[nx][ny] = d[x][y] + 1;
                            q.add(nx);
                            q.add(ny);
                        }
                    }
                }
            }
            // System.out.println(d[ex][ey]);
            bw.write(d[ex][ey]);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
