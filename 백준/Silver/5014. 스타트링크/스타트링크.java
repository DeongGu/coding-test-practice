import java.io.*;
import java.util.*;

public class Main {

	static int F, S, G, U, D, result;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] FSGUD = br.readLine().split(" ");

		F = Integer.parseInt(FSGUD[0]);
		S = Integer.parseInt(FSGUD[1]);
		G = Integer.parseInt(FSGUD[2]);
		U = Integer.parseInt(FSGUD[3]);
		D = Integer.parseInt(FSGUD[4]);

		result = -1;
		visited = new boolean[F+1];

		bfs(S, 0);

		if (result == -1) {
			sb.append("use the stairs");
		} else {
			sb.append(result);
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int start, int count) {
		Deque<int[]> q = new ArrayDeque<>();

		q.add(new int[] { start, count });
		visited[start] = true;

		while (!q.isEmpty()) {

			int[] sc = q.pollFirst();
			

			if (sc[0] == G) {
				result = sc[1];
				return;
			}

	
			if (sc[0] + U <= F  &&!visited[sc[0] + U]) {
				visited[sc[0] + U] = true;
				q.add(new int[] { sc[0] + U, sc[1] + 1 });
			}
			
			if (sc[0] - D > 0 && !visited[sc[0] - D]) {
				visited[sc[0] - D] = true;
				q.add(new int[] { sc[0] - D, sc[1] + 1 });
			}

		}

	}
}