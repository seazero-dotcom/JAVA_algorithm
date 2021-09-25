
/*듣보잡
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
*/
import java.io.*;
import java.util.*;

public class BJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 교집합
        HashSet<String> duddo = new HashSet<>();
        HashSet<String> bodo = new HashSet<>();

        String[] NM = br.readLine().split(" ");

        for (int i = 0; i < Integer.parseInt(NM[0]); i++) {
            duddo.add(br.readLine());
        }
        for (int i = 0; i < Integer.parseInt(NM[1]); i++) {
            bodo.add(br.readLine());
        }
        duddo.retainAll(bodo);
        System.out.println(duddo.size());

        TreeSet<String> sortTree = new TreeSet<>(); // HashSet을 정렬하기 위해서 사용
        sortTree.addAll(duddo);

        for (String str : sortTree) {
            System.out.println(str);
        }

    }
}
