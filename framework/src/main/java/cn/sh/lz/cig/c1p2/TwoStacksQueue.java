package cn.sh.lz.cig.c1p2;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by Link at 16:19 on 2022/08/03.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void offer(int data) {
        this.stackPush.push(data);
    }

    public int remove() {
        handleQueue();
        return this.stackPop.pop();
    }

    public int peek() {
        handleQueue();
        return this.stackPop.peek();
    }

    private void handleQueue() {
        if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
            throw new NoSuchElementException();
        } else if (this.stackPop.isEmpty()) {
            while (!this.stackPush.isEmpty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
    }
}
