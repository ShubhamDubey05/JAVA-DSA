package BuyandSell;

public class BuyandSell1 {
  public static void main(String[] args) {
    int [] prices = { 7, 1, 5, 3 ,6, 4};
    int n = prices.length;
    int mini = prices[0];
    int profit = 0;
    int [] dpl = new int [prices.length];
    for(int i = 1; i<prices.length; i++){
      int cost = prices[i] - mini;
      profit = Math.max(profit, cost);
       dpl[i]= profit;
      mini = Math.min(mini, prices[i]);
    }
    for(int val  : dpl){
      System.out.print(val +" ");
    }

     int [] dpr = new int [prices.length];
     int maxi = prices[n-1];
     int profitR = 0;
     for(int  i  = prices.length -1 ; i>=0; i--){
           int cost = maxi - prices[i];
              profitR= Math.max(profitR, cost);
              dpr[i] = profitR;
              maxi = Math.max(maxi , prices[i]);
     }
     System.out.println();
      for(int val  : dpr){
      System.out.print(val +" ");
    }
      int op = 0;
      for(int i = 0; i<n; i++){
        op = Math.max(op, dpr[i]+dpl[i]);
      }
      System.out.println();
     System.out.println(op);
  }
}
