package it.unibo.pps.tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack{
    private final List<Integer> stack = new ArrayList<>();

    @Override
    public void push(int value) {
        stack.add(value);
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return stack.getLast();
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
