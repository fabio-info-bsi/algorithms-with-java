package br.com.fabex.dataofstructs.trees.bst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl<T extends Comparable<T>> extends AbstractBinarySearchTree<T> {

    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTreeImpl.class);

    @Override
    public void inOrderTreeWalk(BinarySearchNode<T> binarySearchNode) {
        if (null != binarySearchNode) {
            inOrderTreeWalk(binarySearchNode.getLeftChild());
            logger.debug("{}", binarySearchNode.getKey());
            inOrderTreeWalk(binarySearchNode.getRightChild());
        }
    }

    @Override
    public void preOrderTreeWalk(BinarySearchNode<T> binarySearchNode) {
        if (null != binarySearchNode) {
            logger.debug("{}", binarySearchNode.getKey());
            preOrderTreeWalk(binarySearchNode.getLeftChild());
            preOrderTreeWalk(binarySearchNode.getRightChild());
        }
    }

    @Override
    public void posOrderTreeWalk(BinarySearchNode<T> binarySearchNode) {
        if (null != binarySearchNode) {
            posOrderTreeWalk(binarySearchNode.getLeftChild());
            posOrderTreeWalk(binarySearchNode.getRightChild());
            logger.debug("{}", binarySearchNode.getKey());
        }
    }

    public void breadthFirstTreeWalk(BinarySearchNode<T> binarySearchNode) {
        if (null == binarySearchNode) {
            return;
        }
        Queue<BinarySearchNode<T>> queue = new LinkedList<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            BinarySearchNode<T> currentNode = queue.poll();
            logger.debug("{}", currentNode);

            if (null != currentNode.getLeftChild()) {
                queue.offer(currentNode.getLeftChild());
            }

            if (null != currentNode.getRightChild()) {
                queue.offer(currentNode.getRightChild());
            }
        }
    }

    @Override
    public BinarySearchNode<T> treeSearch(BinarySearchNode<T> root, T key) {
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
    public BinarySearchNode<T> iterativeTreeSearch(BinarySearchNode<T> root, T key) {
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
    public BinarySearchNode<T> treeMinimum(BinarySearchNode<T> binarySearchNode) {
        while (null != binarySearchNode && null != binarySearchNode.getLeftChild()) {
            binarySearchNode = binarySearchNode.getLeftChild();
        }
        return binarySearchNode;
    }

    @Override
    public BinarySearchNode<T> treeMaximum(BinarySearchNode<T> binarySearchNode) {
        while (null != binarySearchNode && null != binarySearchNode.getRightChild()) {
            binarySearchNode = binarySearchNode.getRightChild();
        }
        return binarySearchNode;
    }

    @Override
    public BinarySearchNode<T> treeSuccessor(BinarySearchNode<T> binarySearchNode) {
        if (null != binarySearchNode.getRightChild()) {
            return treeMinimum(binarySearchNode.getRightChild());
        } else {
            BinarySearchNode<T> aux = binarySearchNode.getParent();
            while (null != aux && binarySearchNode == aux.getRightChild()) {
                binarySearchNode = aux;
                aux = aux.getParent();
            }
            return aux;
        }
    }

    @Override
    public BinarySearchNode<T> treePredecessor(BinarySearchNode<T> binarySearchNode) {
        if (null != binarySearchNode.getLeftChild()) {
            return treeMaximum(binarySearchNode.getLeftChild());
        } else {
            BinarySearchNode<T> aux = binarySearchNode.getParent();
            while (null != aux && binarySearchNode == aux.getLeftChild()) {
                binarySearchNode = aux;
                aux = aux.getParent();
            }
            return aux;
        }
    }

    @Override
    public void treeInsert(BinarySearchNode<T> newBinarySearchNode) {
        BinarySearchNode<T> rootTmp = this.root;
        BinarySearchNode<T> findParent = null;
        while (null != rootTmp) {
            findParent = rootTmp;
            //Go to left child
            if (newBinarySearchNode.getKey().compareTo(rootTmp.getKey()) < 0) {
                rootTmp = rootTmp.getLeftChild();
            } else { //Go to right child
                rootTmp = rootTmp.getRightChild();
            }
        }
        //Set founded parent
        newBinarySearchNode.setParent(findParent);
        //If node is root
        if (null == findParent) {
            this.root = newBinarySearchNode;
        } else if (newBinarySearchNode.getKey().compareTo(findParent.getKey()) < 0) { //If newNode is left child of your parent
            findParent.setLeftChild(newBinarySearchNode);
        } else { //If newNode is right child of your parent
            findParent.setRightChild(newBinarySearchNode);
        }
        this.countNodes++;
    }

    private void transplant(BinarySearchNode<T> rootBinarySearchNode, BinarySearchNode<T> replaceBinarySearchNode) {
        //When rootNode is the tree root node
        if (null == rootBinarySearchNode.getParent()) {
            this.root = replaceBinarySearchNode;
        } else if (rootBinarySearchNode == rootBinarySearchNode.getParent().getLeftChild()) { // Parent node of the rootNode set replaceNode to left child
            rootBinarySearchNode.getParent().setLeftChild(replaceBinarySearchNode);
        } else { // Parent node of the rootNode set replaceNode to right child
            rootBinarySearchNode.getParent().setRightChild(replaceBinarySearchNode);
        }
        // Point to parent of the rootNode if replaceNode is not null ( subtree above of the rootNode)
        if (null != replaceBinarySearchNode) {
            replaceBinarySearchNode.setParent(rootBinarySearchNode.getParent());
        }
    }

    @Override
    public void treeDelete(BinarySearchNode<T> binarySearchNode) {
        if (null == binarySearchNode.getLeftChild()) { //#1 case
            transplant(binarySearchNode, binarySearchNode.getRightChild());
        } else if (null == binarySearchNode.getRightChild()) { //#2 case
            transplant(binarySearchNode, binarySearchNode.getLeftChild());
        } else { //#3 case
            BinarySearchNode<T> aux = treeMinimum(binarySearchNode.getRightChild()); //Get minimum node in right subtree
            //#4 case
            if (aux != binarySearchNode.getRightChild()) { // If minimum node is right child of the deleted node
                this.transplant(aux, aux.getRightChild());
                aux.setRightChild(binarySearchNode.getRightChild());
                aux.getRightChild().setParent(aux);
            }
            transplant(binarySearchNode, aux);
            aux.setLeftChild(binarySearchNode.getLeftChild());
            aux.getLeftChild().setParent(aux);
        }
        this.countNodes--;
    }
}
