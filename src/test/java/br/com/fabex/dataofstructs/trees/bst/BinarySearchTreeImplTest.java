package br.com.fabex.dataofstructs.trees.bst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTreeImplTest {

    @Test
    void treeSearchWhenNodeIsRootAndTreeIsEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        BinarySearchNode<Integer> searchedBinarySearchNode = ibst.treeSearch(ibst.root, -1);

        //Asserts
        Assertions.assertNull(searchedBinarySearchNode);
    }

    @Test
    void treeSearchWhenNodeIsRootAndTreeIsNotEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        BinarySearchNode<Integer> root = new BinarySearchNode<>(5);
        ibst.treeInsert(root);
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Act
        BinarySearchNode<Integer> searchedBinarySearchNode = ibst.treeSearch(ibst.root, 5);

        //Asserts
        Assertions.assertNotNull(searchedBinarySearchNode);
        Assertions.assertEquals(root.getKey(), searchedBinarySearchNode.getKey());
        Assertions.assertEquals(5, searchedBinarySearchNode.getKey());
    }

    @Test
    void treeSearchWhenChildIsLeftTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(5));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Act
        BinarySearchNode<Integer> searchedBinarySearchNode = ibst.treeSearch(ibst.root, 1);

        //Asserts
        Assertions.assertNotNull(searchedBinarySearchNode);
        Assertions.assertEquals(1, searchedBinarySearchNode.getKey());
    }

    @Test
    void treeSearchWhenChildIsRightTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(5));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Act
        BinarySearchNode<Integer> searchedBinarySearchNode = ibst.treeSearch(ibst.root, 6);

        //Asserts
        Assertions.assertNotNull(searchedBinarySearchNode);
        Assertions.assertEquals(6, searchedBinarySearchNode.getKey());
    }

    @Test
    void iterativeTreeSearchWhenNodeIsRootAndTreeIsEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        BinarySearchNode<Integer> searchedBinarySearchNode = ibst.iterativeTreeSearch(ibst.root, -1);

        //Asserts
        Assertions.assertNull(searchedBinarySearchNode);
    }

    @Test
    void iterativeTreeSearchWhenNodeIsRootAndTreeIsNotEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        BinarySearchNode<Integer> root = new BinarySearchNode<>(5);
        ibst.treeInsert(root);
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Act
        BinarySearchNode<Integer> searchedBinarySearchNode = ibst.iterativeTreeSearch(ibst.root, 5);

        //Asserts
        Assertions.assertNotNull(searchedBinarySearchNode);
        Assertions.assertEquals(root.getKey(), searchedBinarySearchNode.getKey());
        Assertions.assertEquals(5, searchedBinarySearchNode.getKey());
    }

    @Test
    void iterativeTreeSearchWhenChildIsLeftTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(5));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Act
        BinarySearchNode<Integer> searchedBinarySearchNode = ibst.iterativeTreeSearch(ibst.root, 1);

        //Asserts
        Assertions.assertNotNull(searchedBinarySearchNode);
        Assertions.assertEquals(1, searchedBinarySearchNode.getKey());
    }

    @Test
    void iterativeTreeSearchWhenChildIsRightTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(5));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Act
        BinarySearchNode<Integer> searchedBinarySearchNode = ibst.iterativeTreeSearch(ibst.root, 6);

        //Asserts
        Assertions.assertNotNull(searchedBinarySearchNode);
        Assertions.assertEquals(6, searchedBinarySearchNode.getKey());
    }

    @Test
    void treeInsertWhenInsertOnlyOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        BinarySearchNode<Integer> root = new BinarySearchNode<>(1);
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
        BinarySearchNode<Integer> root = new BinarySearchNode<>(5);

        //Act
        ibst.treeInsert(root);
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Asserts
        Assertions.assertNotNull(ibst.getRoot());
        Assertions.assertEquals(new BinarySearchNode<>(5).getKey(), ibst.getRoot().getKey());
        Assertions.assertEquals(6, ibst.getCountNodes());
    }

    @Test
    void treeMinimumWhenTreeIsEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        BinarySearchNode<Integer> searchedMinimum = ibst.treeMinimum(ibst.root);

        //Asserts
        Assertions.assertNull(searchedMinimum);
        Assertions.assertEquals(0, ibst.getCountNodes());
    }

    @Test
    void treeMinimumWhenThereIsOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(5));

        //Act
        BinarySearchNode<Integer> searchedMinimum = ibst.treeMinimum(ibst.root);

        //Asserts
        Assertions.assertNotNull(searchedMinimum);
        Assertions.assertEquals(new BinarySearchNode<>(5).getKey(), searchedMinimum.getKey());
        Assertions.assertEquals(1, ibst.getCountNodes());
    }

    @Test
    void treeMinimumWhenThereIsMoreTheOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        BinarySearchNode<Integer> root = new BinarySearchNode<>(5);
        ibst.treeInsert(root);
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Act
        BinarySearchNode<Integer> searchedMinimum = ibst.treeMinimum(ibst.root);

        //Asserts
        Assertions.assertNotNull(searchedMinimum);
        Assertions.assertEquals(new BinarySearchNode<>(1).getKey(), searchedMinimum.getKey());
    }

    @Test
    void treeMaximumWhenTreeIsEmptyTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();

        //Act
        BinarySearchNode<Integer> searchedMaximum = ibst.treeMaximum(ibst.root);

        //Asserts
        Assertions.assertNull(searchedMaximum);
        Assertions.assertEquals(0, ibst.getCountNodes());
    }

    @Test
    void treeMaximumWhenThereIsOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(5));

        //Act
        BinarySearchNode<Integer> searchedMaximum = ibst.treeMaximum(ibst.root);

        //Asserts
        Assertions.assertNotNull(searchedMaximum);
        Assertions.assertEquals(new BinarySearchNode<>(5).getKey(), searchedMaximum.getKey());
        Assertions.assertEquals(1, ibst.getCountNodes());
    }

    @Test
    void treeMaximumWhenThereIsMoreTheOneNodeTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        BinarySearchNode<Integer> root = new BinarySearchNode<>(5);
        ibst.treeInsert(root);
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(1));
        ibst.treeInsert(new BinarySearchNode<>(2));

        //Act
        BinarySearchNode<Integer> searchedMaximum = ibst.treeMaximum(ibst.root);

        //Asserts
        Assertions.assertNotNull(searchedMaximum);
        Assertions.assertEquals(new BinarySearchNode<>(6).getKey(), searchedMaximum.getKey());
    }

    @Test
    void treeSuccessorWhenNodeIsRootTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        BinarySearchNode<Integer> binarySearchNodePredecessor = ibst.treeSuccessor(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNotNull(binarySearchNodeSearched);
        Assertions.assertEquals(new BinarySearchNode<>(15).getKey(), binarySearchNodeSearched.getKey());
        Assertions.assertNull(binarySearchNodePredecessor);
    }

    @Test
    void treeSuccessorWhenNodeDontHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 13);

        //Act
        BinarySearchNode<Integer> binarySearchNodePredecessor = ibst.treeSuccessor(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNotNull(binarySearchNodeSearched);
        Assertions.assertEquals(new BinarySearchNode<>(13).getKey(), binarySearchNodeSearched.getKey());
        Assertions.assertNotNull(binarySearchNodePredecessor);
        Assertions.assertEquals(new BinarySearchNode<>(15).getKey(), binarySearchNodePredecessor.getKey());
    }

    @Test
    void treeSuccessorWhenNodeHaveRightChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        BinarySearchNode<Integer> binarySearchNodePredecessor = ibst.treeSuccessor(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNotNull(binarySearchNodeSearched);
        Assertions.assertEquals(new BinarySearchNode<>(15).getKey(), binarySearchNodeSearched.getKey());
        Assertions.assertNotNull(binarySearchNodePredecessor);
        Assertions.assertEquals(new BinarySearchNode<>(17).getKey(), binarySearchNodePredecessor.getKey());
    }

    @Test
    void treePredecessorWhenNodeIsRootTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        BinarySearchNode<Integer> binarySearchNodePredecessor = ibst.treePredecessor(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNotNull(binarySearchNodeSearched);
        Assertions.assertEquals(new BinarySearchNode<>(15).getKey(), binarySearchNodeSearched.getKey());
        Assertions.assertNull(binarySearchNodePredecessor);
    }

    @Test
    void treePredecessorWhenNodeDontHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 6);

        //Act
        BinarySearchNode<Integer> binarySearchNodePredecessor = ibst.treePredecessor(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNotNull(binarySearchNodeSearched);
        Assertions.assertEquals(new BinarySearchNode<>(6).getKey(), binarySearchNodeSearched.getKey());
        Assertions.assertNotNull(binarySearchNodePredecessor);
        Assertions.assertEquals(new BinarySearchNode<>(4).getKey(), binarySearchNodePredecessor.getKey());
    }

    @Test
    void treePredecessorWhenNodeHaveRightChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 9);

        //Act
        BinarySearchNode<Integer> binarySearchNodePredecessor = ibst.treePredecessor(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNotNull(binarySearchNodeSearched);
        Assertions.assertEquals(new BinarySearchNode<>(9).getKey(), binarySearchNodeSearched.getKey());
        Assertions.assertNotNull(binarySearchNodePredecessor);
        Assertions.assertEquals(new BinarySearchNode<>(7).getKey(), binarySearchNodePredecessor.getKey());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsRootAndHaveRightChildAndHaveLeftChildAndNodeMinimumIsNotRightChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        ibst.treeDelete(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 15));
        Assertions.assertEquals(new BinarySearchNode<>(17).getKey(), ibst.root.getKey());
        Assertions.assertEquals(new BinarySearchNode<>(18).getKey(), ibst.root.getRightChild().getKey());
        Assertions.assertEquals(new BinarySearchNode<>(6).getKey(), ibst.root.getLeftChild().getKey());
        Assertions.assertEquals(10, ibst.getCountNodes());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsRootAndHaveRightChildAndDontHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        ibst.treeDelete(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 15));
        Assertions.assertEquals(new BinarySearchNode<>(18).getKey(), ibst.root.getKey());
        Assertions.assertEquals(new BinarySearchNode<>(17).getKey(), ibst.root.getLeftChild().getKey());
        Assertions.assertEquals(new BinarySearchNode<>(20).getKey(), ibst.root.getRightChild().getKey());
        Assertions.assertEquals(3, ibst.getCountNodes());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsRootAndHaveRightChildAndHaveLeftChildAndNodeMinimumIsRightChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        ibst.treeDelete(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 15));
        Assertions.assertEquals(new BinarySearchNode<>(17).getKey(), ibst.root.getKey());
        Assertions.assertEquals(new BinarySearchNode<>(20).getKey(), ibst.root.getRightChild().getKey());
        Assertions.assertEquals(new BinarySearchNode<>(6).getKey(), ibst.root.getLeftChild().getKey());
        Assertions.assertEquals(5, ibst.getCountNodes());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsRootAndDontHaveRightChildAndHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 15);

        //Act
        ibst.treeDelete(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 15));
        Assertions.assertEquals(new BinarySearchNode<>(6).getKey(), ibst.getRoot().getKey());
        Assertions.assertEquals(7, ibst.getCountNodes());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsNotRootAndDontHaveRightChildAndHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 13);

        //Act
        ibst.treeDelete(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 13));
        Assertions.assertEquals(new BinarySearchNode<>(9).getKey(), ibst.treeSearch(ibst.root, 7).getRightChild().getKey());
        Assertions.assertEquals(10, ibst.getCountNodes());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsNotRootAndHaveRightChildAndDontHaveLeftChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 7);

        //Act
        ibst.treeDelete(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 7));
        Assertions.assertEquals(new BinarySearchNode<>(13).getKey(), ibst.treeSearch(ibst.root, 6).getRightChild().getKey());
        Assertions.assertEquals(10, ibst.getCountNodes());
    }

    @Test
    void treeDeleteWhenNodeDeletedIsNotRootAndHaveRightChildAndHaveLeftChildAndNodeMinimumIsNotRightChildTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));
        BinarySearchNode<Integer> binarySearchNodeSearched = ibst.treeSearch(ibst.root, 6);

        //Act
        ibst.treeDelete(binarySearchNodeSearched);

        //Asserts
        Assertions.assertNull(ibst.treeSearch(ibst.root, 6));
        Assertions.assertEquals(new BinarySearchNode<>(7).getKey(), ibst.root.getLeftChild().getKey());
        Assertions.assertEquals(10, ibst.getCountNodes());
    }

    @Test
    void inOrderTreeWalkTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> ibst.inOrderTreeWalk(ibst.root));
    }

    @Test
    void preOrderTreeWalkTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> ibst.preOrderTreeWalk(ibst.root));
    }

    @Test
    void posOrderTreeWalkTest() {
        //Arrange
        BinarySearchTreeImpl<Integer> ibst = new BinarySearchTreeImpl<>();
        ibst.treeInsert(new BinarySearchNode<>(15));
        ibst.treeInsert(new BinarySearchNode<>(6));
        ibst.treeInsert(new BinarySearchNode<>(3));
        ibst.treeInsert(new BinarySearchNode<>(2));
        ibst.treeInsert(new BinarySearchNode<>(4));
        ibst.treeInsert(new BinarySearchNode<>(7));
        ibst.treeInsert(new BinarySearchNode<>(13));
        ibst.treeInsert(new BinarySearchNode<>(9));
        ibst.treeInsert(new BinarySearchNode<>(18));
        ibst.treeInsert(new BinarySearchNode<>(17));
        ibst.treeInsert(new BinarySearchNode<>(20));

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> ibst.posOrderTreeWalk(ibst.root));
    }
}