package org.sob;

import test.TestArgument;
import test.TestOperation;
import test.Tests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queue<TestArgument> testArgumentQueue = new LinkedList<>();

        testArgumentQueue.add(new TestArgument(TestOperation.SUM,
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, -1, -2, -3, -4)));
        testArgumentQueue.add(new TestArgument(TestOperation.SIZE));
        testArgumentQueue.add(new TestArgument(TestOperation.SUM));
        testArgumentQueue.add(new TestArgument(TestOperation.RANDOM));
        testArgumentQueue.add(new TestArgument(TestOperation.CONTAIN, Arrays.asList(10, 42, 0)));
        testArgumentQueue.add(new TestArgument(TestOperation.REMOVE, Arrays.asList(3, 5, 7, -2)));
        testArgumentQueue.add(new TestArgument(TestOperation.DIVIDE_BY, Arrays.asList(1, 2, 0)));
        testArgumentQueue.add(new TestArgument(TestOperation.SUM, Arrays.asList(3, 5, 7, 3, 5, 7)));
        testArgumentQueue.add(new TestArgument(TestOperation.REMOVE, Arrays.asList(3, 5, 7, -2)));
        testArgumentQueue.add(new TestArgument(TestOperation.SIZE));
        testArgumentQueue.add(new TestArgument(TestOperation.SUM));
        testArgumentQueue.add(new TestArgument(TestOperation.RANDOM));
        testArgumentQueue.add(new TestArgument(TestOperation.CONTAIN, Arrays.asList(-1, 0)));


        Tests tests = new Tests(testArgumentQueue);
        tests.runOperations();


    }
}
