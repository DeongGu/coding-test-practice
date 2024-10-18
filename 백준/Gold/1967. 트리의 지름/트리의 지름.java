import java.io.*;
import java.util.*;

public class Main {
	
	static int n, result, end;
	static Node[] nodes;
	static boolean[] visited;
	static List<Node>[] list;
	
	static class Node {
		
		int v, w;
		
		public Node(int num, int d) {
			v = num;
			w = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		nodes = new Node[n+1];
		visited = new boolean[n+1];
		list = new ArrayList[n+1];
		
		for(int i = 0; i <=n; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < n-1; i++) {
			
			String[] pcw = br.readLine().split(" ");
			
			int p = Integer.parseInt(pcw[0]);
			int c = Integer.parseInt(pcw[1]);
			int w = Integer.parseInt(pcw[2]);
			
			list[p].add(new Node(c,w));
			list[c].add(new Node(p,w));
		}
		
		
		dfs(1, 0);
		
		visited = new boolean[n+1];
		
		dfs(end, 0);
		
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int curr, int d) {
		
		visited[curr] = true;
		
		if(d > result) {
			result = d;
			end = curr;
		}
		
		for(Node c : list[curr]) {
			if(!visited[c.v]) {
				dfs(c.v, d + c.w);
			}
		}
		
	}
}