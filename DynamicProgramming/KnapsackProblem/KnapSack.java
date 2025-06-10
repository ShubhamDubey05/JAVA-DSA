package DynamicProgramming.KnapsackProblem;

public class KnapSack {
   public static int solve(int idx, int w, int[] val, int[] wt) {
        if (idx == 0) {
            if (wt[0] <= w) return val[0];
            else return 0;
        }

        // Not take case
        int notTake = solve(idx - 1, w, val, wt);

        // Take case
        int take = Integer.MIN_VALUE;
        if (wt[idx] <= w) {
            take = val[idx] + solve(idx - 1, w - wt[idx], val, wt);
        }

        return  Math.max(take, notTake);
    }
  public static void main(String[] args) {
    int [] val = {10, 40, 30, 50};
    int [] wt =  {5, 4, 2, 3};
    int w = 5;
    int n = val.length;
    System.out.println(solve(n-1, w, val, wt));

  }
}
