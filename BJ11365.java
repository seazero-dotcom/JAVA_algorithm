/* !밀비 급일
당신은 길을 가다가 이상한 쪽지를 발견했다. 
그 쪽지에는 암호가 적혀 있었는데, 똑똑한 당신은 암호가 뒤집으면 해독된다는 것을 발견했다.

이 암호를 해독하는 프로그램을 작성하시오.
*/
import java.util.*;

public class BJ11365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cryptogram = "";

        for(int i=0;;i++){
            cryptogram = sc.nextLine();
            if(cryptogram.equals("END") ){
                break;
            }else{
                StringBuffer sb = new StringBuffer(cryptogram);
                System.out.println(sb.reverse().toString());
                 
            }
        }

        
    }
}
