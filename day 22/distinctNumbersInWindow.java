import java.util.*;
import java.io.*;

public class Solution {
	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0, j = 0;

		while (j < arr.size()) {
			int window = j - i + 1;
			int elemAtj = arr.get(j);
			map.put(elemAtj, map.getOrDefault(elemAtj, 0) + 1);

			if (window == k) {
				ans.add(map.size());
				int elemAti = arr.get(i);
				map.put(elemAti, map.get(elemAti) - 1);

				if (map.get(elemAti) == 0) {
					map.remove(elemAti);
				}
				i++;
			}
			j++;
		}

		return ans;
	}
}