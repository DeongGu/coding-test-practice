import java.io.*;
import java.util.*;

public class Main {

	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		String[] s = br.readLine().split(" ");

		boolean[] visited = new boolean[N];
		int[] arr = new int[N];

		result = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		permutation(arr, visited, list);

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void permutation(int[] a, boolean[] v, List<Integer> l) {

		if (a.length == l.size()) {
			int sum = 0;

			for (int i = 0; i < l.size() - 1; i++) {
				sum += Math.abs(l.get(i) - l.get(i + 1));
			}

			result = Math.max(result, sum);
			return;
		}

		for (int i = 0; i < a.length; i++) {

			if (!v[i]) {
				v[i] = true;
				l.add(a[i]);
				permutation(a, v, l);
				l.remove(l.size() - 1);
				v[i] = false;
			}

		}
	}
}