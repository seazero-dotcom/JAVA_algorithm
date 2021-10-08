
/* 연결 요소의 개수
방향 없는 그래프가 주어졌을 때, 
연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
*/
import java.io.*;
import java.util.*;

public class BJ11724 {
    static int N;
    static int M;
    static int u;
    static int v;
    static ArrayList<ArrayList<Integer>> connected;
    static boolean[] visited;
    static int component;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수

        connected = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            connected.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            connected.get(u).add(v);
            connected.get(v).add(u);
        }

        for (int i = 1; i < N + 1; i++) {

            if (visited[i] == false) { // 방문한적 없는 노드 방문하면서 카운트
                DFS(i);
                component++;
            }
        }

        bw.write(String.valueOf(component));

        bw.flush();
        bw.close();
        br.close();

        // System.out.println("************ 이중 ArrayList 찍어보기 **************");
        // for (int i = 1; i < connected.size(); i++) {
        // System.out.print("[" + i + "] ");
        // for (int j = 0; j < connected.get(i).size(); j++) {
        // System.out.print(connected.get(i).get(j) + " ");
        // }
        // System.out.println();
        // }

    }

    public static void DFS(int x) {

        for (int i : connected.get(x)) {
            if (visited[i])
                continue;

            visited[i] = true;
            DFS(i);
        }

    }
}