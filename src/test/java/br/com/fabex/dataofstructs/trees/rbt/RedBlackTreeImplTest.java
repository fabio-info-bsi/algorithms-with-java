package br.com.fabex.dataofstructs.trees.rbt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RedBlackTreeImplTest {
    private static final Logger logger = LoggerFactory.getLogger(RedBlackTreeImplTest.class);

    @Test
    @DisplayName("Should delete root node when it has no left child")
    void shouldDeleteRootNodeWithoutLeftChild() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(15);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(17));

        //Act
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 15));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 17);
        Assertions.assertEquals(irbt.root, searched);
    }

    @Test
    @DisplayName("Should delete root node when it has no right child")
    void shouldDeleteRootNodeWithoutRightChild() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(15);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(6));

        //Act
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 15));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 6);
        Assertions.assertEquals(irbt.root, searched);
    }

    @Test
    @DisplayName("Should delete non-root node when it has no left child")
    void shouldDeleteNonRootNodeWithoutLeftChild() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(7);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(13));
        irbt.treeInsert(new RedBlackNode<>(9));
        irbt.treeInsert(new RedBlackNode<>(18));
        irbt.treeInsert(new RedBlackNode<>(17));
        irbt.treeInsert(new RedBlackNode<>(20));

        //Act
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 7));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 6);
        Assertions.assertEquals(9, searched.rightChild.key);
        Assertions.assertEquals(irbt.NULL, searched.rightChild.leftChild);
    }

    @Test
    @DisplayName("Should delete non-root node when it has no right child")
    void shouldDeleteNonRootNodeWithoutRightChild() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(2);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(4));
        irbt.treeInsert(new RedBlackNode<>(1));

        //Act
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 2));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 3);
        Assertions.assertEquals(1, searched.leftChild.key);
        Assertions.assertEquals(irbt.NULL, searched.leftChild.leftChild);
        Assertions.assertEquals(irbt.NULL, searched.leftChild.rightChild);
    }

    @Test
    @DisplayName("Should delete non-root node with both children when minimum successor is right child")
    void shouldDeleteNonRootNodeWithBothChildrenMinimumIsRightChild() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(3);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));

        //Act
        irbt.treeDelete(deletedRedBlackNode);
        irbt.breadthFirstTreeWalk(irbt.root);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 3));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 4);
        Assertions.assertEquals(2, searched.leftChild.key);
        Assertions.assertEquals(irbt.NULL, searched.rightChild);

    }

    @Test
    @DisplayName("Should delete non-root node with both children when minimum successor is not right child")
    void shouldDeleteNonRootNodeWithBothChildrenMinimumIsNotRightChild() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(20));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(8);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(25));
        irbt.treeInsert(new RedBlackNode<>(10));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(28));
        irbt.treeInsert(new RedBlackNode<>(9));

        //Act
        irbt.treeDelete(deletedRedBlackNode);
        irbt.breadthFirstTreeWalk(irbt.root);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 3));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 9);
        Assertions.assertEquals(6, searched.leftChild.key);
        Assertions.assertEquals(10, searched.rightChild.key);

    }

    @Test
    @DisplayName("Should delete black non-root node and perform recolorization to maintain tree properties")
    void shouldDeleteBlackNonRootNodeAndPerformRecolorization() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(20));
        irbt.treeInsert(new RedBlackNode<>(8));
        irbt.treeInsert(new RedBlackNode<>(25));

        irbt.treeInsert(new RedBlackNode<>(10));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(6);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(28));
        irbt.treeInsert(new RedBlackNode<>(9));

        //Act
        irbt.breadthFirstTreeWalk(irbt.root);
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 6));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 9);
        Assertions.assertEquals(8, searched.leftChild.key);
        Assertions.assertEquals(10, searched.rightChild.key);

    }

    @Test
    @DisplayName("Should delete black leaf node on left with red sibling requiring left rotation and recolorization")
    void shouldDeleteBlackLeafNodeOnLeftWithRedSiblingAndRecolorization() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(20));
        irbt.treeInsert(new RedBlackNode<>(8));
        irbt.treeInsert(new RedBlackNode<>(25));
        irbt.treeInsert(new RedBlackNode<>(10));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(28));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(9);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(30));
        irbt.treeInsert(new RedBlackNode<>(31));
        irbt.treeInsert(new RedBlackNode<>(5));
        irbt.treeInsert(new RedBlackNode<>(4));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(7));
        irbt.treeInsert(new RedBlackNode<>(11));
        irbt.treeInsert(new RedBlackNode<>(12));
        irbt.treeInsert(new RedBlackNode<>(23));
        irbt.treeInsert(new RedBlackNode<>(13));
        irbt.treeInsert(new RedBlackNode<>(14));

        //Act
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 9));
    }

    @Test
    @DisplayName("Should find node when it exists in the tree")
    void shouldFindExistingNode() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));

        //Act
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 2);

        //Asserts
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(2, searched.key);
    }

    @Test
    @DisplayName("Should return null when searching for non-existing node")
    void shouldReturnNullForNonExistingNode() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));

        //Act
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 50);

        //Asserts
        Assertions.assertNull(searched);
    }

    @Test
    @DisplayName("Should find root node when searching for it")
    void shouldFindRootNode() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));

        //Act
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 15);

        //Asserts
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(15, searched.key);
    }

    @Test
    @DisplayName("Should return null when searching in empty tree")
    void shouldReturnNullInEmptyTree() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();

        //Act
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 15);

        //Asserts
        Assertions.assertNull(searched);
    }
}