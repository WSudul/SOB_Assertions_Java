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
            //todo end of test flag ?
            endOfTest = true;
            return false;

        }
        TestArgument argument = arguments.remove();

        switch (argument.getOperation()) {
            case ADD:

                Collection<Integer> add = argument.getArguments().get();
                if (!validateCollection(add)) {
                    //todo log bad ? ignore validation?
                    return false;
                }
                for (Integer integer : add)
                    try {
                        numberSet.add(integer);
                    } catch (AssertionError e) {
                        assertionFails.add(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                break;
            case REMOVE:
                break;
            case RANDOM:
                break;
            case SUM:
                break;
            case DIVIDE_BY:
                break;
            case CONTAIN:
                break;
            case SIZE:
                break;
        }


        return true;

    }

    public boolean runOperations() {
        for (TestArgument argument : arguments) {
            if (!runSingleOperation())
                return false;
        }
        return true;
    }

    private boolean validateCollection(Collection<Integer> collection) {
        if (null != collection && !collection.isEmpty()) {
            for (Integer integer : collection)
                if (null != integer)
                    return false;
        }
        return true;
    }

}
