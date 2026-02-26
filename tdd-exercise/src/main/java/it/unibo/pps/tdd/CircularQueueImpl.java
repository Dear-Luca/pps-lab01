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
        if (queue.size() >= fixedCapacity){
            queue.removeFirst();
        }
        queue.add(value);
    }

    @Override
    public int getSize() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int poll() {
        if (queue.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue.getFirst();
        queue.removeFirst();
        return value;
    }

    @Override
    public int getFirst() {
        if (queue.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }

}

