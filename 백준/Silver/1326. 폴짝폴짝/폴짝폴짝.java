import java.io.*;
import java.util.*;

public class Main {

	static int N, start, end;
	static int[] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		matrix = new int[N];
		String[] s = br.readLine().split(" ");
		String[] se = br.readLine().split(" ");

		start = Integer.parseInt(se[0]) - 1;
		end = Integer.parseInt(se[1]) - 1;

		for (int i = 0; i < N; i++) {
			matrix[i] = Integer.parseInt(s[i]);
		}

		sb.append(bfs());

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {

		Deque<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];

		queue.add(new int[] { start , 0 });

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int location = curr[0];
			int count = curr[1];

			if (location == end)
				return count;

			for (int i = 1; location - matrix[location] * i >= 0; i++) {
                int nextLocation = location - matrix[location] * i;
                if (!visited[nextLocation]) {
                    visited[nextLocation] = true;
                    queue.add(new int[] { nextLocation, count + 1 });
                }
            }

            for (int i = 1; location + matrix[location] * i < N; i++) {
                int nextLocation = location + matrix[location] * i;
                if (!visited[nextLocation]) {
                    visited[nextLocation] = true;
                    queue.add(new int[] { nextLocation, count + 1 });
                }
            }
		}

		return -1;
	}
}