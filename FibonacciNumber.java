
import java.util.*;

class SolutionFibonacci {
    public int memoization(int n , int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
    }

    public int tabulization(int n){
        if(n <= 1) return n;
        int prev1 = 1;
        int prev2 = 0;
        for(int i = 2; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

public class FibonacciNumber {
    public static void main(String[] args) {
        SolutionFibonacci s = new SolutionFibonacci();
        int n = 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = s.memoization(n, dp);
        System.out.println("Memoization result: " + ans);

        System.out.print("DP Array: ");
        for(int val : dp){
            System.out.print(val + " ");
        }

        System.out.println("\nTabulation result: " + s.tabulization(n));
    }
}
