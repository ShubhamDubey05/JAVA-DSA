import java.util.*;

public class SubsetSum {
 public static void subSet(int idx, int [] arr, List<Integer> ans, int s ){
   if(idx>= arr.length){
    ans.add(s);
    return;
   }
   // no pick
   subSet(idx+1, arr, ans, s);
   // pick 
   s+= arr[idx];
   subSet(idx+1, arr, ans, s);

 }
  public static void main(String[] args) {
    int [] arr = { 3, 1, 2};
     List<Integer> ans = new ArrayList<>();

    subSet(0, arr, ans, 0);
    for(int val : ans){
      System.out.print(val+" ");
    }
  }
}
