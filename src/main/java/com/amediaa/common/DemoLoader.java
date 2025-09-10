package com.amediaa.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DemoLoader {
    public static List<Supplier<Demo>> loadFromFile(String filename) {
        List<Supplier<Demo>> factories = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String className = line.trim();
                if (!className.isEmpty()) {
                    Class<?> clazz = Class.forName(className);
                    if (Demo.class.isAssignableFrom(clazz)) {
                        @SuppressWarnings("unchecked")
                        Class<? extends Demo> demoClass = (Class<? extends Demo>) clazz;
                        factories.add(() -> {
                            try {
                                return demoClass.getDeclaredConstructor().newInstance();
                            } catch (Exception e) {
                                throw new RuntimeException("Failed to instantiate " + demoClass, e);
                            }
                        });
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factories;
    }
}

