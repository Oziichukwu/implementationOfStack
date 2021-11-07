package stackImplementationTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stackImplementation.Stack;

import static org.junit.jupiter.api.Assertions.*;
public class StackTest {
    Stack stack;
    @BeforeEach
    void setUp(){
        stack = new Stack(5);
    }
    @Test
    public void stackCanBeCreatedTest(){
        assertNotNull(stack);
    }

    @Test
    void stackMaxSizeShouldBeSetToValuePassedInAsSize(){

        assertEquals(5, stack.getMaximumStackSize());
    }

    @Test
    void stackPushMethodShouldAddItemToTheTopOfStack() throws  Exception{
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    void stackPopMethodShouldRemoveItemFromTheTopOfTheStack() throws Exception {
        stack.push(20);
        stack.push(30);
        assertEquals(2, stack.size());
        assertEquals(30,stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void stackPeekMethodReturnItemAtTopOfTheStackWithoutModifyingStack() throws Exception{

        stack.push(20);
        stack.push(40);
        assertEquals(40, stack.peek());
        assertEquals(2, stack.size());
        stack.push(45);
        assertEquals(45, stack.peek());
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(40,stack.peek());
        assertEquals(2, stack.size());
    }
    @Test
    void stackSizeMethodShouldReturnAmountOfItemsCurrentlyInTheStack() throws Exception{

        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void stackIsEmptyMethodCheckIfStackIsEmptyOrNot(){

        assertTrue(stack.isEmpty());
    }

    @Test
    void stackIsFullMethodCheckIfStackIsFullOrNot() throws Exception{

        assertFalse(stack.isFull());

        stack.push(21);
        stack.push(31);
        stack.push(24);
        stack.push(91);
        stack.push(11);
        assertTrue(stack.isFull());
    }

    @Test
    void testStackToString() throws Exception{
        stack.push(10);
        stack.push(20);
        String stackToString =  stack.toString();
        System.out.println(stackToString);
    }

    @Test
    void stackSearchMethod() throws  Exception{
        stack.push(29);
        stack.push(13);
        stack.push(12);
        stack.push(21);
        stack.push(23);
        assertEquals(1, stack.search(23));
        assertEquals(4, stack.search(13));
    }

}
