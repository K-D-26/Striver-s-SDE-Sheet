public class Solution {
    class Queue {
        int front, rear;
        int[] arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            if (rear != 100001) {
                arr[rear++] = e;
            }
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            int ans = -1;
            if(front < rear) {
                ans = arr[front++];
            }
            return ans;
        }
    }
}