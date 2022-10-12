package src.oldAlgo;
/* 톱니바퀴 */
import java.io.*;
import java.util.*;

public class BJ14891 {
    static ArrayList<ArrayList<String>> Gear; // 톱니 4개 받기
    static int K; // 회전 수
    static int[] gearNum; // 회전시킨 톱니번호
    static int[] rotationDirection; // 회전시킨 방향 1은 clockwise -1은 antiClockwise
    static double sum;
    static String temp;
    static String str;
    static String tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Gear = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < 4; i++) {
            Gear.add(new ArrayList<>());
            str = br.readLine();
            for (int j = 0; j < 8; j++) {
                Gear.get(i).add(j, String.valueOf(str.charAt(j)));

            }
        }

        K = Integer.parseInt(br.readLine());
        gearNum = new int[K];
        rotationDirection = new int[4];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gearNum[i] = Integer.parseInt(st.nextToken()); // Gear에 0부터 저장되기 때문에 나중에 사용할 때 -1 해줘야함
            rotationDirection[gearNum[i] - 1] = Integer.parseInt(st.nextToken());
            Direction(gearNum[i]);
            rotationDirection = new int[4];
        }

        Jumsu();
        bw.write(String.valueOf((int) sum));

        bw.flush();
        bw.close();
        br.close();

    }

    public static void Direction(int num) {
        // 무슨 톱니가 어느 방향으로 돌아갈지 저장하기

        for (int j = num; j < 4; j++) { // 우톱니
            if (!Gear.get(j - 1).get(2).equals(Gear.get(j).get(6))) {
                rotationDirection[j] = -rotationDirection[j - 1];
            } else {
                break;
            }
        }

        for (int j = num - 1; j > 0; j--) { // 좌톱니
            if (!Gear.get(j - 1).get(2).equals(Gear.get(j).get(6))) {
                rotationDirection[j - 1] = -rotationDirection[j];
            } else {
                break;
            }
        }

        // 이동하기
        for (int i = 0; i < 4; i++) {
            if (rotationDirection[i] == 1) {
                temp = Gear.get(i).get(7);
                // Gear.get(i).remove(7);

                for (int j = 7; j >= 1; j--) {
                    tmp = Gear.get(i).get(j - 1);
                    Gear.get(i).add(j, tmp);
                    Gear.get(i).remove(j - 1);
                    // 0 1 2 3 4 5 6 7
                }
                Gear.get(i).add(0, temp);
            } else if (rotationDirection[i] == -1) {
                temp = Gear.get(i).get(0);
                // Gear.get(i).remove(0);
                for (int j = 0; j < 7; j++) {
                    tmp = Gear.get(i).get(j + 1);
                    Gear.get(i).add(j, tmp);
                    Gear.get(i).remove(j + 1);
                    // 0 1 2 3 4 5 6 7
                }
                Gear.get(i).add(7, temp);
            } else {
                continue;
            }
        }

    }

    public static void Jumsu() {

        for (int i = 0; i < 4; i++) {
            if (Gear.get(i).get(0).equals("1")) {
                sum = sum + Math.pow(2, i);
            }
        }

    }
}
