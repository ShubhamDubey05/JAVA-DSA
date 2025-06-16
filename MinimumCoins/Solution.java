package MinimumCoins;
import java.util.*;

public class Solution {
  public static int solve1(int idx, int tar, int[] nums, int[][] dp) {
    if (idx == 0) {
      if (tar % nums[0] == 0) return tar / nums[0];
      return Integer.MAX_VALUE;
    }
    if (dp[idx][tar]!= -1) return dp[idx][tar];
    int notake = solve1(idx - 1, tar, nums, dp);
    int take = Integer.MAX_VALUE;
    if (nums[idx] <= tar) {
      int res = solve1(idx, tar - nums[idx], nums, dp);
      if (res != Integer.MAX_VALUE) take = 1 + res;
    }

    return dp[idx][tar] = Math.min(take, notake);
  }
 public static int solve2(int[] nums, int tar) {
    int n = nums.length;
    int[][] dp = new int[n][tar + 1];

    
    for (int i = 0; i < n; i++) dp[i][0] = 0;

  
    for (int j = 1; j <= tar; j++) {
        if (j % nums[0] == 0)
            dp[0][j] = j / nums[0];
        else
            dp[0][j] = (int) 1e9; 
    }

    for (int i = 1; i < n; i++) {
        for (int j = 1; j <= tar; j++) {
            int notTake = dp[i - 1][j];
            int take = (j >= nums[i]) ? 1 + dp[i][j - nums[i]] : (int) 1e9;
            dp[i][j] = Math.min(take, notTake);
        }
    }

    return dp[n - 1][tar] >= (int) 1e9 ? -1 : dp[n - 1][tar];
}


  public static void main(String[] args) {
    int[] coins = {2, 3, 5};
    int n = coins.length;
    int tar = 7;
    int [][] dp = new int [n][tar+1];
    for(int i =0; i<coins.length; i++){
           for(int [] row : dp){
            Arrays.fill(row, -1);
           }
    }
    int ans = solve1(n - 1, tar, coins, dp);
    if (ans == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(ans);
    System.out.println(solve2(coins, tar));
  }
}
