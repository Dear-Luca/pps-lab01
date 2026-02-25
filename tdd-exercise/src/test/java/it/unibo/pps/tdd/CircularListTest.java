package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * The test suite for testing the CircularQueue implementation
 */
public class CircularListTest {
    private CircularQueue circularQueue;
    private static final int CAPACITY = 10;
    @BeforeEach
    public void beforeEach(){
        circularQueue = new CircularQueueImpl(CAPACITY);
    }

    @Test
    public void testCapacity(){
        assertEquals(CAPACITY, circularQueue.getFixedCapacity());
    }

    @Test
    public void testPush(){
        final int value = 10;
        circularQueue.push(value);
        assertEquals(1, circularQueue.getSize());
    }


}
