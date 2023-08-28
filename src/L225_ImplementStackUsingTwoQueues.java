package src;
/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the
 * functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as
 * you use only a queue's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 *
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 */

import java.util.LinkedList;
import java.util.Queue;

public class L225_ImplementStackUsingTwoQueues { // using two queues to implement stack
    Queue<Integer> dp1; // firstly, element will get add in dp1
    Queue<Integer> dp2; // secondly, all the element of dp2 will get add in dp1, so the newly added element will be at the top of the stack
                        // thirdly, we will swap both the queue
    int n; // used to keep the size count of stack

    L225_ImplementStackUsingTwoQueues(){
        dp1 = new LinkedList<>();
        dp2 = new LinkedList<>();
        n = 0;
    }

    public void push(int x) {
        dp1.add(x);
        n++;

        while(!dp2.isEmpty()){
            dp1.add(dp2.remove());
        }

        Queue<Integer> temp = dp1;
        dp1 = dp2;
        dp2 = temp;
    }

    public int pop() {
        n--;
        return dp2.remove();  // after adding one element, we know all the element will be in dp2
    }

    public int top() {
        return dp2.peek();
    }

    public boolean empty() {
        return dp2.isEmpty();
    }
}
