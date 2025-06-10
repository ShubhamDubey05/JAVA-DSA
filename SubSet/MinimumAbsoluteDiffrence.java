package SubSet;

public class MinimumAbsoluteDiffrence {
  public  static int diffrence(int [] nums){
   int n  = nums.length;
        int sum  =  0;
        for(int val  : nums){
            sum+=val;
        }
        boolean  [][] dp = new boolean [n][sum+1];
        for(int i =0; i<n; i++){
            dp[i][0] = true;
        }
        if(nums[0]<=sum){
            dp[0][nums[0]] = true;
        }
        for(int i =1; i<n ; i++){
            for(int j =1; j<=sum+1; j++){
                // noTake
                boolean noTake = dp[i-1][j];
                // Take
                boolean Take = dp[i-1][j - nums[i]];

                dp[i][j] = noTake || Take;
            }
        }
         int mini = Integer.MAX_VALUE;
         for(int i = 0; i<=sum/2; i++){
            if(dp[n-1][i]){  
            int s2 = sum - i;
            mini = Math.min(Math.abs(i-s2), mini);
            }
         }
        return mini;

    }
  
  public static void main(String[] args) {
      int[] nums = {3, 9, 7, 3};
      int ans = diffrence(nums);
      System.out.println(ans);
  }
}
