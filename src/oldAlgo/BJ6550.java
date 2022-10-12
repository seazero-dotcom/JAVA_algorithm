package src.oldAlgo;
/*부분 문자열
2개의 문자열 s와 t가 주어졌을 때 s가 t의 부분 문자열인지 판단하는 프로그램을 작성하라. 부분 문자열을 가지고 있는지 판단하는 방법은 t에서 몇 개의 문자를 제거하고 이를 순서를 바꾸지 않고 합쳤을 경우 s가 되는 경우를 이야기 한다.
*/
import java.io.*;
import java.util.*;

public class BJ6550 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String str = sc.nextLine();
            String[] arr = str.split(" ");

            if (arr[1].contains(arr[0])) {
                System.out.println("Yes");
                System.out.println(arr[0]);
                // Arrays.fill(arr, '\n');
                // break;
            } else {
                System.out.println("No");
                System.out.println(arr[0]);

                // Arrays.fill(arr, '\n');
                // break;
            }

        }
        sc.close();
    }
}
