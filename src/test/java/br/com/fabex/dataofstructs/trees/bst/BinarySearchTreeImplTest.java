package br.com.fabex.dataofstructs.trees.bst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeImplTest {

    @Test
    void treeSearchTestWhenNodeIsRootAndTreeIsEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        Node<Integer> searchedNode = ibst.treeSearch(ibst.root, -1);

        //Asserts
        Assertions.assertNull(searchedNode);
    }

    @Test
    void treeSearchTestWhenNodeIsRootAndTreeIsNotEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        Node<Integer> root = new Node<>(5);
        ibst.treeInsert(root);
        ibst.treeInsert(new Node<>(3));
        ibst.treeInsert(new Node<>(6));
        ibst.treeInsert(new Node<>(4));
        ibst.treeInsert(new Node<>(1));
        ibst.treeInsert(new Node<>(2));

        //Act
        Node<Integer> searchedNode = ibst.treeSearch(ibst.root, 5);

        //Asserts
        Assertions.assertNotNull(searchedNode);
        Assertions.assertEquals(root.getKey(), searchedNode.getKey());
        Assertions.assertEquals(5, searchedNode.getKey());
    }

    @Test
    void treeSearchTestWhenChildIsLeftTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(5));
        ibst.treeInsert(new Node<>(3));
        ibst.treeInsert(new Node<>(6));
        ibst.treeInsert(new Node<>(4));
        ibst.treeInsert(new Node<>(1));
        ibst.treeInsert(new Node<>(2));

        //Act
        Node<Integer> searchedNode = ibst.treeSearch(ibst.root, 1);

        //Asserts
        Assertions.assertNotNull(searchedNode);
        Assertions.assertEquals(1, searchedNode.getKey());
    }

    @Test
    void treeSearchTestWhenChildIsRightTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(5));
        ibst.treeInsert(new Node<>(3));
        ibst.treeInsert(new Node<>(6));
        ibst.treeInsert(new Node<>(4));
        ibst.treeInsert(new Node<>(1));
        ibst.treeInsert(new Node<>(2));

        //Act
        Node<Integer> searchedNode = ibst.treeSearch(ibst.root, 6);

        //Asserts
        Assertions.assertNotNull(searchedNode);
        Assertions.assertEquals(6, searchedNode.getKey());
    }

    @Test
    void treeInsertWhenInsertOnlyOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        Node<Integer> root = new Node<>(1);
        ibst.treeInsert(root);

        //Asserts
        Assertions.assertNotNull(ibst.getRoot());
        Assertions.assertEquals(root.getKey(), ibst.getRoot().getKey());
        Assertions.assertEquals(1, ibst.getCountNodes());
    }

    @Test
    void treeInsertWhenInsertMoreTheOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        Node<Integer> root = new Node<>(5);

        //Act
        ibst.treeInsert(root);
        ibst.treeInsert(new Node<>(3));
        ibst.treeInsert(new Node<>(6));
        ibst.treeInsert(new Node<>(4));
        ibst.treeInsert(new Node<>(1));
        ibst.treeInsert(new Node<>(2));

        //Asserts
        Assertions.assertNotNull(ibst.getRoot());
        Assertions.assertEquals(new Node<>(5).getKey(), ibst.getRoot().getKey());
        Assertions.assertEquals(6, ibst.getCountNodes());
    }
}