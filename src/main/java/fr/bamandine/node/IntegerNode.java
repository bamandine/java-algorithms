package fr.bamandine.node;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntegerNode extends Node<Integer> {

    public IntegerNode(Integer value, List<Node> children) {
        super(value, children);
    }

    public IntegerNode(Integer value, Node... children) {
        super(value, children);
    }

    @Override
    public Node<Integer> addChild(Integer data) {
        final IntegerNode toAdd = new IntegerNode(data);
        children.add(toAdd);
        return toAdd;
    }

    @Override
    public String getValuesToString(String delimiter) {
        return this.flattened()
                .map(node -> String.valueOf(node.getValue()))
                .collect(Collectors.joining(delimiter));
    }

    public Predicate<Integer> isEven()
    {
        return v -> v % 2 == 0;
    }

    public Predicate<Integer> isOdd()
    {
        return v -> v % 2 != 0;
    }

    public BinaryOperator<Integer> sumAll() {
        return (a, b) -> a + b;
    }

    public BinaryOperator<Integer> multiplyAll() {
        return (a, b) -> a * b;
    }
}
