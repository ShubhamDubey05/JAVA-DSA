package Stack.MoveElements;

import java.util.Stack;

public class Solution {
  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    System.out.println(st);
    st.push(1);
    System.out.println(st);
    st.push(2);
    System.out.println(st);
    st.push(3);
    System.out.println(st);
    st.push(4);

    System.out.println(st);
  
   Stack<Integer> temp = new Stack<>();
  while(!st.isEmpty()){
       temp.push(st.pop());
  }

  Stack<Integer> ans = new Stack<>();
   while(!temp.isEmpty()){
       ans.push(temp.pop());
  }
       System.out.println(ans);


  }
  
}
