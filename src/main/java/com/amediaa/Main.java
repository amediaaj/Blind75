package com.amediaa;

import com.amediaa.common.DemoLoader;
import com.amediaa.common.DemoRunner;

public class Main {
    public static void main(String[] args) {
        DemoRunner runner = new DemoRunner();
        runner.addFactories(DemoLoader.loadFromFile("src/main/java/com/amediaa/demos.txt"));
        runner.runAll();
    }
}
