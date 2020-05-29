package ren.oliver.leetcode.leet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 栈与队列的转换
public class StackAndQueueConvert {

    // 用两个栈实现队列的功能
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    // 用两个队列实现栈
    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }

    }

    public static void main(String[] args) {

        // 队列测试
        int queueSize = 5;
        TwoStacksQueue queue = new TwoStacksQueue();
        for (int i = 0; i < queueSize; i++) {
            queue.push(i);
        }
        for (int i = 0; i < queueSize; i++) {
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }

        System.out.println("==========================");

        // 栈测试
        int stackSize = 5;
        TwoQueuesStack stack = new TwoQueuesStack();
        for (int i = 0; i < stackSize; i++) {
            stack.push(i);
        }
        for (int i = 0; i < stackSize; i++) {
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }
    }

}
