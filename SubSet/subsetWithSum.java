package SubSet;

public class subsetWithSum {

  public static boolean solve(int idx, int [] arr, int tar){
    if(tar == 0) return true;
    if(idx== 0) return (arr[0] == tar);
    boolean noTake = solve(idx-1, arr, tar);
    boolean take  = false;
    if(arr[idx] <= tar){
      take = solve(idx-1, arr, tar - arr[idx]);
    }
    return take || noTake;
   }
  public static void main(String[] args) {
    int []arr = {3, 34, 4, 12, 5, 2};
    int tar = 9;
    int n = arr.length;
    boolean ans = solve(n-1, arr, tar);
    System.out.println(ans);
  }
}
