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
  }
}
