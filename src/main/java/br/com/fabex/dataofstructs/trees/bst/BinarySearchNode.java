package br.com.fabex.dataofstructs.trees.bst;

public class BinarySearchNode<T extends Comparable<T>> {
    private T key;
    private BinarySearchNode<T> parent;
    private BinarySearchNode<T> leftChild;
    private BinarySearchNode<T> rightChild;

    public BinarySearchNode(T key) {
        this.key = key;
    }

    public BinarySearchNode(T key, BinarySearchNode<T> parent, BinarySearchNode<T> leftChild, BinarySearchNode<T> rightChild) {
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

    public BinarySearchNode<T> getParent() {
        return parent;
    }

    void setParent(BinarySearchNode<T> parent) {
        this.parent = parent;
    }

    public BinarySearchNode<T> getLeftChild() {
        return leftChild;
    }

    void setLeftChild(BinarySearchNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinarySearchNode<T> getRightChild() {
        return rightChild;
    }

    void setRightChild(BinarySearchNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{ key=" + key + "}";
    }
}
