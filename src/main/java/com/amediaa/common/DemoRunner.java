package com.amediaa.common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DemoRunner {
    private final List<Supplier<Demo>> factories = new ArrayList<>();

    public void addFactories(List<Supplier<Demo>> factories) {
        this.factories.addAll(factories);
    }

    public void runAll() {
        for (Supplier<Demo> factory : factories) {
            Demo demo = factory.get();
            demo.execute();
            System.out.println();
        }
    }
}
