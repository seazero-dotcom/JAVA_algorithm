/*이분 그래프 
그래프의 정점의 집합을 둘로 분할하여, 
각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 
그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
*/
import java.util.*;

public class BJ1707 {
    public static boolean dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) {
                if (dfs(a, color, y, 3-c) == false) {
                    return false;
                }
            } else if (color[y] == color[x]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
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
            int[] color = new int[n+1];
            boolean ok = true;
            for (int i=1; i<=n; i++) {
                if (color[i] == 0) {
                    if (dfs(a, color, i, 1) == false) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}