package SubSequenceString;

public class MinimumInsertionToMakePalindrome {
  public static int tab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        String rev = str.reverse().toString();
        return tab(s, rev);
    }


    public static int minInsertions(String s) {
        int n = s.length();
         int res  = longestPalindromeSubseq(s);
         System.out.println("The longest palindromic string :" +res);
          return n - res;
    }
    public  static void main(String[] arg){
         int ans = minInsertions("codingninjas");
         System.out.println("final answer is : "+ans);
    }
}
