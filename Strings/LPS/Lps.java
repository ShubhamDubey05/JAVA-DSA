package Strings.LPS;

public class Lps {public static void main(String[] args) {
  
  String ptr = "aabaacaabaa";
  int  n  = ptr.length();
  int [] lps = new int [n];
  lps[0] = 0;
  int len = 0;
  int i =  1;
  while(i < n){
    if(ptr.charAt(len) ==ptr.charAt(i)){
      len++;
      lps[i] = len;
      i++;
    }
     else{
         if(len == 0){
          lps[i] = 0;
           i++;
         }
         else{
             len = lps[i-1];
         }
     }
  }
}
  
}
