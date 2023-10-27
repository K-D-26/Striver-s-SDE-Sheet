import java.util.* ;
import java.io.*; 

public class Solution {
	public static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) return;
		
		int top = stack.pop();
		sortStack(stack);
		insertElementInSortedManner(stack, top);
	}

	private static void insertElementInSortedManner(Stack<Integer> stack, int ele) {
		if (stack.isEmpty() || stack.peek() <= ele) {
			stack.push(ele);
			return;
		}

		int top = stack.pop();
		insertElementInSortedManner(stack, ele);
		stack.push(top);
	}
}