package jiachen.algorithm;

import java.util.*;

public class GoogleOnSite {
	public static void main(String[] args) {
		List<String> res = get(7);
		System.out.println(res);
	}
	
	public static List<String> get(int num) {
		HashSet<String> set = new HashSet<> ();
		int[] cur = new int[num];
		dfs(num, 0, 0, cur, set);
		return new ArrayList<String> (set);
	}
	public static void dfs(int num, int index, int begin, int[] cur, HashSet<String> list) {
		String temp = "";
		for (int i = 0; i < num; i++) temp += cur[i];
		list.add(temp);
		for (int i = index; i < num; i++) {
			if (i == begin || i - begin >= num/3) {
				cur[i] = 1;
				dfs(num, index + 1, i, cur, list);
				cur[i] = 0;
			}
		}
	}
}
