package com.amediaa.challenges;

import com.amediaa.common.Demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaMiniChallenge implements Demo {

    // 1. Write this anonymous class as a lambda expression
    private Consumer<String> printTheWords = new Consumer<String>() {

        @Override
        public void accept(String sentence) {
            String[] words = sentence.split(" ");
            for (String word : words) {
                System.out.println(words);
            }
        }
    };

    // 1. Solution
    private Consumer<String> printTheWordsLambda =
            s -> Arrays.asList(s.split(" ")).forEach(System.out::println);

    // 2. Write the following method as a lambda expression
    private static String everySecondChar(String source) {

        StringBuilder returnVal = new StringBuilder();
        for (int i=0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    };

    // 2. Solution
    private UnaryOperator<String> everySecondCharLambda = s -> {
        StringBuilder returnVal = new StringBuilder();
        for (int i=0; i < s.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(s.charAt(i));
            }
        }

        return returnVal.toString();
    };

    // 4. Pass everySecondCharLambda to a function instead of calling it directly
    private String everySecondChar(UnaryOperator<String> function, String theString) {
        return function.apply(theString);
    }

    @Override
    public void execute() {
        printTheWords.accept("Hello World! Now is the time to learn Java!");
        System.out.println();
        printTheWordsLambda.accept("We should also learn Python!");
        System.out.println();
        System.out.println(everySecondChar("Mississippi"));
        System.out.println();
        // 3. Execute input 1234567890
        System.out.println(everySecondCharLambda.apply("1234567890"));
        System.out.println();
        // 5. Call the method from Challenge 4, passing the lambda variable
        System.out.println(everySecondChar(everySecondCharLambda, "1234567890"));
        System.out.println();
        // 6. Write a lambda expression declared with the Supplier interface
        Supplier<String> iLoveJava = () -> "I love Java";
        // 7. Use this Supplier to assign a String, "I love Java", to a variable called supplierResult
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

    }
}
