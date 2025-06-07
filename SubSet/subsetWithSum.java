package SubSet;

public class subsetWithSum {

    // Memoization (Top-Down)
    public static boolean solve(int idx, int[] arr, int tar, Boolean[][] dp) {
        if (tar == 0) return true;
        if (idx == 0) return (arr[0] == tar);

        if (dp[idx][tar] != null) return dp[idx][tar];

        boolean noTake = solve(idx - 1, arr, tar, dp);
        boolean take = false;
        if (arr[idx] <= tar) {
            take = solve(idx - 1, arr, tar - arr[idx], dp);
        }

        return dp[idx][tar] = take || noTake;
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int tar = 9;
        int n = arr.length;

        //memoization
        Boolean[][] memo = new Boolean[n][tar + 1];
        boolean ansMemo = solve(n - 1, arr, tar, memo);
        System.out.println("Memoization Answer: " + ansMemo);

        //  Tabulation (Bottom-Up)
        boolean[][] dp = new boolean[n][tar + 1];

        // Base case: sum 0 is possible with any i (take nothing)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case: if first element ≤ target, set it
        if (arr[0] <= tar) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= tar; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (arr[i] <= j) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }

        System.out.println("Tabulation Answer: " + dp[n - 1][tar]);
    }
}
