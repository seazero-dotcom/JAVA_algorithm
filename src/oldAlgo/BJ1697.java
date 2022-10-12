package src.oldAlgo;/* 숨바꼭질
수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 
수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
*/

//최단거리 문제와 유사하여 BFS로 풀이

import java.util.*;
import java.io.*;

public class BJ1697 {

    private static int N; // 수빈이 위치
    private static int K; // 동생 위치
    private static int[] map = new int[100001];

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(map[K]);

        br.close();
    }

    public static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        que.offer(N); // 수빈이 위치 추가

        while (!que.isEmpty()) {
            N = que.poll(); // 가장 먼저 보관한 값 꺼내고

            if (N == K) { // 수빈이와 동생의 위치가 같을 때
                break;
            }

            if (N - 1 >= 0 && map[N - 1] == 0) { // 수빈이가 걷고 방문 안한곳
                que.offer(N - 1); // 수빈이 걷고 추가
                map[N - 1] = map[N] + 1;
            }

            if (N + 1 <= 100000 && map[N + 1] == 0) { // 수빈이가 걷고 방문 안한곳
                que.offer(N + 1); // 수빈이 걷고 추가
                map[N + 1] = map[N] + 1;
            }

            if (N * 2 <= 100000 && map[N * 2] == 0) { // 수빈이가 순간이동하고 방문안한 곳
                que.offer(N * 2); // 수빈이 순간이동하고 추가
                map[N * 2] = map[N] + 1;
            }
        }
    }
}
