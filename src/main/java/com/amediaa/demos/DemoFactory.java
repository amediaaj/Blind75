package com.amediaa.demos;

import com.amediaa.Demo;

@FunctionalInterface
public interface DemoFactory {
    Demo create();
}
