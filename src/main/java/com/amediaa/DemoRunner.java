package com.amediaa;

import com.amediaa.demos.DemoFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoRunner {
    private final List<DemoFactory> factories = new ArrayList<>();

    // Method to add arbitrary factories
    public void addFactories(List<DemoFactory> demoFactories) {
        factories.addAll(demoFactories);
    }

    // Method to iterate and run all demos
    public void runAll() {
        for (DemoFactory factory : factories) {
            Demo demo = factory.create();
            demo.execute();
            System.out.println();
        }
    }
}
