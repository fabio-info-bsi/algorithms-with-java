package br.com.fabex.dataofstructs.trees.rbt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RedBlackTreeImplTest {
    private static final Logger logger = LoggerFactory.getLogger(RedBlackTreeImplTest.class);

    @Test
    void treeInsert() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
//        irbt.treeInsert(new RedBlackNode<>(15));
//        irbt.treeInsert(new RedBlackNode<>(6));
//        irbt.treeInsert(new RedBlackNode<>(3));
//        irbt.treeInsert(new RedBlackNode<>(2));
//        irbt.treeInsert(new RedBlackNode<>(4));
//        irbt.treeInsert(new RedBlackNode<>(7));
//        irbt.treeInsert(new RedBlackNode<>(13));
//        irbt.treeInsert(new RedBlackNode<>(9));
//        irbt.treeInsert(new RedBlackNode<>(18));
//        irbt.treeInsert(new RedBlackNode<>(17));
//        irbt.treeInsert(new RedBlackNode<>(20));

//        irbt.treeInsert(new RedBlackNode<>(10));
//        irbt.treeInsert(new RedBlackNode<>(20));
//        irbt.treeInsert(new RedBlackNode<>(30));
//        irbt.treeInsert(new RedBlackNode<>(15));
//        irbt.treeInsert(new RedBlackNode<>(25));
//        irbt.treeInsert(new RedBlackNode<>(70));
//        irbt.treeInsert(new RedBlackNode<>(75));
//        irbt.treeInsert(new RedBlackNode<>(78));
//        irbt.treeInsert(new RedBlackNode<>(1));
//        irbt.treeInsert(new RedBlackNode<>(4));

        //Balanceada, mas veja bem ...
        irbt.treeInsert(new RedBlackNode<>(10));
        irbt.treeInsert(new RedBlackNode<>(20));
        irbt.treeInsert(new RedBlackNode<>(30));
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(25));
        irbt.treeInsert(new RedBlackNode<>(70));
        irbt.treeInsert(new RedBlackNode<>(75));

        irbt.inOrderTreeWalk(irbt.root);
    }

    @Test
    void treeDelete() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
//        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(10);
//        irbt.treeInsert(deletedRedBlackNode);
//        irbt.treeInsert(new RedBlackNode<>(20));
//        irbt.treeInsert(new RedBlackNode<>(30));
//        irbt.treeInsert(new RedBlackNode<>(15));
//        irbt.treeInsert(new RedBlackNode<>(25));
//        irbt.treeInsert(new RedBlackNode<>(70));
//        irbt.treeInsert(new RedBlackNode<>(75));

