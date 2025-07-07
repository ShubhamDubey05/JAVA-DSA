package Bitonic;
import java.util.Arrays;
public class biatonic {
  public static int LongestBitonicSequence(int n, int[] nums) {
        int[] dp = new int[n]; // LIS from left
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int[] t = new int[n]; // LDS from right
        Arrays.fill(t, 1);

        int maxi = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && t[i] < t[j] + 1) {
                    t[i] = t[j] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i] + t[i] - 1); // Bitonic length at i
        }

        return maxi;
    }
   public static void main(String[] args) {
        int[] arr = {5, 7, 9};
        int n = arr.length;
        int ans = LongestBitonicSequence(n, arr);
        System.out.println(ans);  // Output: 3
    }
  }