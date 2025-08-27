package com.amediaa.problems;

public class BuySellStocks extends Problem<BuySellStocksData>{
    public BuySellStocks() {
        super(new BuySellStocksData[] {
                new BuySellStocksData(new int[] {7,1,5,3,6,4})
        });
    }

    @Override
    public void execute() {
        solve();
    }

    private void solve() {
        System.out.println(maxProfit(testData[0].getSequence()));
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

class BuySellStocksData {
    private int[] sequence;

    BuySellStocksData(int[] sequence) {
        this.sequence = sequence;
    }

    public int[] getSequence() {
        return sequence;
    }
}
