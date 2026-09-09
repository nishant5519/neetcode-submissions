class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for(int price : prices) {
            if(minSoFar > price)
                minSoFar = price;
            
            maxProfit = Math.max(maxProfit , price-minSoFar);
        }

        return maxProfit;
    }
}
