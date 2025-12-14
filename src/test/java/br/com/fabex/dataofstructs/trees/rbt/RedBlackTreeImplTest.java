package br.com.fabex.dataofstructs.trees.rbt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class RedBlackTreeImplTest {

    private RedBlackTreeImpl<Integer> irbt;

    @BeforeEach
    void setUp() {
        irbt = new RedBlackTreeImpl<>();
    }

    @Test
    @DisplayName("Should delete root node when it has no left child")
    void shouldDeleteRootNodeWithoutLeftChild() {
        //Arrange
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

    @Test
    @DisplayName("Should insert multiple nodes into red-black tree maintaining balance properties and color constraints")
    void shouldInsertNodesIntoRedBlackTree() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();

        //Act
        irbt.treeInsert(new RedBlackNode<>(10));
        irbt.treeInsert(new RedBlackNode<>(20));
        irbt.treeInsert(new RedBlackNode<>(30));
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(25));
        irbt.treeInsert(new RedBlackNode<>(70));
        irbt.treeInsert(new RedBlackNode<>(75));

        //Asserts
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 70);
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(30, searched.parent.key);
        Assertions.assertEquals(25, searched.parent.leftChild.key);
        Assertions.assertEquals(irbt.NULL, searched.leftChild);
        Assertions.assertEquals(75, searched.rightChild.key);
    }

    @Test
    @DisplayName("Should delete nodes from red-black tree while maintaining balance properties and structural integrity")
    void shouldDeleteNodesFromRedBlackTree() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();

        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));
        irbt.treeInsert(new RedBlackNode<>(7));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(13);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(9));
        irbt.treeInsert(new RedBlackNode<>(18));
        irbt.treeInsert(new RedBlackNode<>(17));
        irbt.treeInsert(new RedBlackNode<>(20));

        //Act
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 13));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 15);
        Assertions.assertEquals(irbt.root, searched);
        Assertions.assertEquals(6, searched.leftChild.key);
        Assertions.assertEquals(18, searched.rightChild.key);

    }

    @Test
    @DisplayName("Should delete black leaf node on right side with red sibling requiring right rotation to maintain balance")
    void shouldDeleteBlackLeafNodeOnRightWithRedSibling() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(30));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(31);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(22));
        irbt.treeInsert(new RedBlackNode<>(17));
        irbt.treeInsert(new RedBlackNode<>(18));
        irbt.treeInsert(new RedBlackNode<>(15));

        //Act
        irbt.treeDelete(deletedRedBlackNode);

        Assertions.assertNull(irbt.treeSearch(irbt.root, 31));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 18);
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(irbt.root, searched);

        Assertions.assertEquals(17, searched.leftChild.key);
        Assertions.assertEquals(Color.BLACK, searched.leftChild.color);
        Assertions.assertEquals(30, searched.rightChild.key);
        Assertions.assertEquals(Color.BLACK, searched.rightChild.color);
    }

    @Test
    @DisplayName("Should delete black non-leaf node on right side with red sibling requiring right rotation and rebalancing")
    void shouldDeleteBlackNonLeafNodeOnRightWithRedSibling() {
        //Arrange
        int[] array = new int[]{60, 129, 253, 276, 109, 27, 180, 19};
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();

        for (int i : array) {
            irbt.treeInsert(new RedBlackNode<>(i));
        }

        //Act
        int index = 4; // [4] -> 109
        RedBlackNode<Integer> deletedRedBlackNode = irbt.treeSearch(irbt.root, array[index]);
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, array[index]));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 27);
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(129, searched.parent.key);
        Assertions.assertEquals(Color.RED, searched.color);
        Assertions.assertEquals(253, searched.parent.rightChild.key);
        Assertions.assertEquals(Color.BLACK, searched.parent.rightChild.color);
        Assertions.assertEquals(19, searched.leftChild.key);
        Assertions.assertEquals(Color.BLACK, searched.leftChild.color);
        Assertions.assertEquals(60, searched.rightChild.key);
        Assertions.assertEquals(Color.BLACK, searched.rightChild.color);
    }

    @Test
    @DisplayName("Should delete root node while maintaining all red-black tree properties and selecting appropriate successor")
    void shouldDeleteRootNodeMaintainingProperties() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        int[] array = new int[]{254, 30, 61, 271, 2, 52, 163, 207};

        for (int i : array) {
            irbt.treeInsert(new RedBlackNode<>(i));
        }

        //Act
        int index = 0; // [0] -> 254
        RedBlackNode<Integer> deletedRedBlackNode = irbt.treeSearch(irbt.root, array[index]);
        irbt.treeDelete(deletedRedBlackNode);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, array[index]));
        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 207);
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(61, searched.parent.key);
        Assertions.assertEquals(Color.RED, searched.color);
        Assertions.assertEquals(30, searched.parent.leftChild.key);
        Assertions.assertEquals(Color.BLACK, searched.parent.leftChild.color);
        Assertions.assertEquals(163, searched.leftChild.key);
        Assertions.assertEquals(Color.BLACK, searched.leftChild.color);
        Assertions.assertEquals(271, searched.rightChild.key);
        Assertions.assertEquals(Color.BLACK, searched.rightChild.color);
    }
}