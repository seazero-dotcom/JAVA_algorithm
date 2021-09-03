
import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] alpha = new int[26];
        int answer =0;
        Scanner sc = new Scanner(System.in);

        //while(sc.hasNext()){
            String ss = sc.next();

            for(int i=0; i<ss.length();i++){
                char ch = ss.charAt(i);
                alpha[ch -'A']++;
            }

            for(int j =0; j<26; j++){
                if(alpha[j]%2==0){
                    answer += 0;
                    continue;
                }else{
                    answer++;
                }
            }
       // }
        System.out.println(answer);
    }

}
