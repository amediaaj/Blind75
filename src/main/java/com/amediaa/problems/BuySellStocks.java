package com.amediaa.problems;

import java.util.List;

public class BuySellStocks extends Problem<int[], Integer>{
    public BuySellStocks() {
        super("121. Best Time to Buy and Sell Stock", List.of(new int[] {7,1,5,3,6,4}), List.of(5));
    }

    @Override
    Integer solution(int[] input) {
        return maxProfit(input);
    }

    // LeetCode 121
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }
}
