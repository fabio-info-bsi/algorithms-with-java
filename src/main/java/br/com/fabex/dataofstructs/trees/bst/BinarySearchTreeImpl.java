package br.com.fabex.dataofstructs.trees.bst;

public class BinarySearchTreeImpl<T extends Comparable<T>> extends AbstractBinarySearchTree<T> {

    @Override
    public void inOrderTreeWalk(Node<T> node) {
        // TODO document why this method is empty
    }

    @Override
    public void preOrderTreeWalk(Node<T> node) {
        // TODO document why this method is empty
    }

    @Override
    public Node<T> treeSearch(Node<T> root, T key) {
        if (null == root || key.equals(root.getKey())) {
            return root;
        }
        if (key.compareTo(root.getKey()) < 0) {
            return treeSearch(root.getLeftChild(), key);
        } else {
            return treeSearch(root.getRightChild(), key);
        }
    }

    @Override
    public Node<T> iterativeTreeSearch(Node<T> root, T key) {
        return null;
    }

    @Override
    public Node<T> treeMinimum(Node<T> node) {
        while (null != node && null != node.getLeftChild()) {
            node = node.getLeftChild();
        }
        return node;
    }

    @Override
    public Node<T> treeMaximum(Node<T> node) {
        while (null != node && null != node.getRightChild()) {
            node = node.getRightChild();
        }
        return node;
    }

    @Override
    public Node<T> treeSuccessor(Node<T> node) {
        if (null != node.getRightChild()) {
            return treeMinimum(node.getRightChild());
        } else {
            Node<T> aux = node.getParent();
            while (null != aux && node == aux.getRightChild()) {
                node = aux;
                aux = aux.getParent();
            }
            return aux;
        }
    }

    @Override
    public Node<T> treePredecessor(Node<T> node) {
        return null;
    }

    @Override
    public void treeInsert(Node<T> newNode) {
        Node<T> rootTmp = this.root;
        Node<T> findParent = null;
        while (null != rootTmp) {
            findParent = rootTmp;
            if (newNode.getKey().compareTo(rootTmp.getKey()) < 0) {
                rootTmp = rootTmp.getLeftChild();
            } else {
                rootTmp = rootTmp.getRightChild();
            }
        }
        newNode.setParent(findParent);
        if (null == findParent) {
            this.root = newNode;
        } else if (newNode.getKey().compareTo(findParent.getKey()) < 0) {
            findParent.setLeftChild(newNode);
        } else {
            findParent.setRightChild(newNode);
        }
        this.countNodes++;
    }

    private void transplant(Node<T> rootNode, Node<T> replaceNode) {
        //When rootNode is the tree root node
        if (null == rootNode.getParent()) {
            this.root = replaceNode;
        } else if (rootNode == rootNode.getParent().getLeftChild()) { // Parent node of the rootNode set replaceNode to left child
            rootNode.getParent().setLeftChild(replaceNode);
        } else { // Parent node of the rootNode set replaceNode to right child
            rootNode.getParent().getParent().setRightChild(replaceNode);
        }
        // Point to parent of the rootNode if replaceNode is not null ( subtree above of the rootNode)
        if (null != replaceNode) {
            replaceNode.setParent(rootNode.getParent());
        }
    }

    @Override
    public void treeDelete(Node<T> node) {
        if (null == node.getLeftChild()) {
            transplant(node, node.getRightChild());
        } else if (null == node.getRightChild()) {
            transplant(node, node.getLeftChild());
        } else {
            Node<T> aux = treeMinimum(node.getRightChild());
        }
    }
}
