package src;

import java.util.LinkedList;
import java.util.Queue;

public class L225_ImplementationOfStackUsingSingleQueue {
    Queue<Integer> dp;

    public L225_ImplementationOfStackUsingSingleQueue() {
        dp = new LinkedList<>();
    }

    public void push(int x) {
        if (dp.isEmpty()){ // if queue is empty, and adding one element to queue behave as stack
            dp.add(x);
            return;
        }

        dp.add(x);
        int n = dp.size();
        while (n > 1){ // after adding element, removing and pushing back to the queue, leaving that element which got newly added
            dp.add(dp.remove());
            n = n-1;
        }
    }

    public int pop() {
        return dp.remove();
    }

    public int top() {
        return dp.peek();
    }

    public boolean empty() {
        return dp.isEmpty();
    }
}
