import java.io.*;
import java.util.*;

public class Main {

	static long A, B, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] AB = br.readLine().split(" ");

		A = Long.parseLong(AB[0]);
		B = Long.parseLong(AB[1]);

		result = -1;

		bfs(A, 0);

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(long start, long count) {

		Deque<long[]> q = new ArrayDeque<>();

		q.add(new long[] { start, count });

		while (!q.isEmpty()) {

			long[] sc = q.pollFirst();
			
			if (sc[0] == B) {
				result = sc[1] + 1;
				return;
			}
		
			if (sc[0] * 2 <= B) {
				q.add(new long[] { sc[0] * 2, sc[1] + 1 });
			}

			if (sc[0] * 10 + 1 <= B) {
				q.add(new long[] { sc[0] * 10 + 1, sc[1] + 1 });
			}		
			
		}

	}
}