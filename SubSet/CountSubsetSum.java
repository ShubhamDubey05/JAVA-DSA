package SubSet;

public class CountSubsetSum {
   public  static int count(int idx, int [] nums, int k , int [][] dp){
        if(k == 0) return 1;
        if(idx==0) return nums[idx]==k ? 1:0;
        if(dp[idx][k] != -1) return dp[idx][k];
        // noTake 
        int noTake = count(idx-1 , nums, k, dp);
        // take
        int Take = 0;
        if(nums[idx]<=k){
            Take = count(idx-1, nums, k-nums[idx], dp);
        }

        return  dp[idx][k] = Take + noTake;
    }
 
  public static void main(String[] args) {
    int nums[] = {1,2,3};
    int n = nums.length;
    int target = 3;
    int [][]dp = new int[n][target+1];
    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j <= target; j++) {
    //     dp[i][j] = -1;
    // }
// }
      for(int i =0; i<n; i++){
        dp[i][0] = 1;
      }
      if(nums[0] <= target){
        dp[0][nums[0]] =1;
      }
      for(int i=1; i<n; i++){
        for(int j = 0 ; j<=target;j++){
          int notake  = dp[i-1][j];
          int take = dp[i-1][target - j];
           dp[i][j] = take + notake;
        }
      }

    // int ans = count(nums.length -1, nums, target , dp);
    int ans = dp[n-1][target];
    System.out.println(ans);
  }
}
