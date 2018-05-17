package test;


import number.NumberSet;
import number.NumberSetImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public class Tests {

    private List<String> assertionFails;
    private boolean endOfTest;
    private NumberSet numberSet;
    private Queue<TestArgument> arguments;


    public Tests(Queue<TestArgument> arguments) {
        numberSet = new NumberSetImpl();
        this.arguments = arguments;
        this.endOfTest = false;
        this.assertionFails = new ArrayList<>();
    }

    public boolean runSingleOperation() {
        if (endOfTest || arguments.isEmpty()) {
            endOfTest = true;
            return false;

        }
        TestArgument argument = arguments.remove();

        switch (argument.getOperation()) {
            case ADD:
                Collection<Integer> add = argument.getArguments().get();
                if (!validateCollection(add)) {
                    return false;
                }
                for (Integer integer : add)
                    try {
                        numberSet.add(integer);
                    } catch (AssertionError e) {
                        assertionFails.add(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                break;
            case REMOVE:
                Collection<Integer> remove = argument.getArguments().get();
                if (!validateCollection(remove)) {
                    return false;
                }
                for (Integer integer : remove)
                    try {
                        numberSet.remove(integer);
                    } catch (AssertionError e) {
                        assertionFails.add(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                break;
            case RANDOM:
                try {
                    int randomValue = numberSet.getRandomValue();
                    System.out.println("randomValue: " + randomValue);
                } catch (AssertionError e) {
                    assertionFails.add(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                break;
            case SUM:
                try {
                    int sum = numberSet.getSumOfElements();
                    System.out.println("sum: " + sum);
                } catch (AssertionError e) {
                    assertionFails.add(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                break;
            case DIVIDE_BY:
                Collection<Integer> divideBy = argument.getArguments().get();
                if (!validateCollection(divideBy)) {
                    return false;
                }
                for (Integer integer : divideBy)
                    try {
                        numberSet.divideAllElementsBy(integer);
                    } catch (AssertionError e) {
                        assertionFails.add(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                break;
            case CONTAIN:
                Collection<Integer> contain = argument.getArguments().get();
                if (!validateCollection(contain)) {
                    return false;
                }
                for (Integer integer : contain)
                    try {
                        numberSet.contain(integer);
                    } catch (AssertionError e) {
                        assertionFails.add(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                break;
            case SIZE:
                try {
                    int size = numberSet.getSize();
                    System.out.println("size: " + size);
                } catch (AssertionError e) {
                    assertionFails.add(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                break;
        }


        return true;

    }

    public boolean runOperations() {
        while (!arguments.isEmpty()) {
            if (!runSingleOperation()) {
                return endOfTest;
            }
        }
        return true;
    }

    private boolean validateCollection(Collection<Integer> collection) {
        if (null != collection && !collection.isEmpty()) {
            for (Integer integer : collection)
                if (null == integer) {
                    System.out.println("Null value encountered in argument's collection");
                    return false;
                }
        }
        return true;
    }

}
