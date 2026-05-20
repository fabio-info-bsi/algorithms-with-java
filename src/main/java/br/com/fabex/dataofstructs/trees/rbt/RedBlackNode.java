package br.com.fabex.dataofstructs.trees.rbt;

public class RedBlackNode<T extends Comparable<T>> {
    T key;
    Color color;
    RedBlackNode<T> parent;
    RedBlackNode<T> leftChild;
    RedBlackNode<T> rightChild;

    public RedBlackNode(T key) {
        this.key = key;
    }

    public RedBlackNode(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String str = "{ NULL }";
        if (null != key) {
            str = "Node{ key=" + key + ", color=" + color + " }";
        }
        return str;
    }
}
