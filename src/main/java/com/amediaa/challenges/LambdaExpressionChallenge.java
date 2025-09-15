package com.amediaa.challenges;

import com.amediaa.common.Demo;

import java.util.*;
import java.util.function.Consumer;

public class LambdaExpressionChallenge implements Demo {

    @Override
    public void execute() {
        Random random = new Random();
        String[] firstNames = new String[] {"Bob", "Anna", "Alex", "Cassidy"};

        // Array backed list example
//        List<String> backedByArray = Arrays.asList(firstNames);

        Arrays.setAll(firstNames, i -> firstNames[i].toUpperCase());
        Arrays.setAll(firstNames, i -> firstNames[i] + " " + (char)random.nextInt('A', (int) 'Z' + 1)
                + "." + " " + new StringBuilder(firstNames[i]).reverse());;

        var namesList = new ArrayList<>(List.of(firstNames));
        Iterator<String> iterator = namesList.iterator();

        while(iterator.hasNext()) {
            String fullName = iterator.next();
            String[] nameArr = fullName.split(" ");
            if(nameArr[0].equals(nameArr[2])) {
                iterator.remove();
            }
        }

        namesList.forEach(System.out::println);

    }
}
