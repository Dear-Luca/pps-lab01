package it.unibo.pps.tdd;

public class CircularQueueImpl implements CircularQueue {
    private final int fixedCapacity;

    public CircularQueueImpl(int fixedCapacity){
        this.fixedCapacity = fixedCapacity;
    }

    @Override
    public int getFixedCapacity() {
        return this.fixedCapacity;
    }
}
