package com.amediaa;

import com.amediaa.challenges.GenericsChallenge;
import com.amediaa.demos.Comparables;
import com.amediaa.demos.ImmutableLists;
import com.amediaa.problems.ThreeSum;

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
        demo(new ThreeSum());

//        demo(new GenericsChallenge());
//        demo(new Comparables());
//        demo(new ImmutableLists());
    }

    private static void demo(Demo demo) {
        demo.execute();
    }

}
