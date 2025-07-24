package br.com.fabex.dataofstructs.trees.bst;

public abstract class AbstractBinarySearchTree<T extends Comparable<T>> {
    protected Node<T> root;
    protected long countNodes;

    public Node<T> getRoot() {
        return root;
    }

    public long getCountNodes() {
        return countNodes;
    }

    public abstract void inOrderTreeWalk(Node<T> node);

    public abstract void preOrderTreeWalk(Node<T> node);

    public abstract Node<T> treeSearch(Node<T> root, T key);

    public abstract Node<T> iterativeTreeSearch(Node<T> root, T key);

    public abstract Node<T> treeMinimum(Node<T> node);

    public abstract Node<T> treeMaximum(Node<T> node);

    public abstract Node<T> treeSuccessor(Node<T> node);

    public abstract Node<T> treePredecessor(Node<T> node);

    //    public abstract void treeInsert(Node<T> root, Node<T> node);
    public abstract void treeInsert(Node<T> node);

//    public abstract void transplant(Node<T> root, Node<T> u, Node<T> v);
//    public abstract void transplant(Node<T> u, Node<T> v);

    //    public abstract void treeDelete(Node<T> root, Node<T> node);
    public abstract void treeDelete(Node<T> node);
}
