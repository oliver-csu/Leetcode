package ren.oliver.leetcode.datastructure;

// 用数组实现的定长队列-静态数组
public class ArrayQueue {

    private Integer[] arr;
    private Integer size;
    private Integer first;
    private Integer last;

    // 构造函数
    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        first = 0;
        last = 0;
    }

    // 取元素的值，但不出队列
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[first];
    }

    // 入队列
    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[last] = obj;
        last = last == arr.length - 1 ? 0 : last + 1;
    }

    // 出队列
    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = first;
        first = first == arr.length - 1 ? 0 : first + 1;
        return arr[tmp];
    }

    public static void main(String[] args) {
        int queueSize = 5;
        ArrayQueue arrayQueue = new ArrayQueue(queueSize);
        for (int i = 0; i < queueSize; i++) {
            arrayQueue.push(i);
        }
        // 溢出测试
        // arrayQueue.push(queueSize);
        System.out.println("------------------------");
        for (int i = 0; i < queueSize; i++) {
            System.out.println(arrayQueue.peek());
            System.out.println(arrayQueue.poll());
        }
        // 越界测试
        // System.out.println(arrayQueue.poll());
    }

}
