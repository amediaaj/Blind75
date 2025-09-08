package com.amediaa;

import com.amediaa.common.DemoRunner;
import com.amediaa.problems.FindKthSmallest;
import com.amediaa.problems.StreamMax;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        DemoRunner runner = new DemoRunner();

        runner.addFactories(List.of(
                FindKthSmallest::new, //Heap
                StreamMax::new // Heap
        ));

        runner.runAll();
    }
}
