package it.unibo.pps.tdd;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class MinMaxStackImpl implements MinMaxStack{
    private final List<Integer> stack = new ArrayList<>();
    private int minValue = MAX_VALUE;
    private int maxValue = MIN_VALUE;


    @Override
    public void push(int value) {
        stack.add(value);
        this.minValue = min(minValue, value);
        this.maxValue = max(maxValue, value);
    }

    @Override
    public int pop() {
        if (stack.isEmpty()){
            throw new IllegalStateException("Stack is empty!");
        }
        int value = stack.getLast();
        stack.removeLast();
        return value;
    }

    @Override
    public int peek() {
        if (stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.getLast();
    }

    @Override
    public int getMin() {
        return this.minValue;
    }

    @Override
    public int getMax() {
        return this.maxValue;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
