import java.io.*;
import java.util.*;

public class Main {

	static int[] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		memo = new int[1000001];
		Arrays.fill(memo, -1);

		recursion(N, 0);

		sb.append(memo[1]);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static void recursion(int n, int c) {
		if (n < 1)
			return;

		if (memo[n] != -1 && memo[n] <= c)
			return;

		memo[n] = c;

		if (n % 3 == 0) {
			recursion(n / 3, c + 1);
		}

		if (n % 2 == 0) {
			recursion(n / 2, c + 1);
		}

		recursion(n - 1, c + 1);
	}

}