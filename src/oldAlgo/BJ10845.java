package src.oldAlgo;/*큐
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 
        만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 
        만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 
        만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

import java.io.*;

public class BJ10845 {
    public static void main(String args[]) throws IOException {
        //Scanner sc = new Scanner(System.in); 
        //int N = sc.nextInt();

        //Scanner쓰니까 시간초과 남. Buffer써주고 예외 던지니까 해결됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] que = new int[N];
        int peek = 0;
        int end = 0;
        String input = "";

        while (N-- > 0) {
            String[] str = br.readLine().split(" "); //원하는 명령어 입력
            input = str[0];

            //Space를 경계로 끊어야 할 때
            //String arr[] = input.split(" ");
            //또는 StringTokenizer 클래스 이용)
            
            //머야 StringToknizer는 공백을 포함하는 경우의 Int형이네 String은 안됨 그래서 오류남
            //String input = st.nextToken();
            
            if (input.equals("push")) {
                //int num = Integer.parseInt(sc.next());
                int num = Integer.parseInt(str[1]); //여기서 입력받았더니 NumberFormat 에러남
                que[end] = num;
                end++;

            } else if (input.equals("front")) {

                if (peek == end) {
                    bw.write("-1\n");
                    //bw.write("\n");
                } else {
                    bw.write(String.valueOf(que[peek]));
                    bw.write("\n");
                }

            } else if (input.equals("size")) {
                bw.write(String.valueOf(end-peek));
                bw.write("\n");
            } else if (input.equals("empty")) {

                if (peek == end) {
                    bw.write("1\n");
                    //bw.write("\n");
                } else {
                    bw.write("0\n");
                    //bw.write("\n");
                }

            } else if (input.equals("pop")) {

                if (peek == end) {
                    bw.write("-1\n");
                    //bw.write("\n");
                } else {
                    //정수형을 BufferedWriter에 넣고 싶으면, String형으로의 변환이 필요합니다.
                    // bw.write(String.valueOf(배열[i]));
                    bw.write(String.valueOf(que[peek]));
                    bw.write("\n");
                    peek += 1;
                }

            } else if (input.equals("back")) {

                if (peek == end) {
                    bw.write("-1\n");
                    //bw.write("\n");
                } else {
                    bw.write(String.valueOf(que[end-1]));
                    bw.write("\n");
                }

            }
            bw.flush();
        }
    }
}