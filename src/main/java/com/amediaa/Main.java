package com.amediaa;

import com.amediaa.demos.FunctionalInterfaces;
import com.amediaa.demos.Generics;
import com.amediaa.problems.TwoSum;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DemoRunner runner = new DemoRunner();

        runner.addFactories(List.of(
                Generics::new,
                FunctionalInterfaces::new,
                TwoSum::new
        ));

        runner.runAll();
    }
}
