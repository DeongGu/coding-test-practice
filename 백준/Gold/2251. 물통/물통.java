import java.io.*;
import java.util.*;

public class Main {

	static int A, B, C;
	static List<Integer> result;
	static HashSet<String> visited;
	static Deque<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] ABC = br.readLine().split(" ");
		A = Integer.parseInt(ABC[0]);
		B = Integer.parseInt(ABC[1]);
		C = Integer.parseInt(ABC[2]);

		result = new ArrayList<>();
		visited = new HashSet<>();

		bfs();

		Collections.sort(result);
		for (int value : result) {
			sb.append(value).append(" ");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {

		queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0, C });

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();

			int x = curr[0];
			int y = curr[1];
			int z = curr[2];

			if (x == 0 && !result.contains(z)) {
				result.add(z);
			}

			int emptyA = A - x;
			int emptyB = B - y;
			int emptyC = C - z;

			if (emptyB >= x) {
				addState(0, x + y, z);
			} else {
				addState(x - emptyB, B, z);
			}

			if (emptyC >= x) {
				addState(0, y, x + z);
			}

			if (emptyA >= y) {
				addState(x + y, 0, z);
			} else {
				addState(A, y - emptyA, z);
			}

			if (emptyC >= y) {
				addState(x, 0, y + z);
			}

			if (emptyA >= z) {
				addState(x + z, y, 0);
			} else {
				addState(A, y, z - emptyA);
			}

			if (emptyB >= z) {
				addState(x, y + z, 0);
			} else {
				addState(x, B, z - emptyB);
			}
		}

	}

	static void addState(int nx, int ny, int nz) {
		String state = nx + "," + ny + "," + nz;
		if (!visited.contains(state)) {
			visited.add(state);
			queue.add(new int[] { nx, ny, nz });
		}
	}
}