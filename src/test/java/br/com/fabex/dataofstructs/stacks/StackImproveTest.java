package br.com.fabex.dataofstructs.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackImproveTest {

    @Test
    public void getSizeSuccessTest() {
        Assertions.assertEquals(10, new StackImprove().getSize());
    }

    @Test
    public void getSizeWithLengthSuccessTest() {
        Assertions.assertEquals(100, new StackImprove(100).getSize());
    }

    @Test
    public void getCountSuccessTest() {
        Assertions.assertEquals(0, new StackImprove().getCount());
    }

    @Test
    public void isEmptyTrueTest() {
        Assertions.assertTrue(new StackImprove().isEmpty());
    }

    @Test
    public void isEmptyFalseTest() {
        //Arrange
        StackImprove stack = new StackImprove(5);

        //Act
        stack.push(50);

        //Asserts
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    public void pushSuccessTest() {
        //Arrange
        StackImprove stack = new StackImprove(3);

        //Act
        Assertions.assertDoesNotThrow(() -> stack.push(1));

        //Asserts
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(1, stack.getCount());
    }

    @Test
    public void pushThrowStackOverflowTest() {
        //Arrange
        StackImprove stack = new StackImprove(3);
        stack.push(31);
        stack.push(32);
        stack.push(33);

        //Act & Asserts
        Assertions.assertThrows(RuntimeException.class, () -> stack.push(34));
    }

    @Test
    public void popSuccessTest() {
        //Arrange
        StackImprove stack = new StackImprove(10);
        stack.push(91);
        stack.push(62);
        stack.push(13);
        int last = 13;

        //Act
        int pop = stack.pop();

        //Asserts
        Assertions.assertEquals(last, pop);
        Assertions.assertEquals(2, stack.getCount());
    }

    @Test
    public void popThrowStackUnderflowTest() {
        //Arrange
        StackImprove stack = new StackImprove(3);

        //Act & Asserts
        Assertions.assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    public void topSuccessTest() {
        //Arrange
        StackImprove stack = new StackImprove(5);
        stack.push(62);
        stack.push(50);
        stack.push(30);
        stack.push(1);
        int top = 1;
        //Act
        int resultTop = stack.top();

        //Asserts
        Assertions.assertEquals(top, resultTop);
    }

    @Test
    public void topThrowStackUnderTest() {
        //Arrange
        StackImprove stack = new StackImprove(5);

        //Act & Asserts
        Assertions.assertThrows(RuntimeException.class, stack::top);
    }

    @Test
    public void pushAndPopAndTopTest1() {
        //Arrange
        StackImprove stack = new StackImprove(2);
        stack.push(62);
        stack.push(50);
        stack.pop();
        stack.pop();
        stack.push(30);
        stack.push(31);//top
        //Act
        int resultTop = stack.top();

        //Asserts
        Assertions.assertEquals(31, resultTop);
    }

    @Test
    public void pushAndPopThrowStackUnderflowTest1() {
        //Arrange
        StackImprove stack = new StackImprove(2);
        stack.push(62);
        stack.push(50);
        stack.pop();
        stack.pop();

        //Act & Asserts
        Assertions.assertThrows(RuntimeException.class, stack::top);
    }
}