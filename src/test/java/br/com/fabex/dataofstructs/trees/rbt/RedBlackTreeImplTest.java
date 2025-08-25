package br.com.fabex.dataofstructs.trees.rbt;

import org.junit.jupiter.api.Test;

class RedBlackTreeImplTest {

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

        irbt.treeDelete(deletedRedBlackNode);

        irbt.inOrderTreeWalk(irbt.root);
    }
}