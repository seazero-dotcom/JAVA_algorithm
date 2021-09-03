/* 사탕 게임
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 
상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 
그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 
이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
*/

import java.util.*;

public class BJ3085 {

    static int check(char[][] a, int start_hang, int end_hang, int start_col, int end_col){
       // 3 0 0 0 1
        int n = a.length; //board의 크기 받기 3
        int ans = 1; // 자기부터 최대개수 카운트 1이니까 최소 1

        for(int i = start_hang; i <= end_hang; i++){ // 행 0 0
            
            int cnt = 1; // 자기 자신부터 최대개수 1 카운트 시작
            
            for(int j = 1; j<n; j++){ // 열이 변한다 3

                if(a[i][j] == a[i][j-1]){ // 현재위치와 오른쪽에있는 것이 같으면 0,1=0,0/0,2=0,1
                    cnt += 1; // 최대개수 +1  2
                } else {
                    cnt = 1; // 같은것이 아니면 다시 1로 리셋
                }

                if(ans < cnt){ //1보다 최대개수가 크다면 1<2 
                    ans = cnt; //ans로 저장해준다  2
                }
            }
        }

        for(int i = start_col; i <= end_col; i++){ //열 0 1
            int cnt =1;

            for(int j=1; j<n; j++){ //행이 변한다 3

                if(a[j][i] == a[j-1][i]){ // 현재위치와 위쪽에 있는 것이 같으면 1,0=0,0/2,0=1,0/1,1=0,1/2,1=1,1
                    cnt += 1; //2
                } else {
                    cnt = 1;
                }
                
                if(ans<cnt){ //1<2
                    ans = cnt; //2
                }
            }
        }
        return ans; //2
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] board = new char[N][N];

        for(int i = 0; i<N;i++){ // 보드에 입력받고
            board[i] = sc.next().toCharArray(); //1행에 CCP입력하면 한 개씩 쪼개져서 배열에 들어가는 듯
        }
        
        int answer = 0; // 상근이가 먹을 수 있는 사탕의 최대 개수를 찾자

        for(int i =0; i<N;i++){ // 행 0
            for(int j=0;j<N;j++){ // 열 0
                
                if(j+1 < N){ // 현재위치에서 왼쪽의 열이 NxN 안에 있다면 1 < 3
                    // 현재 위치랑 왼쪽에 있는거랑 자리 바꾸기 ~
                    char t = board[i][j]; 
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = t;

                    int temp = check(board, i, i, j, j+1); //2 최대 얼마나 연결되어있는지 확인하기
                                        //  행  행 열 옆에열
                    if(answer < temp){ //0<2
                        answer = temp;  //2
                    }

                    //다시 원위치로 ~
                    t = board[i][j];
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = t;
                }

                if(i+1 < N){
                    char t = board[i][j];
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = t;

                    int temp = check(board, i, i+1, j, j);

                    if(answer < temp){
                        answer = temp;
                    }

                    t = board[i][j];
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = t;
                }
            }
        }
        System.out.println(answer);
        


    }
}
