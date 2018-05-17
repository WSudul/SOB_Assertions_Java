package test;

import java.util.Collection;
import java.util.Optional;

public class TestArgument {
    private TestOperation operation;
    private Collection<Integer> arguments; //leave as Collection<Integer> ? Ignore on SUM, SIZE ?

    public TestArgument(TestOperation operation, Collection<Integer> arguments) {
        this.operation = operation;
        this.arguments = arguments;
    }

    public TestArgument(TestOperation operation) {
        this.operation = operation;
        this.arguments = null;
    }

    public TestOperation getOperation() {
        return operation;
    }

    public void setOperation(TestOperation operation) {
        this.operation = operation;
    }

    public Optional<Collection<Integer>> getArguments() {
        return Optional.ofNullable(arguments);
    }

    public void setArguments(Collection<Integer> arguments) {
        this.arguments = arguments;
    }
}
