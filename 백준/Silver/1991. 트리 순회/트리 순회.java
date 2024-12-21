import java.io.*;
import java.util.*;

public class Main {

	static class Node {

		String leftChild;
		String data;
		String rightChild;

		public Node(String leftChild, String data, String rightChild) {
			this.leftChild = leftChild;
			this.data = data;
			this.rightChild = rightChild;
		}
		
		public String toString() {
			return leftChild + data + rightChild;
		}
	}

	static String pre = "";
	static String mid = "";
	static String end = "";
	static Map<String, Node> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String[] alpa = br.readLine().split(" ");

			String left = alpa[1].equals(".") ? null : alpa[1];
			String right = alpa[2].equals(".") ? null : alpa[2];

			map.put(alpa[0], new Node(left, alpa[0], right));
		}

		preorder(map.get("A"));
		midorder(map.get("A"));
		endorder(map.get("A"));
		
		sb.append(pre).append("\n").append(mid).append("\n").append(end);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static public void preorder(Node node) {
		

		if(node == null) return;
		
		pre += node.data;
		preorder(map.get(node.leftChild));
		preorder(map.get(node.rightChild));
	}

	static public void midorder(Node node) {
		
		if(node == null) return;
		
		midorder(map.get(node.leftChild));
		mid += node.data;
		midorder(map.get(node.rightChild));
	}

	static public void endorder(Node node) {
		if(node == null) return;

		endorder(map.get(node.leftChild));
		endorder(map.get(node.rightChild));
		end += node.data;
	}

}