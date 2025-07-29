package Stack.NextGreaterElement;

import java.util.Stack;

public class Solution1 {

public static void greater(int[] arr, int[] ans) {
    int n = arr.length;
    Stack<Integer> st = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
        // Pop elements from stack smaller than or equal to current element
        while (!st.isEmpty() && st.peek() <= arr[i]) {
            st.pop();
        }

        // If stack is empty, no greater element on the right
        if (st.isEmpty()) {
            ans[i] = -1;
        } else {
            ans[i] = st.peek();
        }

        // Push current element onto stack
        st.push(arr[i]);
    }
}


  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 1, 8, 6, 3, 4 };
    int n = arr.length;
    int[] res = new int[n];


      greater(arr, res);


      for(int val  : res){
        System.out.print(val+" ");
      }
    // for (int i = 0; i < n; i++) {
    //   for (int j = i; j < n; j++) {
    //     if (arr[i] < arr[j]) {
    //       res[i] = arr[j];
    //       break;
    //     }
    //   }
    // }
    // for (int val : res) {
    //   System.out.print(val + " ");
    // }
  }

}







