import java.util.*;

class SolutionClimbStairs{
  public int solve( int n ){
     if(n <0) return 0;
     if(n==0) return 1;
     return solve(n-1)+ solve(n-2);
  }
  public int memoization(int n, int[] dp){
    if(n <0) return 0;
    if(n == 0) return 1;
    if(dp[n]!=-1) return dp[n];
    return dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
  }
  public int tabulization1(int n ){
   if( n <=2) return n;
         int prev = 2;
         int prev1 = 1;
        for(int i = 3; i<=n ; i++){
             int step = prev + prev1;
             prev1 = prev;
             prev  = step;
         }
          return prev;
  }
  public int tabulization2(int n){
     if(n <= 2) return n;
    int[] tab = new int[n+1];
    tab[1] = 1;
    tab[2] = 2;

    for(int i = 3; i <= n; i++){
        tab[i] = tab[i-1] + tab[i-2];
    }
    return tab[n];
  }
}



public class ClimbStairs {
  public static void main(String[] args) {
    SolutionClimbStairs sc = new SolutionClimbStairs();
      int n =3;
     int ans =  sc.solve( n);
     System.out.println(ans);
     // memoization
     int [] dp  = new int [n+1];
     Arrays.fill(dp, -1);
     int res = sc.memoization(n , dp);
     System.out.println(res);
     System.out.println(sc.tabulization2(n));
  }
}
