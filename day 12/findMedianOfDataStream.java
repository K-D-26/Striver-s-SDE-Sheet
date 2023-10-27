// coding ninja

import java.util.*;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        int ans[] = new int[n];
        int sortedArray[] = new int[n];
        
        for (int i = 0 ; i < n; i++) {
            putElementInSortedArray(sortedArray, arr[i], i);

            if ((i+1) % 2 == 0) {
                int mid = (i+1)/2 > 0 ? ((i+1)/2 - 1 ) : (i+1)/2; 
                ans[i] = (sortedArray[(i+1)/2] + sortedArray[mid])/2;
            }
            else {
                ans[i] = sortedArray[(i)/2];
            }
        }

        return ans;
    }

    private static void putElementInSortedArray(int sortedArray[], int ele, int index) {
        if (index == 0) {
            sortedArray[0] = ele;
        }
        else {
            for (int i = 0; i < index; i++) {
                if (sortedArray[i] > ele) {
                    int temp = sortedArray[i];
                    sortedArray[i] = ele;
                    ele = temp;
                }
            }
            sortedArray[index] = ele;
        }
    }
}


// leetcode

class MedianFinder {
    private PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b - a); // max heap
    private PriorityQueue<Integer> large = new PriorityQueue<>(); // min heap
    private boolean even = true;

    public MedianFinder() {}

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }

        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}