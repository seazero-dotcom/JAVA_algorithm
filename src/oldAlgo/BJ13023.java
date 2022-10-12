package src.oldAlgo;/* ABCDE
BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023 {
    static int N;
    static int M;
    static int a;
    static int b;
    static ArrayList<ArrayList<Integer>> friendGroup;
    static boolean[] visited;
    static int relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        friendGroup = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            friendGroup.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // 친구관계 입력
            // friends = new ArrayList<Integer>(); 위에서 한번에 만들었기 때문에 이렇게 생성 안해도됨
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            friendGroup.get(a).add(b);
            friendGroup.get(b).add(a);
            // friendGroup.add(friends); 위에서 한번에 만들었기 때문에 이렇게 안넣어줘도됨

        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;

            DFS(i, 0);
            if (relation == 4) {
                break;
            }
        }

        if (relation == 4) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int x, int cnt) {
        if (cnt == 4) {
            relation = 4;
            return;
        }

        for (int i : friendGroup.get(x)) { // 아래 이차원 배열에서 friends[x][i] == 1 같은 존재
            if (visited[i])
                continue;
            visited[i] = true;
            DFS(i, cnt + 1);
            // if (friends[x][i] == 1 && visited[i] == false) {
            // visited[i] = true;
            // DFS(i, relation + 1);
            // }
        }
        visited[x] = false;

    }
}
