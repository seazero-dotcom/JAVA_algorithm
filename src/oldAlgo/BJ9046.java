package src.oldAlgo;/* 복호화
암호학에서 치환 암호(substitution cipher)란, 평문에 들어있는 각각의 문자를 주어진 치환 방법으로 암호화하는 방법 중 하나다.

가장 단순한 방법은 평문의 알파벳을 암호문의 알파벳으로 대치시켜 치환시키는 것이다.

예를 들어, 아래와 같은 알파벳 대치표가 주어졌다고 하자.

평문 알파벳 대치표 : abcdefghijklmnopqrstuvwxyz
암호문 알파벳 대치표 : wghuvijxpqrstacdebfklmnoyz
위에 주어진 치환 방법을 통해 암호화하면 평문 "hello there"은 "xvssc kxvbv"가 된다.

한 가지 흥미로운 점은 영어 문법 특성상, 알파벳 'e'가 다른 영문 알파벳에 비해 자주 쓰인다는 것이다.

즉, 암호문 알파벳 대치표 없이 암호문을 복호화하려 할 때, 
암호문 알파벳 빈도수를 체크하면 암호문 알파벳 빈도수 중 가장 빈번하게 나타나는 알파벳이 'e'라는 사실을 유추해볼 수 있다.

위 방법으로 암호문 알파벳의 빈도수를 체크하고, 가장 빈번하게 나타나는 문자를 출력하는 프로그램을 작성하면 된다.

만약 주어진 암호문에서 가장 빈번하게 나타나는 문자가 여러 개일 경우, 
그 빈번한 문자 중 어느 것이 평문 알파벳 'e'를 가리키는지 확실하게 알 수 없기 때문에 "모르겠음"을 의미하는 '?'를 출력하면 된다.
*/

import java.util.*;

public class BJ9046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cryptogram = "";
        int[] count = new int[26];
        // List<Integer> count = new ArrayList<>();

        int TC = sc.nextInt();
        sc.nextLine(); // 앤터를 인식하고 와일문 안에있는 sc를 무시해서 적용함

        // 배열을 복제하고 복제한 배열을 오름차순 정렬해서 제일 큰 수를 찾고
        // 원본 배열과 비교하여 제일 큰 수와 같은 값을 가진 배열이 2 이상이면 ?
        // 같은 배열이 한 개이면 그 배열의 인덱스를 영문으로 출력.
        while (TC-- > 0) {
            int MAX = 0;
            int maxIndex = 0;
            int cnt = 0;
            cryptogram = sc.nextLine().replace(" ", "");

            for (int i = 0; i < cryptogram.length(); i++) {
                char ch = cryptogram.charAt(i);
                count[ch - 'a']++;// a는 97
            }

            int[] countCopy = Arrays.copyOf(count, count.length);

            Arrays.sort(countCopy);

            MAX = countCopy[countCopy.length - 1];

            for (int k = 0; k < count.length; k++) {
                if (count[k] == MAX) {
                    maxIndex = k;
                    cnt++;
                }
            }

            if (cnt >= 2) {
                System.out.println("?");
            } else {
                System.out.println((char) (97 + maxIndex));
            }

            Arrays.fill(count, 0);
            Arrays.fill(countCopy, 0);
        }
    }
}
