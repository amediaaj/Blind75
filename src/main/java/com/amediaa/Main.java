package com.amediaa;

import com.amediaa.challenges.GenericsChallenge;
import com.amediaa.demos.Comparables;
import com.amediaa.demos.Iterators;
import com.amediaa.problems.TwoSum;

public class Main {

    public static void main(String[] args) {
        // demo(new Iterators());
        // demo(new Generics());
        demo(new TwoSum());

        // demo(new GenericsChallenge());
        // demo(new Comparables());
    }

    private static void demo(Demo demo) {
        demo.execute();
    }

}
