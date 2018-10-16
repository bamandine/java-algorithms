package fr.bamandine.node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public abstract class Node<E> {

    private E value;
    protected List<Node> children = new LinkedList<>();

    public Node(E value, List<Node> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }

    public Node(E value, Node... children) {
        this(value, asList(children));
    }

    public E getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public Stream<Node> flattened() {
        return Stream.concat(
                Stream.of(this),
                children.stream().flatMap(Node::flattened));
    }

    public Stream<Node> lazyTraverse() {
        return Node.concat(() -> Stream.of(this),
                () -> getChildren().stream().flatMap(Node::lazyTraverse));
    }

    public static Stream<Node> concat(Supplier<Stream<Node>> a, Supplier<Stream<Node>> b) {
        return Stream.of(a, b).flatMap(Supplier::get);
    }

    public List<E> getValues() {
        return (List<E>) this.flattened()
                .map(Node::getValue)
                .collect(toList());
    }

    public List<E> getFilteredValues(Predicate filter) {
        return (List<E>) this.flattened()
                .map(Node::getValue)
                .filter(filter)
                .collect(toList());
    }

    public boolean contains(final E element) {
        return this.flattened().anyMatch(node -> node.getValue().equals(element));
    }

    public abstract Node<E> addChild(final E data);

    public abstract String getValuesToString(String delimiter);
}
