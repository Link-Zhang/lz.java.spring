package cn.sh.lz.cig.c1p1;

/**
 * Created by Link at 15:35 on 2022/08/03.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(4);
        stack.push(5);
        stack.printMin();
        stack.push(2);
        stack.printMin();
        stack.push(1);
        stack.printMin();
        stack.pop();
        stack.printMin();
    }
}
