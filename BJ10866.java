/*덱
정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 
            만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 
            약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 
        만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 
        만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

import java.util.*;
import java.io.*;

public class BJ10866 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> que = new ArrayDeque<Integer>();

        for (int k=0; k<N; k++) {
            String[] str = br.readLine().split(" ");
            String input = str[0];

            if (input.equals("push_front")) {
                int num = Integer.parseInt(str[1]);
                que.offerFirst(num);  //앞

            } else if (input.equals("push_back")) {
                int num = Integer.parseInt(str[1]);
                que.offerLast(num);  //뒤

            }  else if (input.equals("front")) {

                if (que.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(que.peekFirst())); //앞
                }
                bw.write("\n");

            } else if (input.equals("size")) {
                bw.write(String.valueOf(que.size()));
                bw.write("\n");

            } else if (input.equals("empty")) {

                if (que.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
                //bw.write("\n");

            } else if (input.equals("pop_front")) {

                if (que.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(que.pollFirst())); //앞
                }
                bw.write("\n");

            } else if (input.equals("pop_back")) {

                if (que.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(que.pollLast())); //뒤
                }
                bw.write("\n");

            } else if (input.equals("back")) {

                if (que.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(que.peekLast())); //뒤
                }
                bw.write("\n");

            }
        }
        bw.flush();
    }
}