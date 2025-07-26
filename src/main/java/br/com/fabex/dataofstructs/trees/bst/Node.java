package br.com.fabex.dataofstructs.trees.bst;

public class Node<T extends Comparable<T>> {
    private T key;
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T key) {
        this.key = key;
    }

    public Node(T key, Node<T> parent, Node<T> leftChild, Node<T> rightChild) {
        this.key = key;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getParent() {
        return parent;
    }

    void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{ key=" + key + "}";
    }
}
