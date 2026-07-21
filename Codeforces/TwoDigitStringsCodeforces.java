import java.util.*;
public class TwoDigitStringsCodeforces {
	// Codeforces Two Digit Strings
    private static void exec(Scanner get) {
        String str1 = get.nextLine().trim();
        String str2 = get.nextLine().trim();

        int m = str1.length();
        int n = str2.length();

        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        int sum1 = str1.charAt(0) - '0', sum2 = str2.charAt(0) - '0';
        arr1[0] = sum1;
        arr2[0] = sum2;

        for(int i=1;i<m;i++) {
            arr1[i] = (arr1[i-1] + (str1.charAt(i) - '0')) % 10;
            sum1 += str1.charAt(i) - '0';
        }

        for(int i=1;i<n;i++) {
            arr2[i] = (arr2[i-1] + (str2.charAt(i) - '0')) % 10;
            sum2 += str2.charAt(i) - '0';
        }

        if(arr1[m-1] != arr2[n-1]) {
            System.out.println(-1);
            return;
        }

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[m][n]);
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int t = get.nextInt();
        get.nextLine();
        while(t-- > 0) {
            exec(get);
        }
    }
}
