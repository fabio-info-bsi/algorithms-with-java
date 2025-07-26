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

    @Test
    void treeMinimumWhenTreeIsEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        Node<Integer> searchedMinimum = ibst.treeMinimum(ibst.root);

        //Asserts
        Assertions.assertNull(searchedMinimum);
        Assertions.assertEquals(0, ibst.getCountNodes());
    }

    @Test
    void treeMinimumWhenThereIsOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(5));

        //Act
        Node<Integer> searchedMinimum = ibst.treeMinimum(ibst.root);

        //Asserts
        Assertions.assertNotNull(searchedMinimum);
        Assertions.assertEquals(new Node<>(5).getKey(), searchedMinimum.getKey());
        Assertions.assertEquals(1, ibst.getCountNodes());
    }

    @Test
    void treeMinimumWhenThereIsMoreTheOneNodeTest() {
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
        Node<Integer> searchedMinimum = ibst.treeMinimum(ibst.root);

        //Asserts
        Assertions.assertNotNull(searchedMinimum);
        Assertions.assertEquals(new Node<>(1).getKey(), searchedMinimum.getKey());
    }

    @Test
    void treeMaximumWhenTreeIsEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        Node<Integer> searchedMaximum = ibst.treeMaximum(ibst.root);

        //Asserts
        Assertions.assertNull(searchedMaximum);
        Assertions.assertEquals(0, ibst.getCountNodes());
    }

    @Test
    void treeMaximumWhenThereIsOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(5));

        //Act
        Node<Integer> searchedMaximum = ibst.treeMaximum(ibst.root);

        //Asserts
        Assertions.assertNotNull(searchedMaximum);
        Assertions.assertEquals(new Node<>(5).getKey(), searchedMaximum.getKey());
        Assertions.assertEquals(1, ibst.getCountNodes());
    }

    @Test
    void treeMaximumWhenThereIsMoreTheOneNodeTest() {
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
        Node<Integer> searchedMaximum = ibst.treeMaximum(ibst.root);

        //Asserts
        Assertions.assertNotNull(searchedMaximum);
        Assertions.assertEquals(new Node<>(6).getKey(), searchedMaximum.getKey());
    }

    @Test
    void treeSuccessorWhenNodeIsRootTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(15));
        Node<Integer> nodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        Node<Integer> nodePredecessor = ibst.treeSuccessor(nodeSearched);

        //Asserts
        Assertions.assertNotNull(nodeSearched);
        Assertions.assertEquals(new Node<>(15).getKey(), nodeSearched.getKey());
        Assertions.assertNull(nodePredecessor);
    }

    @Test
    void treeSuccessorWhenNodeDontHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(15));
        ibst.treeInsert(new Node<>(6));
        ibst.treeInsert(new Node<>(3));
        ibst.treeInsert(new Node<>(2));
        ibst.treeInsert(new Node<>(4));
        ibst.treeInsert(new Node<>(7));
        ibst.treeInsert(new Node<>(13));
        ibst.treeInsert(new Node<>(9));
        ibst.treeInsert(new Node<>(18));
        ibst.treeInsert(new Node<>(17));
        ibst.treeInsert(new Node<>(20));
        Node<Integer> nodeSearched = ibst.treeSearch(ibst.root, 13);

        //Act
        Node<Integer> nodePredecessor = ibst.treeSuccessor(nodeSearched);

        //Asserts
        Assertions.assertNotNull(nodeSearched);
        Assertions.assertEquals(new Node<>(13).getKey(), nodeSearched.getKey());
        Assertions.assertNotNull(nodePredecessor);
        Assertions.assertEquals(new Node<>(15).getKey(), nodePredecessor.getKey());
    }

    @Test
    void treeSuccessorWhenNodeHaveRightChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(15));
        ibst.treeInsert(new Node<>(6));
        ibst.treeInsert(new Node<>(3));
        ibst.treeInsert(new Node<>(2));
        ibst.treeInsert(new Node<>(4));
        ibst.treeInsert(new Node<>(7));
        ibst.treeInsert(new Node<>(13));
        ibst.treeInsert(new Node<>(9));
        ibst.treeInsert(new Node<>(18));
        ibst.treeInsert(new Node<>(17));
        ibst.treeInsert(new Node<>(20));
        Node<Integer> nodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        Node<Integer> nodePredecessor = ibst.treeSuccessor(nodeSearched);

        //Asserts
        Assertions.assertNotNull(nodeSearched);
        Assertions.assertEquals(new Node<>(15).getKey(), nodeSearched.getKey());
        Assertions.assertNotNull(nodePredecessor);
        Assertions.assertEquals(new Node<>(17).getKey(), nodePredecessor.getKey());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsRootAndHaveRightChildAndDontHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(15));
        ibst.treeInsert(new Node<>(18));
        ibst.treeInsert(new Node<>(17));
        ibst.treeInsert(new Node<>(20));
        Node<Integer> nodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        ibst.treeDelete(nodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 15));
        Assertions.assertEquals(new Node<>(18).getKey(), ibst.getRoot().getKey());
        Assertions.assertEquals(3, ibst.getCountNodes());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsRootAndDontHaveRightChildAndHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new Node<>(15));
        ibst.treeInsert(new Node<>(6));
        ibst.treeInsert(new Node<>(3));
        ibst.treeInsert(new Node<>(2));
        ibst.treeInsert(new Node<>(4));
        ibst.treeInsert(new Node<>(7));
        ibst.treeInsert(new Node<>(13));
        ibst.treeInsert(new Node<>(9));
        Node<Integer> nodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        ibst.treeDelete(nodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 15));
        Assertions.assertEquals(new Node<>(6).getKey(), ibst.getRoot().getKey());
        Assertions.assertEquals(7, ibst.getCountNodes());
    }
}