package MinimumCoins;

public class Solution {
  public static int solve1(int idx, int tar, int[] nums) {
    if (idx == 0) {
      if (tar % nums[0] == 0) return tar / nums[0];
      return Integer.MAX_VALUE;
    }

    int notake = solve1(idx - 1, tar, nums);
    int take = Integer.MAX_VALUE;
    if (nums[idx] <= tar) {
      int res = solve1(idx, tar - nums[idx], nums);
      if (res != Integer.MAX_VALUE) take = 1 + res;
    }

    return Math.min(take, notake);
  }

  public static void main(String[] args) {
    int[] coins = {2, 3, 5};
    int n = coins.length;
    int tar = 7;
    int ans = solve1(n - 1, tar, coins);
    if (ans == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(ans);
  }
}
