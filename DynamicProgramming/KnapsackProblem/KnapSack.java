package DynamicProgramming.KnapsackProblem;

public class KnapSack {
     public static int solve2(int [] val , int [] wt, int cap){
          int n  = val.length;
          

          int [][] dp = new int [n+1][cap+1];
          for(int i =  1; i<dp.length; i++){
            for(int j =1; j<dp[0].length; j++){
                // yadi batting nhi krta hai 
                dp[i][j] = dp[i-1][j];

                // yadi batting krta hai
                if( j>=wt[i-1]){
                    int rem  =  j - wt[i-1];
                    if(dp[i-1][rem] + val[ i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][rem] + val[ i-1];
                    }
                    else{
                       dp[i][j] = dp[i-1][j]; 
                    }
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
          }


        return dp[n][cap];
     }


   public static int solve(int idx, int w, int[] val, int[] wt, int[][] dp) {
        if (idx == 0) {
            if (wt[0] <= w) return val[0];
            else return 0;
        }

        if (dp[idx][w] != -1) return dp[idx][w];

        // Not take case
        int notTake = solve(idx - 1, w, val, wt, dp);

        // Take case
        int take = Integer.MIN_VALUE;
        if (wt[idx] <= w) {
            take = val[idx] + solve(idx - 1, w - wt[idx], val, wt, dp);
        }

        return dp[idx][w] = Math.max(take, notTake);
    }
   public static int solve1(int idx, int w, int[] val, int[] wt) {
        if (idx == 0) {
            if (wt[0] <= w) return val[0];
            else return 0;
        }

        // Not take case
        int notTake = solve1(idx - 1, w, val, wt);

        // Take case
        int take = Integer.MIN_VALUE;
        if (wt[idx] <= w) {
            take = val[idx] + solve1(idx - 1, w - wt[idx], val, wt);
        }

        return  Math.max(take, notTake);
    }
  public static void main(String[] args) {
    int [] val = {10, 40, 30, 50};
    int [] wt =  {5, 4, 2, 3};
    int w = 5;
    int n = val.length;
    int[][] dp = new int[n][w+ 1];

        // Initialize DP array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }
    System.out.println(solve1(n-1, w, val, wt));
    System.out.println(solve(n-1, w, val, wt, dp));
    System.out.println(solve2(val, wt, w));

  }
}
