package fr.bamandine.node;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringNode extends Node<String> {

    public StringNode(String value, List<Node> children) {
        super(value, children);
    }

    public StringNode(String value, Node... children) {
        super(value, children);
    }

    @Override
    public Node<String> addChild(String data) {
        final StringNode toAdd = new StringNode(data);
        children.add(toAdd);
        return toAdd;
    }

    @Override
    public String getValuesToString(String delimiter) {
        return this.flattened()
                .map(node -> String.valueOf(node.getValue()))
                .collect(Collectors.joining(delimiter));
    }

    public Predicate<String> isLengthLessThanEqual(Integer maxLength)
    {
        return v -> v.length() <= maxLength;
    }

    public Predicate<String> isMoreLessThanEqual(Integer minLength)
    {
        return v -> v.length() >= minLength;
    }
}
