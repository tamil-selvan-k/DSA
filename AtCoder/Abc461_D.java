import java.util.*;

public class Abc461_D {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int M = get.nextInt();
        int N = get.nextInt();
        int K = get.nextInt();
        int[][] mat = new int[M][N];
        get.nextLine();
        for(int i = 0; i < M; i++) {
            String s = get.nextLine().trim();
            for(int j = 0; j < N; j++) {
                mat[i][j] = s.charAt(j) - '0';
            }
        }


        int[][] dp = new int[M][N];
        dp[0][0] = mat[0][0];
        for(int i = 1; i < N; i++) {
            dp[0][i] = dp[0][i-1] + mat[0][i];
        }
        for(int i = 1; i < M; i++) {
            dp[i][0] = dp[i-1][0] + mat[i][0];
        }
        for(int i = 1; i < M; i++) {
            for(int j = 1; j < N; j++) {
                dp[i][j] = mat[i][j] + dp[i][j - 1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }
        
        int cnt = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k <= i; k++) {
                    for(int l = 0; l <= j; l++) {
                        int sum = dp[i][j] - dp[k][j] - dp[i][l] + dp[k][l];
                        if(sum == K) cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}