package SubSet;

public class subsetWithSum {

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
    int []arr = {3, 34, 4, 12, 5, 2};
    int tar = 9;
    int n = arr.length;
  // Memoization 

  Boolean [][] dp = new Boolean [n][tar+1];
    boolean ans = solve(n-1, arr, tar , dp);
    System.out.println(ans);
  }
}
