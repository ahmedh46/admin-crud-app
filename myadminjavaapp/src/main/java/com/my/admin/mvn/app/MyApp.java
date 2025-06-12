package com.my.admin.mvn.app;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyApp {
    public static void main(String[] args) {
        callTests();
    }

    public static void callTests() {
        Test test = new Test();
        test.tests();
    }
}

class Test {
    public void tests() {
        startApp();

        // This is a simple example of a stack-based compiler for checking balanced
        // parentheses
        String expression = "{(a+b)*(c-d)}";
        boolean isBalanced = areBracketsBalanced(expression);
        System.out.println("Parentheses balanced: " + isBalanced);

        // initialize an array and demonstrate some basic operations
        int[] testArr = new int[] {};
        testArr = new int[] { 1, 2, 3, 4, 5 };
        System.out.println("Array contents: " + Arrays.toString(testArr));
        System.out.print("Prime numbers in testArr: ");
        for (int num : testArr) {
            if (num > 1) {
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.print(num + " ");
                }
            }
        }
        System.out.println();

        // initialize an array with a specific size and set the first element
        int[] testArr2 = new int[5];
        testArr2[0] = 10;

        // initialize an array with specific values
        int[] testArr3 = { 6, 7, 8, 9, 10 };
        System.out.println("Array contents: " + Arrays.toString(testArr3));
        int max = testArr3[0];
        int min = testArr3[0];
        for (int i = 1; i < testArr3.length; i++) {
            if (testArr3[i] > max) {
                max = testArr3[i];
            }
            if (testArr3[i] < min) {
                min = testArr3[i];
            }
        }
        System.out.println("Largest number in testArr3: " + max);
        System.out.println("Smallest number in testArr3: " + min);
        System.out.println("Min and Max are the same in testArr3: " + (max == min));

        // Example of reversing a string using StringBuilder and checking for
        // palindromes
        String original = "madam";
        var reversed = new StringBuilder(original).reverse().toString();
        System.out.println("Original string: " + original);
        System.out.println("Reversed string: " + reversed);
        System.out.println("Is \"" + original + "\" a palindrome? " + original.equalsIgnoreCase(reversed));

        Queue<String> queue = new ArrayDeque<>();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        System.out.println("Queue contents: " + queue);
        System.out.println("Polling from queue: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // This is a simple example of a pyramid pattern with buzzer questions
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= rows; i++) {
            if (i % 2 == 0) {
                System.out.println("Buzzer Question at step " + i + "!");
            } else {
                System.out.println("Normal step " + i);
            }
        }

        // Example of using a simple HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);
        System.out.println("HashMap contents: " + map);
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Example of using a simple ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("ArrayList contents: " + list);
        for (String item : list) {
            System.out.println("Item: " + item);
        }
        
        // Using Collections, map, and stream to filter for all that contain "Apple"
        List<String> appleList = new ArrayList<>();
        Collections.addAll(appleList, list.stream()
            .filter(item -> item.contains("Apple"))
            .map(String::toUpperCase)
            .toArray(String[]::new));
        appleList.forEach(System.out::println);

        done();
        System.exit(0);
    }

    private boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty())
                    return false;
                char open = stack.pop();

                if (!isMatchingPair(open, ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    private void done() {
        System.out.println("Done");
    }

    public void startApp() {
        System.out.println("Start App");
    }
}
