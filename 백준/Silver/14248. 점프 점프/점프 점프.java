import java.io.*;
import java.util.*;

public class Main {

	static int N, M, start, result = 1;
	static int[] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		matrix = new int[N];
		String[] s = br.readLine().split(" ");
		start = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			matrix[i] = Integer.parseInt(s[i]);
		}

		bfs();

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {

		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];

		queue.add(start - 1);

		while (!queue.isEmpty()) {

			int curr = queue.poll();

			int left = curr - matrix[curr];
			int right = curr + matrix[curr];
			
			if(left >= 0 && !visited[left]) {
				visited[left] = true;
				queue.add(left);
				result++;
			}
			
			if(right < N && !visited[right]) {
				visited[right] = true;
				queue.add(right);
				result++;
			}

		}

	}

}