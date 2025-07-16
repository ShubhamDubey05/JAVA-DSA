package Strings.LongestPrefixSuffix;

public class LongestPrefixSuffix {
  public static void main(String[] args) {
    String str  = "ABCDEABCD";
    int n = str.length();

    int [] lps  = new int [n];

    int pre = 0;
    int suf =1;
    while(suf < str.length()){
      if(str.charAt(pre) == str.charAt(suf)){
        lps[suf] = pre +1;
        pre++;
        suf++;
      }
      else{
           if(pre == 0){
            lps[suf] =0;
            suf++;
           }
           else{
              pre = lps[pre-1];
           }
      }
    }


    System.out.println(lps[n-1]);
  }
  
}
