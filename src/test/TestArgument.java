package test;

import java.util.Collection;
import java.util.Optional;

public class TestArgument {
    private TestOperation operation;
    private Optional<Collection<Integer>> arguments; //leave as Collection<Integer> ? Ignore on SUM, SIZE ?

    public TestArgument(TestOperation operation, Collection<Integer> arguments) {
        this.operation = operation;
        this.arguments = Optional.ofNullable(arguments);
    }

    public TestOperation getOperation() {
        return operation;
    }

    public void setOperation(TestOperation operation) {
        this.operation = operation;
    }

    public Optional<Collection<Integer>> getArguments() {
        return arguments;
    }

    public void setArguments(Optional<Collection<Integer>> arguments) {
        this.arguments = arguments;
    }
}
