

import java.util.*;

class Subsequences {
    // public static void printSum(int idx, int[] arr, int n, List<Integer> ans, int target, int sum) {
    //     if (idx >= n) {
    //         if (sum == target) {
    //             for (int val : ans) {
    //                 System.out.print(val + " ");
    //             }
    //             System.out.println();
    //         }
    //         return; // important to return after processing leaf node
    //     }

    //     // Take the current element
    //     ans.add(arr[idx]);
    //     sum += arr[idx];
    //     printSum(idx + 1, arr, n, ans, target, sum);
    //     ans.remove(ans.size() - 1);
    //     sum -= arr[idx]; // correct backtracking

    //     // Do not take the current element
    //     printSum(idx + 1, arr, n, ans, target, sum);
    // }
    public static int  printSum(int idx, int[] arr, int n,  int target, int sum) {
        if (idx >= n) {
            if (sum == target) {
                  return 1;
                
            }
            else{
            return 0;
            } // important to return after processing leaf node
        }

        // Take the current element
        sum += arr[idx];
       int left= printSum(idx + 1, arr, n,  target, sum);
        sum -= arr[idx]; // correct backtracking

        // Do not take the current element
        int right = printSum(idx + 1, arr, n,  target, sum);

        return left+right;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int target = 2;
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
       int res =printSum(0, arr, n,  target, 0);
       System.out.println(res);
    }
}
