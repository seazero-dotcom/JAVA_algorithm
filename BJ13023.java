
/* ABCDE
BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 */
// 어려워서 못해먹겠음
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023 {

    static int N, M, res;
    static ArrayList<Integer>[] friends;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        // 관계 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }
        // 0번 친구부터 확인
        for (int i = 0; i < N; i++) {

            visited = new boolean[N];
            visited[i] = true;
            process(i, 0);
            // 위와 같은 관계 발견 시
            if (res == 4)
                break;
        }

        if (res == 4)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static void process(int my, int cnt) {

        res = Math.max(res, cnt);
        // 위와 같은 관계 발견 시
        if (res == 4)
            return;

        for (int frd : friends[my]) {
            if (visited[frd])
                continue;
            visited[frd] = true;
            process(frd, cnt + 1);
        }
        // 다른 경로에서도 확인할 수 있도록
        visited[my] = false;
    }

}