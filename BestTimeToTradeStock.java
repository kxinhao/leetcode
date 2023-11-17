class Solution {
    public int maxProfit(int[] prices) {
        int bestProfit = 0;
        int bestPrice = prices[0];
        for (int i = 0; i<prices.length; i++) {
            // int currProfit = prices[i] - bestPrice;
            // if(prices[i] < bestPrice) {
            //     bestPrice = prices[i];
            // }
            // else if(currProfit > bestProfit) {
            //     bestProfit = currProfit;
            // }
            bestProfit = Math.max(bestProfit, prices[i] - bestPrice);
            bestPrice = Math.min(bestPrice, prices[i]);
        }
        return bestProfit;
    }
}
