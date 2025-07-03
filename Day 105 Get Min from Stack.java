// Given q queries, You task is to implement the following four functions for a stack:

// push(x) – Insert an integer x onto the stack.
// pop() – Remove the top element from the stack.
// peek() - Return the top element from the stack. If the stack is empty, return -1.
// getMin() – Retrieve the minimum element from the stack in O(1) time. If the stack is empty, return -1.
// Each query can be one of the following:

// 1 x : Push x onto the stack.
// 2 : Pop the top element from the stack.
// 3: Return the top element from the stack. If the stack is empty, return -1.
// 4: Return the minimum element from the stack.





class Solution {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public Solution() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element onto the stack
    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    // Pop the top element from the stack
    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    // Return the top element of the stack
    public int peek() {
        if (mainStack.isEmpty()) return -1;
        return mainStack.peek();
    }

    // Return the minimum element of the stack in O(1)
    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}