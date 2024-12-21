import java.io.*;
import java.util.*;

public class Main {

	static String[] tree;
	static String pre = "";
	static String mid = "";
	static String end = "";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		tree = new String[(int) Math.pow(2, N)];

		Map<String, Integer> map = new HashMap<>();

		map.put("A", 1);
		tree[1] = "A";

		for (int i = 0; i < N; i++) {
			String[] alpa = br.readLine().split(" ");

			int parentIdx = map.get(alpa[0]);

			if (!alpa[1].equals(".")) {
				tree[parentIdx * 2] = alpa[1];
				map.put(alpa[1], parentIdx * 2);
			}

			if (!alpa[2].equals(".")) {
				tree[parentIdx * 2 + 1] = alpa[2];
				map.put(alpa[2], parentIdx * 2 + 1);
			}

		}

		preorder(1);
		midorder(1);
		endorder(1);

		sb.append(pre).append("\n").append(mid).append("\n").append(end);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static public void preorder(int index) {

		if (index >= tree.length || tree[index] == null) {
			return;
		}

		pre += tree[index];

		preorder(index * 2);
		preorder(index * 2 + 1);
	}

	static public void midorder(int index) {

		if (index >= tree.length || tree[index] == null) {
			return;
		}

		midorder(index * 2);
		mid += tree[index];
		midorder(index * 2 + 1);
	}

	static public void endorder(int index) {

		if (index >= tree.length || tree[index] == null) {
			return;
		}

		endorder(index * 2);
		endorder(index * 2 + 1);
		end += tree[index];
	}

}