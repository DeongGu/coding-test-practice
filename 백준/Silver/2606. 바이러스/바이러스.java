import java.io.*;
import java.util.*;

public class Main {

	static int N, K, result;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for(int i = 0; i < K; i++) {
			String[] nn = br.readLine().split(" ");
			
			int input = Integer.parseInt(nn[0]);
			int output = Integer.parseInt(nn[1]);
			
			list[input].add(output);
			list[output].add(input);
		}

		bfs(1);
		
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int v) {

		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			
			
			for(int w : list[curr]) {
				if(!visited[w]) {
					q.add(w);
					visited[w] = true;
					result++;
				}
			}
			
		}

	}

}