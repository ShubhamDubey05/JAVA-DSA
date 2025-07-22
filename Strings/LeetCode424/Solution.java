package Strings.LeetCode424;

import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    String s = "ABABABBABA";
    int k = 3;

    int maxLen = 0;

    for (int i = 0; i < s.length(); i++) {
      HashMap<Character, Integer> mp = new HashMap<>();
      int maxFreq = 0;

      for (int j = i; j < s.length(); j++) {
        char ch = s.charAt(j);
        mp.put(ch, mp.getOrDefault(ch, 0) + 1);

        maxFreq = Math.max(maxFreq, mp.get(ch));  
        int windowLen = j - i + 1;
        int changes = windowLen - maxFreq;        

        if (changes <= k) {
          maxLen = Math.max(maxLen, windowLen);
        } else {
          break;
        }
      }
    }

    System.out.println(maxLen);
  }
}
  

