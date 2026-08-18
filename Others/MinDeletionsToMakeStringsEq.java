import java.util.*;


public class MinDeletionsToMakeStringsEq {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);

        String s1 = get.nextLine().trim();
        String s2 = get.nextLine().trim();
        int M = s1.length();
        int N = s2.length();

        int[][] dp = new int[M + 1][N + 1];
        int maxLen = 0;

        for (int row = 1; row <= M; row++) {
            char r = s1.charAt(row - 1);
            for (int col = 1; col <= N; col++) {
                char c = s2.charAt(col - 1);
                if (r == c) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                    maxLen = Math.max(maxLen, dp[row][col]);
                }
            }
        }

        System.out.println((M + N) - maxLen * 2); // Min number of deletions to make the two strings equal
    }
}   
