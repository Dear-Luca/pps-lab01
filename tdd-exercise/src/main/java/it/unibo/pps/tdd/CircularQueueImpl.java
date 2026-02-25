package it.unibo.pps.tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    private final int fixedCapacity;
    private final List<Integer> queue = new ArrayList<>();

    public CircularQueueImpl(int fixedCapacity){
        this.fixedCapacity = fixedCapacity;
    }

    @Override
    public int getFixedCapacity() {
        return this.fixedCapacity;
    }

    @Override
    public void push(int value) {
        queue.add(value);
    }

    @Override
    public int getSize() {
        return this.queue.size();
    }


}

