import java.util.*;
import java.io.*;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		HashSet<String> set= new HashSet<>();
		for (String word : dictionary) {
			set.add(word);
		}

		ArrayList<String> ans= new ArrayList<>();
		generate(new StringBuilder(), s, set, ans);

		return ans;
	}

	private static void generate(StringBuilder sb , String s , HashSet<String> set, ArrayList<String> ans) {
		if (s.length() == 0) {
			sb.deleteCharAt(sb.length()-1);
			ans.add(new StringBuilder(sb).toString());
			return;
		}

		StringBuilder word = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			word.append(ch);

			if (set.contains(word.toString())) {
				sb.append(word + " ");
				
				generate(sb, s.substring(i+1), set, ans);
				
				int del = sb.lastIndexOf(word.toString());
				sb.delete(del, sb.length());
			}
		}
	}
}