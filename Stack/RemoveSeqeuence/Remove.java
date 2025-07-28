package Stack.RemoveSeqeuence;

import java.util.*;

public class Remove {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 7, 7, 10, 10, 10};
        int[] ans = remove(arr);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

    public static int[] remove(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int i = 0;

        while (i < n) {
            int count = 1;
            // Count how many times arr[i] is repeated consecutively
            while (i + 1 < n && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }

            // If count == 1, it's a unique value
            if (count == 1) {
                st.push(arr[i]);
            }

            i++;
        }

        // Reverse the stack into correct order
        int size = st.size();
        int[] res = new int[size];
        for (int j = size - 1; j >= 0; j--) {
            res[j] = st.pop();
        }

        return res;
    }
}
