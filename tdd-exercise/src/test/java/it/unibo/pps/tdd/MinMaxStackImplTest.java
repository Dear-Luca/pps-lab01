package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack minMaxStack;
    private static final int VALUE = 1;
    private static final int MINIMUM_VALUE = -10;
    private static final int MAXIMUM_VALUE = 10;

    @BeforeEach
    public void beforeEach(){
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testPush(){
        minMaxStack.push(VALUE);
        assertFalse(minMaxStack.isEmpty());
    }

    @Test
    public void testPeek() {
        minMaxStack.push(VALUE);
        assertEquals(VALUE, minMaxStack.peek());
    }

    @Test
    public void testPeekWithEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }

    @Test
    public void testPopValue(){
        minMaxStack.push(VALUE);
        assertEquals(VALUE, minMaxStack.pop());
    }

    @Test
    public void testPopRemoval(){
        minMaxStack.push(VALUE);
        minMaxStack.pop();
        assertEquals(0, minMaxStack.size());
    }

    @Test
    public void testPopWithEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    public void testGetMin(){
        for (int i = MINIMUM_VALUE; i <= MAXIMUM_VALUE; i++) {
            minMaxStack.push(i);
        }
        assertEquals(MINIMUM_VALUE, minMaxStack.getMin());
    }

    @Test
    public void testGetMax(){
        for (int i = MINIMUM_VALUE; i <= MAXIMUM_VALUE; i++){
            minMaxStack.push(i);
        }
        assertEquals(MAXIMUM_VALUE, minMaxStack.getMax());
    }


}