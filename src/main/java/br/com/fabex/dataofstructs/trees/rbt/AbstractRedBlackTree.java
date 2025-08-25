package br.com.fabex.dataofstructs.trees.rbt;

public abstract class AbstractRedBlackTree<T extends Comparable<T>> {
    protected RedBlackNode<T> root;
    /**
     * Sentinel pointer to null
     */
    protected final RedBlackNode<T> NULL = new RedBlackNode<>(Color.BLACK);
    protected long countNodes;

    public RedBlackNode<T> getRoot() {
        return root;
    }

    public long getCountNodes() {
        return countNodes;
    }

    public abstract void inOrderTreeWalk(RedBlackNode<T> redBlackNode);

    public abstract void preOrderTreeWalk(RedBlackNode<T> redBlackNode);

    public abstract void posOrderTreeWalk(RedBlackNode<T> redBlackNode);

    public abstract RedBlackNode<T> treeSearch(RedBlackNode<T> root, T key);

    public abstract RedBlackNode<T> iterativeTreeSearch(RedBlackNode<T> root, T key);

    public abstract RedBlackNode<T> treeMinimum(RedBlackNode<T> redBlackNode);

    public abstract RedBlackNode<T> treeMaximum(RedBlackNode<T> redBlackNode);

    public abstract RedBlackNode<T> treeSuccessor(RedBlackNode<T> redBlackNode);

    public abstract RedBlackNode<T> treePredecessor(RedBlackNode<T> redBlackNode);

    public abstract void treeInsert(RedBlackNode<T> redBlackNode);

    public abstract void treeDelete(RedBlackNode<T> redBlackNode);
}
