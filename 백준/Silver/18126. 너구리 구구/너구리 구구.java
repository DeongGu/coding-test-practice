import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static long result;
	static long[][] matrix;
	static boolean[][] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		matrix = new long[N + 1][N + 1];
		list = new ArrayList[N + 1];
		result = 0;

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			String[] ABC = br.readLine().split(" ");
			int A = Integer.parseInt(ABC[0]);
			int B = Integer.parseInt(ABC[1]);
			long C = Long.parseLong(ABC[2]);

			matrix[A][B] = C;
			matrix[B][A] = C;

			list[A].add(B);
			list[B].add(A);
		}

		bfs(1);

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int start) {

		Deque<long[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.add(new long[] { start, 0 });

		while (!q.isEmpty()) {
			long[] curr = q.poll();
			long location = curr[0];
			long distance = curr[1];

			result = Math.max(result, distance);

			for (long w : list[(int) location]) {

				if (!visited[(int) w]) {
					visited[(int) w] = true;
					q.add(new long[] { w, distance + matrix[(int) location][(int) w] });
				}

			}

		}

	}
}