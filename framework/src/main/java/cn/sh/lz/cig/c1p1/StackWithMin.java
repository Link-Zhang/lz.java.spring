package cn.sh.lz.cig.c1p1;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Link at 15:37 on 2022/08/03.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class StackWithMin {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public StackWithMin() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int data) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(data);
        } else if (data < this.getMin()) {
            this.stackMin.push(data);
        }
        this.stackData.push(data);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new EmptyStackException();
        }
        int data = this.stackData.pop();
        if (data == this.getMin()) {
            this.stackMin.pop();
        }
        return data;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stackMin.peek();
    }

    public void printMin() {
        System.out.println("The Min in Stack is :" + this.getMin() + ".");
    }
}
