// calculate profit based on current price before checking for bestBuyPrice
// solution works as the bestProfit is checked first before bestBuyPrice is checked/replaced
class Solution {
    public int maxProfit(int[] prices) {
      int bestProfit = 0, bestBuyPrice = prices[0];
      for(int price : prices) {
        // calculate profit using bestBuyPrice
        int currProfit = price - bestBuyPrice;
        if(currProfit > bestProfit) {
          bestProfit = currProfit;
        }
        // check/replace bestBuyPrice
        if(price < bestBuyPrice) {
          bestBuyPrice = price;
        }
      }
      return bestProfit;
    }
}
