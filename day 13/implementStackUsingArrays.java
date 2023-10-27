public class Solution{
    static class Stack {
        private int[] arr;
        private int ind = -1;
        int totalCap;
        Stack(int capacity) {
            arr = new int[capacity];
            totalCap = capacity;
        }
        public void push(int num) {
            if (isFull() == 0) {
                arr[++ind] = num;
            }
        }
        public int pop() {
            int top = 0;
            if (isEmpty() == 0) {
                top = arr[ind--];
                return top;
            }
            return -1;
        }
        public int top() {
            if (isEmpty() == 0) {
                return arr[ind];
            }
            return -1;
        }
        public int isEmpty() {
            return ind == -1 ? 1 : 0;
        }
        public int isFull() {
            return ind+1 == totalCap ? 1 : 0;
        }
    }
}