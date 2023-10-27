import java.util.*;
import java.io.*;

class Tuple implements Comparable<Tuple> {
    int data;       // the element
    int i;          // the index of the list in which the element is present
    int j;          // the index of the element in the list
    public Tuple(int a, int b, int c) {
        this.data = a;
        this.i = b;
        this.j = c;
    }
    
    public int compareTo(Tuple t) {
        return this.data - t.data;
    }
}

public class Solution {
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        
        for (int i = 0; i < k; i++) {
            pq.offer(new Tuple(kArrays.get(i).get(0), i, 0));
        }
        
        while (!pq.isEmpty()) {
            Tuple t = pq.remove();
            ans.add(t.data);
            
            int newj = t.j + 1;
            if (newj < kArrays.get(t.i).size()) {
                pq.offer(new Tuple(kArrays.get(t.i).get(newj), t.i, newj));
            }
        }
        
        return ans;
	}
}