
/* 파일정리
친구로부터 노트북을 중고로 산 스브러스는 노트북을 켜자마자 경악할 수밖에 없었다. 바탕화면에 온갖 파일들이 정리도 안 된 채 가득했기 때문이다. 그리고 화면의 구석에서 친구의 메시지를 확인할 수 있었다.

바탕화면의 파일들에는 값진 보물에 대한 정보가 들어 있어. 하나라도 지우게 된다면 보물은 물론이고 다시는 노트북을 쓸 수 없게 될 거야. 파일들을 잘 분석해서 보물의 주인공이 될 수 있길 바랄게. 힌트는 “확장자”야.

화가 났던 스브러스는 보물 이야기에 금세 화가 풀렸고 보물의 정보를 알아내려고 애썼다. 하지만 파일이 너무 많은 탓에 이내 포기했고 보물의 절반을 보상으로 파일의 정리를 요청해왔다. 스브러스의 요청은 다음과 같다.

파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
보기 편하게 확장자들을 사전 순으로 정렬해 줘
그럼 보물의 절반을 얻어내기 위해 얼른 스브러스의 노트북 파일 정리를 해줄 프로그램을 만들자!
*/
import java.io.*;
import java.util.TreeMap;

public class BJ20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 정렬하여 출력하기 때문에 TreeMap을 사용
        TreeMap<String, Integer> extensionTree = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String extension = str.substring(str.indexOf(".") + 1); // .을 substring의 시작위치고 잡고 .이후부터 끝까지 저장한다.

            if (extensionTree.containsKey(extension)) {
                int cnt = extensionTree.get(extension); // 기존의 cnt하고있던값 불러오기
                extensionTree.replace(extension, ++cnt); // 여기 cnt++로 썼다가 계속 답이 안나왔다 휴
            } else { // 새로운 key값이면 1로 넣어주기
                extensionTree.put(extension, 1);
            }
        }

        for (String ext : extensionTree.keySet()) {
            System.out.println(ext + " " + extensionTree.get(ext));
        }

    }

}
