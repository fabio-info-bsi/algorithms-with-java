package br.com.fabex.dataofstructs.trees.rbt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTreeImpl<T extends Comparable<T>> extends AbstractRedBlackTree<T> {

    private static final Logger logger = LoggerFactory.getLogger(RedBlackTreeImpl.class);

    @Override
    public void inOrderTreeWalk(RedBlackNode<T> redBlackNode) {
        if (!NULL.equals(redBlackNode)) {
            inOrderTreeWalk(redBlackNode.leftChild);
            logger.debug("{}", redBlackNode.key);
            inOrderTreeWalk(redBlackNode.rightChild);
        }
    }

    @Override
    public void preOrderTreeWalk(RedBlackNode<T> redBlackNode) {
        if (!NULL.equals(redBlackNode)) {
            logger.debug("{}", redBlackNode.key);
            preOrderTreeWalk(redBlackNode.leftChild);
            preOrderTreeWalk(redBlackNode.rightChild);
        }
    }

    @Override
    public void posOrderTreeWalk(RedBlackNode<T> redBlackNode) {
        if (!NULL.equals(redBlackNode)) {
            posOrderTreeWalk(redBlackNode.leftChild);
            posOrderTreeWalk(redBlackNode.rightChild);
            logger.debug("{}", redBlackNode.key);
        }
    }

    @Override
    public void breadthFirstTreeWalk(RedBlackNode<T> redBlackNode) {
        if (NULL.equals(redBlackNode)) {
            return;
        }
        Queue<RedBlackNode<T>> queue = new LinkedList<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            RedBlackNode<T> currentNode = queue.poll();
            logger.debug("{}", currentNode);

            if (!NULL.equals(currentNode.leftChild)) {
                queue.offer(currentNode.leftChild);
            }

            if (!NULL.equals(currentNode.rightChild)) {
                queue.offer(currentNode.rightChild);
            }
        }
    }

    @Override
    public RedBlackNode<T> treeSearch(RedBlackNode<T> root, T key) {
        if (null == root || NULL.equals(root)) {
            return null;
        }

        if (key.equals(root.key)) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            return treeSearch(root.leftChild, key);
        } else {
            return treeSearch(root.rightChild, key);
        }
    }

    @Override
    public RedBlackNode<T> iterativeTreeSearch(RedBlackNode<T> root, T key) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public RedBlackNode<T> treeMinimum(RedBlackNode<T> redBlackNode) {
        while ((null != redBlackNode && !NULL.equals(redBlackNode))
                && (null != redBlackNode.leftChild && !NULL.equals(redBlackNode.leftChild))) {
            redBlackNode = redBlackNode.leftChild;
        }
        return redBlackNode;
    }

    @Override
    public RedBlackNode<T> treeMaximum(RedBlackNode<T> redBlackNode) {
        while ((null != redBlackNode && !NULL.equals(redBlackNode))
                && (null != redBlackNode.rightChild && !NULL.equals(redBlackNode.rightChild))) {
            redBlackNode = redBlackNode.rightChild;
        }
        return redBlackNode;
    }

    @Override
    public RedBlackNode<T> treeSuccessor(RedBlackNode<T> redBlackNode) {
        if (null != redBlackNode.rightChild) {
            return treeMinimum(redBlackNode.rightChild);
        } else {
            RedBlackNode<T> aux = redBlackNode.parent;
            while (null != aux && redBlackNode == aux.rightChild) {
                redBlackNode = aux;
                aux = aux.parent;
            }
            return aux;
        }
    }

    @Override
    public RedBlackNode<T> treePredecessor(RedBlackNode<T> redBlackNode) {
        if (null != redBlackNode.leftChild) {
            return treeMaximum(redBlackNode.leftChild);
        } else {
            RedBlackNode<T> aux = redBlackNode.parent;
            while (null != aux && redBlackNode == aux.leftChild) {
                redBlackNode = aux;
                aux = aux.parent;
            }
            return aux;
        }
    }

    @Override
    public void treeInsert(RedBlackNode<T> newRedBlackNode) {
        RedBlackNode<T> rootTmp = this.root;
        RedBlackNode<T> findParent = NULL;
        while (null != rootTmp && NULL != rootTmp) {
            findParent = rootTmp;
            //Go to left child
            if (newRedBlackNode.key.compareTo(rootTmp.key) < 0) {
                rootTmp = rootTmp.leftChild;
            } else { //Go to right child
                rootTmp = rootTmp.rightChild;
            }
        }
        //Set founded parent
        newRedBlackNode.parent = findParent;
        //If node is root
        if (NULL == findParent) {
            this.root = newRedBlackNode;
        } else if (newRedBlackNode.key.compareTo(findParent.key) < 0) { //If newNode is left child of your parent
            findParent.leftChild = newRedBlackNode;
        } else { //If newNode is right child of your parent
            findParent.rightChild = newRedBlackNode;
        }
        newRedBlackNode.color = Color.RED;
        newRedBlackNode.leftChild = NULL;
        newRedBlackNode.rightChild = NULL;
        //fixup
        this.insertRecolorization(newRedBlackNode);
        this.countNodes++;
    }

    @Override
    public void treeDelete(RedBlackNode<T> redBlackNode) {
        RedBlackNode<T> deletedNode;
        RedBlackNode<T> aux = redBlackNode;
        Color deletedNodeColor = aux.color;
        if (NULL.equals(redBlackNode.leftChild)) {
            deletedNode = redBlackNode.rightChild;
            transplant(redBlackNode, redBlackNode.rightChild);
        } else if (NULL.equals(redBlackNode.rightChild)) {
            deletedNode = redBlackNode.leftChild;
            transplant(redBlackNode, redBlackNode.leftChild);
        } else {
            /* Two strategies:
                1 - Minimum of the right child (aux = treeMinimum(redBlackNode.rightChild)) ✅
                2 - Maximum ot the left child (aux = treeMaximum(redBlackNode.leftChild))
            */
            aux = treeMinimum(redBlackNode.rightChild);
            deletedNodeColor = aux.color;
            deletedNode = aux.rightChild;
            if (!aux.equals(redBlackNode.rightChild)) {
                transplant(aux, aux.rightChild);
                aux.rightChild = redBlackNode.rightChild;
                aux.rightChild.parent = aux;
            } else {
                deletedNode.parent = aux;
            }
            transplant(redBlackNode, aux);
            aux.leftChild = redBlackNode.leftChild;
            aux.leftChild.parent = aux;
            aux.color = redBlackNode.color;
        }

        if (Color.BLACK.equals(deletedNodeColor)) {
            deleteRecolorization(deletedNode);
        }
        this.countNodes--;
    }

    private void leftRotation(RedBlackNode<T> redBlackNode) {
        RedBlackNode<T> aux = redBlackNode.rightChild;
        redBlackNode.rightChild = aux.leftChild;
        if (!NULL.equals(aux.leftChild)) {
            aux.leftChild.parent = redBlackNode;
        }
        aux.parent = redBlackNode.parent;
        if (NULL.equals(redBlackNode.parent)) {
            this.root = aux;
        } else if (redBlackNode.equals(redBlackNode.parent.leftChild)) {
            redBlackNode.parent.leftChild = aux;
        } else {
            redBlackNode.parent.rightChild = aux;
        }
        aux.leftChild = redBlackNode;
        redBlackNode.parent = aux;
    }

    private void rightRotation(RedBlackNode<T> redBlackNode) {
        RedBlackNode<T> aux = redBlackNode.leftChild;
        redBlackNode.leftChild = aux.rightChild;
        if (!NULL.equals(aux.rightChild)) {
            aux.rightChild.parent = redBlackNode;
        }
        aux.parent = redBlackNode.parent;
        if (NULL.equals(redBlackNode.parent)) {
            this.root = aux;
        } else if (redBlackNode.equals(redBlackNode.parent.rightChild)) {
            redBlackNode.parent.rightChild = aux;
        } else {
            redBlackNode.parent.leftChild = aux;
        }
        aux.rightChild = redBlackNode;
        redBlackNode.parent = aux;
    }

    private void insertRecolorization(RedBlackNode<T> redBlackNode) {
        while (Color.RED.equals(redBlackNode.parent.color)) {
            if (redBlackNode.parent == redBlackNode.parent.parent.leftChild) {
                RedBlackNode<T> aux = redBlackNode.parent.parent.rightChild;
                if (Color.RED.equals(aux.color)) {
                    redBlackNode.parent.color = Color.BLACK;
                    aux.color = Color.BLACK;
                    redBlackNode.parent.parent.color = Color.RED;
                    redBlackNode = redBlackNode.parent.parent;
                } else {
                    if (redBlackNode.equals(redBlackNode.parent.rightChild)) {
                        redBlackNode = redBlackNode.parent;
                        this.leftRotation(redBlackNode);
                    }
                    redBlackNode.parent.color = Color.BLACK;
                    redBlackNode.parent.parent.color = Color.RED;
                    this.rightRotation(redBlackNode.parent.parent);
                }
            } else {
                RedBlackNode<T> aux = redBlackNode.parent.parent.leftChild;
                if (Color.RED.equals(aux.color)) {
                    redBlackNode.parent.color = Color.BLACK;
                    aux.color = Color.BLACK;
                    redBlackNode.parent.parent.color = Color.RED;
                    redBlackNode = redBlackNode.parent.parent;
                } else {
                    if (redBlackNode.equals(redBlackNode.parent.leftChild)) {
                        redBlackNode = redBlackNode.parent;
                        this.rightRotation(redBlackNode);
                    }
                    redBlackNode.parent.color = Color.BLACK;
                    redBlackNode.parent.parent.color = Color.RED;
                    this.leftRotation(redBlackNode.parent.parent);
                }
            }
        }
        this.root.color = Color.BLACK;
    }

    private void transplant(RedBlackNode<T> rootRedBlackNode, RedBlackNode<T> replaceRedBlackNode) {
        //When rootNode is the tree root node
        if (NULL.equals(rootRedBlackNode.parent)) {
            this.root = replaceRedBlackNode;
        } else if (rootRedBlackNode == rootRedBlackNode.parent.leftChild) { // Parent node of the rootNode set replaceNode to left child
            rootRedBlackNode.parent.leftChild = replaceRedBlackNode;
        } else { // Parent node of the rootNode set replaceNode to right child
            rootRedBlackNode.parent.rightChild = replaceRedBlackNode;
        }
        // Point to parent of the rootNode if replaceNode is not null ( subtree above of the rootNode)
        replaceRedBlackNode.parent = rootRedBlackNode.parent;
    }

    private void deleteRecolorization(RedBlackNode<T> redBlackNode) {
        while (!redBlackNode.equals(this.root) && Color.BLACK.equals(redBlackNode.color)) {
            if (redBlackNode.equals(redBlackNode.parent.leftChild)) {
                RedBlackNode<T> aux = redBlackNode.parent.rightChild;
                if (Color.RED.equals(aux.color)) {
                    aux.color = Color.BLACK;
                    redBlackNode.parent.color = Color.RED;
                    leftRotation(redBlackNode.parent);
                    aux = redBlackNode.parent.rightChild;
                }

                if (Color.BLACK.equals(aux.leftChild.color) && Color.BLACK.equals(aux.rightChild.color)) {
                    aux.color = Color.RED;
                    redBlackNode = redBlackNode.parent;
                } else {
                    if (Color.BLACK.equals(aux.rightChild.color)) {
                        aux.leftChild.color = Color.BLACK;
                        aux.color = Color.RED;
                        rightRotation(aux);
                        aux = redBlackNode.parent.rightChild;
                    }
                    aux.color = redBlackNode.parent.color;
                    redBlackNode.parent.color = Color.BLACK;
                    aux.rightChild.color = Color.BLACK;
                    leftRotation(redBlackNode.parent);
                    redBlackNode = this.root;
                }
            } else {
                RedBlackNode<T> aux = redBlackNode.parent.leftChild;
                if (Color.RED.equals(aux.color)) {
                    aux.color = Color.BLACK;
                    redBlackNode.parent.color = Color.RED;
                    rightRotation(redBlackNode.parent);
                    aux = redBlackNode.parent.leftChild;
                }

                if (Color.BLACK.equals(aux.rightChild.color) && Color.BLACK.equals(aux.leftChild.color)) {
                    aux.color = Color.RED;
                    redBlackNode = redBlackNode.parent;
                } else {
                    if (Color.BLACK.equals(aux.leftChild.color)) {
                        aux.rightChild.color = Color.BLACK;
                        aux.color = Color.RED;
                        leftRotation(aux);
                        aux = redBlackNode.parent.leftChild;
                    }
                    aux.color = redBlackNode.parent.color;
                    redBlackNode.parent.color = Color.BLACK;
                    aux.leftChild.color = Color.BLACK;
                    rightRotation(redBlackNode.parent);
                    redBlackNode = this.root;
                }
            }
        }
        redBlackNode.color = Color.BLACK;
    }
}
