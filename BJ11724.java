import java.util.Scanner;

/* 연결 요소의 개수
방향 없는 그래프가 주어졌을 때, 
연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
*/
import java.util.*;

public class BJ11724 {
    public static void dfs(ArrayList<Integer>[] a, boolean[] check, int x) {
        if (check[x]) {
            return;
        }
        check[x] = true;
        for (int y : a[x]) {
            if (check[y] == false) {
                dfs(a, check, y);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        
        boolean[] check = new boolean[n+1];
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if (check[i] == false) {
                dfs(a, check, i);
                ans += 1;
            }
        }
        System.out.println(ans);
                

    }
}

//bfs에서 다 처리할 수 있도록 바꾸는중
// import java.util.*;

// public class BJ11724 {
//     static ArrayList<Integer>[] input;
//     static boolean[] check; //위아래 다 쓰니까 여기에 선언

//     public static void bfs(ArrayList<Integer>[] input, boolean[] check){
//         Queue<Integer> que = new LinkedList<Integer>();
//         int ans =0;
        
//         // que.add(start);
//         check[0] = true;
        
//         while (!que.isEmpty()) {
//             int x = que.remove();
//             System.out.print(x + " ");
//             for (int y : input[x]) {
//                 if (check[y] == false) {
//                     check[y] = true;
//                     que.add(y);
//                 }
//             }
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt(); //정점의 개수
//         int M = sc.nextInt(); //간선의 개수

//         input = (ArrayList<Integer>[]) new ArrayList[N+1];

//         for (int i=1; i<=N; i++) { 
//             input[i] = new ArrayList<Integer>();
//         }


//         for (int i=0; i<M; i++) {
//             int u = sc.nextInt();
//             int v = sc.nextInt();
//             input[u].add(v);
//             input[v].add(u);
//         }

//         check = new boolean[N+1];  //불리안 생성
//         //int start = input[0].get(0);
//         bfs(input, check);

        
//     }    
// }
