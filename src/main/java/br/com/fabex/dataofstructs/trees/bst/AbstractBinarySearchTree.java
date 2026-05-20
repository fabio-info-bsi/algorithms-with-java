package br.com.fabex.dataofstructs.trees.bst;

public abstract class AbstractBinarySearchTree<T extends Comparable<T>> {
    protected BinarySearchNode<T> root;
    protected long countNodes;

    public BinarySearchNode<T> getRoot() {
        return root;
    }

    public long getCountNodes() {
        return countNodes;
    }

    public abstract void inOrderTreeWalk(BinarySearchNode<T> binarySearchNode);

    public abstract void preOrderTreeWalk(BinarySearchNode<T> binarySearchNode);

    public abstract void posOrderTreeWalk(BinarySearchNode<T> binarySearchNode);

    public abstract BinarySearchNode<T> treeSearch(BinarySearchNode<T> root, T key);

    public abstract BinarySearchNode<T> iterativeTreeSearch(BinarySearchNode<T> root, T key);

    public abstract BinarySearchNode<T> treeMinimum(BinarySearchNode<T> binarySearchNode);

    public abstract BinarySearchNode<T> treeMaximum(BinarySearchNode<T> binarySearchNode);

    public abstract BinarySearchNode<T> treeSuccessor(BinarySearchNode<T> binarySearchNode);

    public abstract BinarySearchNode<T> treePredecessor(BinarySearchNode<T> binarySearchNode);

    public abstract void treeInsert(BinarySearchNode<T> binarySearchNode);

    public abstract void treeDelete(BinarySearchNode<T> binarySearchNode);
}
