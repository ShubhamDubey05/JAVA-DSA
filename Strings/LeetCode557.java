package Strings;

public class LeetCode557 {
  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    int n =  s.length();
    String ans = "";
    StringBuilder temp = new StringBuilder();
    int i  =0;
    while(i < n){
      if(s.charAt(i)==' '){
         temp.reverse();
        ans+=  temp.toString();
      } else {
      temp.append(s.charAt(i));
      }
      i++;
    }
  }
}
