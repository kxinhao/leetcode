class Solution {
    public int maxProfit(int[] prices) {
      int bestProfit = 0, bestBuyPrice = prices[0];
      for(int price : prices) {
        int currProfit = price - bestBuyPrice;
        if(currProfit > bestProfit) {
          bestProfit = currProfit;
        }
        if(price < bestBuyPrice) {
          bestBuyPrice = price;
        }
      }
      return bestProfit;
    }
}
