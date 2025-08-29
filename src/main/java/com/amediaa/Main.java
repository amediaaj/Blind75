package com.amediaa;

import com.amediaa.problems.*;

public class Main {

    public static void main(String[] args) {
        // demo(new Iterators());
        // demo(new Generics());

        demo(new TwoSum());
        demo(new BuySellStocks());
        demo(new ContainsDuplicate());
        demo(new ProductExceptSelf());
        demo(new MaxSubArray());
        demo(new MaxProduct());

        // demo(new GenericsChallenge());
        // demo(new Comparables());
    }

    private static void demo(Demo demo) {
        demo.execute();
    }

}
