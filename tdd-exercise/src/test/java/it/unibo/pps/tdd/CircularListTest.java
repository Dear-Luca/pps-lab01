package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The test suite for testing the CircularQueue implementation
 */
public class CircularListTest {
    private CircularQueue circularQueue;
    private static final int CAPACITY = 10;
    private static final int VALUE = 1;

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
        circularQueue.push(VALUE);
        assertEquals(1, circularQueue.getSize());
    }

    @Test
    public void testPollValue(){
        circularQueue.push(VALUE);
        assertEquals(VALUE, circularQueue.poll());
    }

    @Test
    public void testPollRemoval(){
        circularQueue.push(VALUE);
        circularQueue.poll();
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void testCircularPush(){
        for (int i = 0; i < CAPACITY * 2; i++) {
            circularQueue.push(i);
        }
        assertEquals(CAPACITY, circularQueue.getFirst());
    }

}
