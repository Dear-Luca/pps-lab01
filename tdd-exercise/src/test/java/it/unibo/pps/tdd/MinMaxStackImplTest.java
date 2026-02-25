package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    @BeforeEach
    public void beforeEach(){

    }

    @Test
    public void testPush() {
        final MinMaxStack stack = new MinMaxStackImpl();
        stack.push(1);
        assertEquals(1, stack.peek());

    }

}