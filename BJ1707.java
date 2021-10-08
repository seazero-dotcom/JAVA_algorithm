
/*이분 그래프 
그래프의 정점의 집합을 둘로 분할하여, 
각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 
그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
*/
import java.io.*;
import java.util.*;

public class BJ1707 {
    static int K;
    static int V;
    static int E;
    static int u;
    static int v;
    static ArrayList<ArrayList<Integer>> Bipartite;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사이클이 생기지 않는지 확인하면 되는건가??
        // 4 4
        // 2 1
        // 3 2
        // 4 3
        // 4 1
        K = Integer.parseInt(br.readLine()); // 테케 수

        while (K-- > 0) {
            Bipartite = new ArrayList<ArrayList<Integer>>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new boolean[V + 1];

            for (int i = 0; i < V + 1; i++) {
                Bipartite.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                Bipartite.get(u).add(v);
                Bipartite.get(v).add(u);
            }

            // DFS(1, -1);

            if (DFS(1, -1)) {
                bw.write(String.valueOf("NO\n")); // 사이클이 있어서 이분 그래프가 아니다
            } else {
                bw.write(String.valueOf("YES\n")); // 이분 그래프다
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean DFS(int now, int parent) {
        visited[now] = true;
        for (int next : Bipartite.get(now)) {
            if (!visited[next]) {
                if (DFS(next, now)) {

                    return true;
                }
            } else if (next != parent) {
                return true;
            }
        }
        return false;

    }
}