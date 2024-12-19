import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);


		arr = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < m; i++) {

			String[] ab = br.readLine().split(" ");
			int c = Integer.parseInt(ab[0]);
			int a = Integer.parseInt(ab[1]);
			int b = Integer.parseInt(ab[2]);

			if (c == 1) {
				if (findSet(a) == findSet(b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			} else {
				union(a, b);
			}

		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static int findSet(int x) {
		if (x != arr[x])
			arr[x] = findSet(arr[x]);
		return arr[x];
	}

	static void union(int x, int y) {
		arr[findSet(y)] = findSet(x);
	}

}