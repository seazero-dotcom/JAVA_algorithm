/*DFS와 BFS
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
정점 번호는 1번부터 N번까지이다.
*/

import java.util.*;

public class BJ1260 {
    static ArrayList<Integer>[] a; //2차원 배열도 아니고 굳이 이렇게[] 해야하나 
    static boolean[] c;

    public static void dfs(int x) {
        if (c[x]) {
            return;
        }
        c[x] = true;
        System.out.print(x + " ");
        for (int y : a[x]) {
            if (c[y] == false) {
                dfs(y);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;

        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (c[y] == false) {
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        a = (ArrayList<Integer>[]) new ArrayList[n+1]; //배열이여서 이렇게 쓰는건가 형변환느낌? 근데 지금은 변환할 필요없잖아

        for (int i=1; i<=n; i++) { //값 입력
            a[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(a[i]);
            //Array.Sort는 배열을 정렬해주는 것이고 Collections.sort는 클래스의 객체를 정렬해주는 것
        }

        c = new boolean[n+1];
        dfs(start);
        System.out.println();
        
        c = new boolean[n+1];
        bfs(start);
        System.out.println();
    }
}


/*
전에 풀었던 방법
import java.util.*;

public class Main {
  
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            int n = sc.nextInt(); // 정점의 개수 
            int m = sc.nextInt(); // 간선의 개수 
            int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 
    
            boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 
    
            int[][] injubArray = new int[n+1][n+1];
    
            // 두 정점 사이에 여러 개의 간선이 있을 수 있다.
            // 입력으로 주어지는 간선은 양방향이다.
            for(int i = 0; i < m; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
    
                injubArray[v1][v2] = 1;
                injubArray[v2][v1] = 1;
            }

            //System.out.println("\n\nDFS - 인접행렬 / 스택으로 구현");
            dfs_array_stack(v, injubArray, visited, true);
            Arrays.fill(visited, false); // 스택 DFS를 위해 visited 배열 초기화
            System.out.println();
            //System.out.println("BFS - 인접행렬");
            bfs_array(v, injubArray, visited);
        }
        
        // BFS - 인접행렬
        public static void bfs_array(int v, int[][] injubArray, boolean[] visited) {
            Queue<Integer> que = new LinkedList<>();
            int n = injubArray.length - 1;
    
            que.add(v);
            visited[v] = true;
    
            while (!que.isEmpty()) {
                v = que.poll();
                System.out.print(v + " ");
    
                for (int i = 1; i <= n; i++) {
                    if (injubArray[v][i] == 1 && !visited[i]) {
                        que.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    //DFS - 인접행렬 / 스택으로 구현 
    public static void dfs_array_stack(int v, int[][] injubArray, boolean[] visited, boolean flag) {
        int l = injubArray.length-1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);
        visited[v] = true;
        System.out.print(v + " ");

        while(!stack.isEmpty()) {
            int w = stack.peek();
            flag = false; 

            for(int i = 1; i <= l; i++) {
                if(injubArray[w][i] == 1 && !visited[i]) {
                    stack.push(i);
                    System.out.print(i + " ");
                    visited[i] = true;
                    flag = true;

                    break;
                }
            }

            if(!flag) {
                stack.pop();
            }
        }
    }
}

*/