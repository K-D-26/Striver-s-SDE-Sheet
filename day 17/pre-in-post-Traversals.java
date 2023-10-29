// Method 1:

import java.util.*;
import java.io.*;

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

		List<Integer> in = new ArrayList<>();
		List<Integer> pre = new ArrayList<>();
		List<Integer> post = new ArrayList<>();

		solve(root, in, pre, post);
		ans.add(in);
		ans.add(pre);
		ans.add(post);

		return ans;
    }

	private static void solve(BinaryTreeNode<Integer> root, List<Integer> in, List<Integer> pre, List<Integer> post) {
		if (root == null) return;
		
		pre.add(root.data);
		solve(root.left, in, pre, post);

		in.add(root.data);
		solve(root.right, in, pre, post);

		post.add(root.data);
	}
}


// Method 2:

import java.util.*;
import java.io.*;

class Pair {
    BinaryTreeNode node;
    int num;
    public Pair(BinaryTreeNode node, int n) {
        this.node = node;
        this.num = n;
    }
}

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
		List<List<Integer>> ans = new ArrayList<>();
		
        if(root == null) return ans;

		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root, 1));
		List<Integer> in = new ArrayList<>();
		List<Integer> pre = new ArrayList<>();
		List<Integer> post = new ArrayList<>();

		while (!st.isEmpty()) {
			Pair it = st.pop();
			if (it.num == 1) {
				pre.add((Integer)it.node.data);
				it.num++;
				st.push(it);
				if (it.node.left != null) {
					st.push(new Pair(it.node.left, 1));
				}
			}
			else if (it.num == 2) {
				in.add((Integer)it.node.data);
				it.num++;
				st.push(it);
				if (it.node.right != null) {
					st.push(new Pair(it.node.right, 1));
				}
			}
			else {
				post.add((Integer)it.node.data);
			}
		}

		ans.add(in);
		ans.add(pre);
		ans.add(post);
        
		return ans;
	}
}