//        irbt.treeInsert(new RedBlackNode<>(10));
//        irbt.treeInsert(new RedBlackNode<>(20));
//        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(30);
//        irbt.treeInsert(deletedRedBlackNode);
//        irbt.treeInsert(new RedBlackNode<>(15));
//        irbt.treeInsert(new RedBlackNode<>(25));
//        irbt.treeInsert(new RedBlackNode<>(70));
//        irbt.treeInsert(new RedBlackNode<>(75));

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

        //irbt.breadthFirstTreeWalk(irbt.root);

        irbt.treeDelete(deletedRedBlackNode);

        irbt.breadthFirstTreeWalk(irbt.root);
        irbt.inOrderTreeWalk(irbt.root);
    }

    @Test
        // Quando nó removido tem pai e está a esquerda, é folha, é BLACK, tem irmão e seu irmão é RED e tem rotação para esquerda
    void treeDeleteDeletandoFolha() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(7);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(13));
        irbt.treeInsert(new RedBlackNode<>(9));
        irbt.treeInsert(new RedBlackNode<>(18));
        irbt.treeInsert(new RedBlackNode<>(17));
        irbt.treeInsert(new RedBlackNode<>(20));

        irbt.breadthFirstTreeWalk(irbt.root);
        irbt.treeDelete(deletedRedBlackNode);
        logger.debug("after remove node {}", deletedRedBlackNode);


        irbt.breadthFirstTreeWalk(irbt.root);
        //irbt.inOrderTreeWalk(irbt.root);
    }

    @Test
        // Quando nó removido tem pai e está a direita, é folha, é BLACK, tem irmão e seu irmão é RED e tem rotação para direita
    void treeDeleteDeletandoFolha2() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(30));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(31);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(22));
        irbt.treeInsert(new RedBlackNode<>(17));
        irbt.treeInsert(new RedBlackNode<>(18));
        irbt.treeInsert(new RedBlackNode<>(15));

        irbt.breadthFirstTreeWalk(irbt.root);
        irbt.treeDelete(deletedRedBlackNode);
        logger.debug("after remove node {}", deletedRedBlackNode);


        irbt.breadthFirstTreeWalk(irbt.root);
        //irbt.inOrderTreeWalk(irbt.root);
    }

    @Test
        // Quando nó removido tem pai e está a direita, não é folha, é BLACK, tem irmão e seu irmão é RED e tem rotação para direita
    void treeDeleteDeletando3() {
        //Arrange
        //10, 5, 15, 2, 7, 12, 17, 13
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(10));
        irbt.treeInsert(new RedBlackNode<>(5));
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(2));
        RedBlackNode<Integer> deletedRedBlackNode = new RedBlackNode<>(7);
        irbt.treeInsert(deletedRedBlackNode);
        irbt.treeInsert(new RedBlackNode<>(12));
        irbt.treeInsert(new RedBlackNode<>(17));
        irbt.treeInsert(new RedBlackNode<>(13));

        irbt.breadthFirstTreeWalk(irbt.root);
        irbt.treeDelete(deletedRedBlackNode);
        logger.debug("after remove node {}", deletedRedBlackNode);


        irbt.breadthFirstTreeWalk(irbt.root);
        //irbt.inOrderTreeWalk(irbt.root);
    }

    @Test
    void testPrintTree() {
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(10));
        irbt.treeInsert(new RedBlackNode<>(20));
        irbt.treeInsert(new RedBlackNode<>(30));
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(25));
        irbt.treeInsert(new RedBlackNode<>(70));
        irbt.treeInsert(new RedBlackNode<>(75));

        //irbt.printTree(irbt.root, 0);

    }

    @Test
    void treeDeleteWhenNodeDeletedIsRootAndDontHaveLeftChildTest() {
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
    void treeDeleteWhenNodeDeletedIsRootAndDontHaveRightChildTest() {
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
    void treeDeleteWhenNodeDeletedIsNotRootAndDontHaveLeftChildTest() {
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
    void treeDeleteWhenNodeDeletedIsNotRootAndDontHaveRightChildTest() {
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
    void treeDeleteWhenNodeDeletedIsNotRootAndHaveRightChildAndHaveLeftChildAndNodeMinimumIsRightChildTest() {
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
    void treeDeleteWhenNodeDeletedIsNotRootAndHaveRightChildAndHaveLeftChildAndNodeMinimumIsNotRightChildTest() {
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
    void treeDeleteWhenNodeDeletedIsNotRootAndIsBlackColorAndDoRecolorizationTest() {
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
        // Quando nó removido tem pai e está a esquerda, é folha, é BLACK, tem irmão e seu irmão é RED e tem rotação para esquerda
    void treeDeleteWhenNodeDeletedIsNotRootAndIsBlackColorAndDoRecolorization__Test() {
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
        irbt.breadthFirstTreeWalk(irbt.root);
        irbt.treeDelete(deletedRedBlackNode);
        logger.debug("after remove node {}", deletedRedBlackNode);
        irbt.breadthFirstTreeWalk(irbt.root);

        //Asserts
        Assertions.assertNull(irbt.treeSearch(irbt.root, 9));
//        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 9);
//        Assertions.assertEquals(8, searched.leftChild.key);
//        Assertions.assertEquals(10, searched.rightChild.key);

    }

    @Test
    void treeSearchWhenNodeIsFoundedTest() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));

        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 2);

        //Asserts
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(2, searched.key);
    }

    @Test
    void treeSearchWhenNodeIsNotFoundedTest() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));

        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 50);

        //Asserts
        Assertions.assertNull(searched);
    }

    @Test
    void treeSearchWhenNodeIsRootTreeTest() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();
        irbt.treeInsert(new RedBlackNode<>(15));
        irbt.treeInsert(new RedBlackNode<>(6));
        irbt.treeInsert(new RedBlackNode<>(3));
        irbt.treeInsert(new RedBlackNode<>(2));
        irbt.treeInsert(new RedBlackNode<>(4));

        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 15);

        //Asserts
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(15, searched.key);
    }

    @Test
    void treeSearchWhenTreeIsEmptyTest() {
        //Arrange
        RedBlackTreeImpl<Integer> irbt = new RedBlackTreeImpl<>();

        RedBlackNode<Integer> searched = irbt.treeSearch(irbt.root, 15);

        //Asserts
        Assertions.assertNull(searched);
    }
}