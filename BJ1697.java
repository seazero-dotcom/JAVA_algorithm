/* 숨바꼭질 
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

public class BJ1697 {
    static int N;
    static int K;
    static int[] check = new int[100001]; // 수빈과 동생의 범위 100,000

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 수빈이 현재 위치
        K = sc.nextInt(); // 동생 현재 위치

        int answer = bfs(N);
        System.out.println(answer);

    }

    static int bfs(int n) {
        Queue<Integer> que = new LinkedList<>();

        que.add(n);
        int index = n;
        check[index] = 1; // 수빈이 index n에서 0초를 1로세고 시작

        while (!que.isEmpty()) { // 큐가 빌 때 까지 반복
            int now = que.remove();

            if (n == K) {// 동생의 위치값이 0이 아니면 이미 최솟값을 찾은 것이므로 벗어난다.
                return check[n] - 1; // 0초를 1로 계산했기 때문에 1뻬줌
            }

            if ((now - 1 >= 0) && check[now - 1] == 0) {
                check[now - 1] = check[now] + 1; // 이동할 수 있는 경우 now-1
                que.add(now - 1);

            }

            if ((now + 1 <= check.length - 1) && check[now + 1] == 0) {
                check[now + 1] = check[now] + 1; // 이동할 수 있는 경우 now+1
                que.add(now + 1);

            }

            if ((now * 2 <= check.length - 1) && check[now * 2] == 0) {
                check[now * 2] = check[now] + 1; // 이동할 수 있는 경우 순간이동 x*2
                que.add(now * 2);

            }

        }
        return -1;
    }
}
