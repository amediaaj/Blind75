package com.amediaa;

import com.amediaa.problems.ClimbStairs;

public class Main {

    public static void main(String[] args) {
        // demo(new Iterators());
        // demo(new Generics());

//        demo(new TwoSum());
//        demo(new BuySellStocks());
//        demo(new ContainsDuplicate());
//        demo(new ProductExceptSelf());
//        demo(new MaxSubArray());
//        demo(new MaxProduct());
//        demo(new FindMin());
//        demo(new ThreeSum());
//        demo(new MaxArea());
        demo(new ClimbStairs());

//        demo(new GenericsChallenge());
//        demo(new Comparables());
//        demo(new ImmutableLists());
    }

    private static void demo(Demo demo) {
        demo.execute();
    }

}
