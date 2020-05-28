package ren.oliver.leetcode.datastructure;

// 用数组实现的定长栈-静态数组
public class ArrayStack {

    private Integer[] arr;
    private Integer size;

    // 构造函数
    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
    }

    // 只取元素但不出栈
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[size - 1];
    }

    // 入栈
    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[size++] = obj;
    }

    // 出栈
    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[--size];
    }

    // 测试主函数
    public static void main(String[] args) {
        int stackSize = 5;
        ArrayStack arrayStack = new ArrayStack(stackSize);
        for (int i = 0; i < stackSize; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack.peek());
        }
        // 溢出测试
        // arrayStack.push(stackSize);
        System.out.println("------------------------");
        for (int i = 0; i < stackSize; i++) {
            System.out.println(arrayStack.pop());
        }
        // 越界测试
        // System.out.println(arrayStack.pop());
    }

}
