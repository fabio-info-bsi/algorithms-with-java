package br.com.fabex.dataofstructs.trees.bst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearchTreeImpl<T extends Comparable<T>> extends AbstractBinarySearchTree<T> {

    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTreeImpl.class);

    @Override
    public void inOrderTreeWalk(Node<T> node) {
        if (null != node) {
            inOrderTreeWalk(node.getLeftChild());
            logger.debug("{}", node.getKey());
            inOrderTreeWalk(node.getRightChild());
        }
    }

    @Override
    public void preOrderTreeWalk(Node<T> node) {
        if (null != node) {
            logger.debug("{}", node.getKey());
            preOrderTreeWalk(node.getLeftChild());
            preOrderTreeWalk(node.getRightChild());
        }
    }

    @Override
    public void posOrderTreeWalk(Node<T> node) {
        if (null != node) {
            posOrderTreeWalk(node.getLeftChild());
            posOrderTreeWalk(node.getRightChild());
            logger.debug("{}", node.getKey());
        }
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
        while (null != root && !key.equals(root.getKey())) {
            if (key.compareTo(root.getKey()) < 0) {
                root = root.getLeftChild();
            } else {
                root = root.getRightChild();
            }
        }
        return root;
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
        if (null != node.getLeftChild()) {
            return treeMaximum(node.getLeftChild());
        } else {
            Node<T> aux = node.getParent();
            while (null != aux && node == aux.getLeftChild()) {
                node = aux;
                aux = aux.getParent();
            }
            return aux;
        }
    }

    @Override
    public void treeInsert(Node<T> newNode) {
        Node<T> rootTmp = this.root;
        Node<T> findParent = null;
        while (null != rootTmp) {
            findParent = rootTmp;
            //Go to left child
            if (newNode.getKey().compareTo(rootTmp.getKey()) < 0) {
                rootTmp = rootTmp.getLeftChild();
            } else { //Go to right child
                rootTmp = rootTmp.getRightChild();
            }
        }
        //Set founded parent
        newNode.setParent(findParent);
        //If node is root
        if (null == findParent) {
            this.root = newNode;
        } else if (newNode.getKey().compareTo(findParent.getKey()) < 0) { //If newNode is left child of your parent
            findParent.setLeftChild(newNode);
        } else { //If newNode is right child of your parent
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
            if (aux != node.getRightChild()) {
                this.transplant(aux, aux.getRightChild());
                aux.setRightChild(node.getRightChild());
                aux.getRightChild().setParent(aux);
            }
            transplant(node, aux);
            aux.setLeftChild(node.getLeftChild());
            aux.getLeftChild().setParent(aux);
        }
        this.countNodes--;
    }
}
