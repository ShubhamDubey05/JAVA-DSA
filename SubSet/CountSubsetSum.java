package SubSet;

public class CountSubsetSum {
   public  static int count(int idx, int [] nums, int k){
        if(k == 0) return 1;
        if(idx==0) return nums[idx]==k ? 1:0;
        // noTake 
        int noTake = count(idx-1 , nums, k);
        // take
        int Take = 0;
        if(nums[idx]<=k){
            Take = count(idx-1, nums, k-nums[idx]);
        }

        return Take + noTake;
    }
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        return count(n-1, nums, k);
    }
  public static void main(String[] args) {
    int nums[] = {1,2,3};
    int target = 3;
    int ans = count(nums.length -1, nums, target);
    System.out.println(ans);
  }
}
