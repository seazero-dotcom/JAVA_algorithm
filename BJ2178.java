
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

import java.util.*;

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ2178 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        sc.nextLine();
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][] dist = new int[n][m];
        boolean[][] check = new boolean[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));  // offer, poll을 add, remove로 바꾸니까 런타임에러가 해결됐다
        check[0][0] = true;
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (check[nx][ny] == false && a[nx][ny] == 1) {
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}




// import java.util.*;

// class Pair {
//     int x, y;

//     Pair(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }

// public class BJ2178 {
//     public static final int[] dx = { 0, 0, 1, -1 };
//     public static final int[] dy = { -1, 1, 0, 0 };

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int M = sc.nextInt();
//         int[][] board = new int[N][M]; // 행열받고 숫자 넣을 판 만들기
//         sc.nextLine();

//         for (int i = 0; i < N; i++) { // 행만큼 줄받고
//             String s = sc.nextLine(); // 한줄에 띄어쓰기 없이 스트링으로 받고
//             for (int j = 0; j < M; j++) { // 열만큼 뜯어주고
//                 board[i][j] = s.charAt(i) - '0'; // 한 글자 뜯고 -'0'로 int로형변환
//             }
//         }

//         int[][] dist = new int[N][M]; // 거리 를 계산할 배열 만들기
//         boolean[][] check = new boolean[N][M]; // 방문여부를 기록할 체크
//         Queue<Pair> q = new LinkedList<Pair>(); // 방문하기 위해 넣었다 뺐다 할 큐 생성
//         q.offer(new Pair(0, 0)); // 시작점인 0,0 넣기
//         check[0][0] = true;// 넣음과 동시에 방문처리
//         dist[0][0] = 1;// 동시에 거리도 1추가

//         while (!q.isEmpty()) { // 모두 방문하여 큐가 빌 때까지 반복문
//             Pair p = q.poll(); // 맨 앞에있는것 제거, 방문했으니까 ~
//             // 위에서 q.offer(new Pair(0,0)); 이렇게해서 Pair클래스에 저장된거야?
//             // 그래서 poll할때도 저렇게 해야되는거야?
//             int x = p.x; // poll한 x를 저장>? ㅇㅇ 맞는득
//             int y = p.y; // poll한 y를 저장?

//             for (int k = 0; k < 4; k++) {
//                 int nx = x + dx[k]; // 제거한 자리에서 상(저장) 하 우 좌
//                 int ny = y + dy[k]; // 제거한 자리에서 상(저장) 하 우 좌

//                 if (0 <= nx && nx < N && 0 <= ny && ny < M) { // 범위 안에 있는 좌표인지 확인
//                     if (check[nx][ny] == false && board[nx][ny] == 1) { // 방문안했고 1있는거
//                         q.offer(new Pair(nx, ny)); // 이동한 좌표 넣고
//                         dist[nx][ny] = dist[x][y] + 1; // 기존누적거리 + 1 늘리고
//                         check[nx][ny] = true; // 방문했다 표시하고
//                     }
//                 }
//             }
//         }
//         System.out.println(dist[N - 1][M - 1]); // 거리배열의 마지막 값을 출력
//     }
// }
