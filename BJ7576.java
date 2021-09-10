/* 토마토마
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 
토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 



창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 
대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
*/

import java.util.*;

class Tomato {
    int x;
    int y;
    Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ7576 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Tomato> q = new LinkedList<Tomato>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
                dist[i][j] = -1;
                if (a[i][j] == 1) {
                    q.add(new Tomato(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Tomato p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 0 && dist[nx][ny] == -1) {
                        q.add(new Tomato(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (ans < dist[i][j]) {
                    ans = dist[i][j];
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) {
                    ans = -1;
                }
            }
        }
        System.out.println(ans);
    }
}




// import java.util.*;

// class Tomato { // 여기서 왜 클래스를 따로 선언해주는 걸까 Tomato를 여러개 쓴다 이말이지
//     int x, y, day;

//     Tomato(int x, int y, int day) {
//         this.x = x;
//         this.y = y;
//         this.day = day;
//     }
// }

// public class BJ7576 {
//     public int solution(int n, int m, int[][] garden) {
//         int answer = 0;

//         int[] dx = { -1, 1, 0, 0 }; // 행 좌 우 하 상
//         int[] dy = { 0, 0, -1, 1 }; // 열

//         Queue<Tomato> q = new LinkedList<Tomato>(); //Tomato형 큐 선언

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (garden[i][j] == 1) { //정원에 꽃이 있다면 
//                     q.offer(new Tomato(i, j, 0)); // Tomato를 큐에 넣는다 day0이네
//                 }
//             }
//         }

//         while (!q.isEmpty()) {
//             Tomato tomato = q.peek(); //큐의 가장 앞에 있는 값을 Tomato형 x,y,day를 저장한다
//             q.poll(); //맨처음으로 들어간 데이터를 제거한다

//             for (int i = 0; i < 4; i++) { //씨앗이 사방으로 퍼지니까 4
//                 int nextX = tomato.x + dx[i]; // peek한 tomato x + -1
//                 int nextY = tomato.y + dy[i]; // peek한 tomato y + 0
//                 int nextDay = tomato.day + 1; // peek한 tomato day + 1 씨앗 뿌려졌으니까 1일증가

//                 if ((0 <= nextX && nextX < n && 0 <= nextY && nextY < m) && garden[nextX][nextY] == 0) {
//                     //이동한 좌표가 범위 안에 있고 정원에 꽃이 없다면
//                     garden[nextX][nextY] = 1; //꽃을 심어주고
//                     answer = nextDay; //날짜 증가한거를 답에 저장
//                     q.offer(new Tomato(nextX, nextY, nextDay)); //좌표바뀐거랑 날짜를 큐에 저장
//                 }
//             }
//         }

//         return answer;
//     }

//     public static void main(String[] args) {
//         BJ7576 sol = new BJ7576();

//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int M = sc.nextInt();
//         int[][] garden = new int[N][M];

//         for(int i=0;i<N;i++){
//             for(int j=0;j<M;j++){
//                 garden[i][j] = sc.nextInt();
//             }
//         }
        
//         int ret = sol.solution(N, M, garden);

//         System.out.println( ret );
//     }
// }
