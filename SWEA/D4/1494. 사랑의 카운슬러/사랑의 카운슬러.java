import java.io.*;

public class Solution {

	static int[] x, y;
	static int N;
	static long result;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			N = Integer.parseInt(br.readLine());

			x = new int[N];
			y = new int[N];
			visited = new boolean[N];

			long resultX = 0;
			long resultY = 0;


			for (int i = 0; i < N; i++) {

				String[] xy = br.readLine().split(" ");
				x[i] = Integer.parseInt(xy[0]);
				y[i] = Integer.parseInt(xy[1]);
				
				resultX+= x[i];
				resultY+= y[i];
			}
			result = Long.MAX_VALUE;

			recursion(0, 0, 0, 0, resultX, resultY);

			sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void recursion(int start, int count, long sumX, long sumY, long resultX, long resultY) {

		if (count == N / 2) {

			long vectorX = 2 * sumX - resultX;
			long vectorY = 2 * sumY - resultY;

			long vectorSum = vectorX * vectorX + vectorY * vectorY;

			result = Math.min(result, vectorSum);
			return;
		}

		for (int i = start; i < N; i++) {

			if(!visited[i]) {
				
				visited[i] = true;
				
				recursion(i+1, count+1, sumX+x[i], sumY+y[i], resultX, resultY);
				
				visited[i] = false;
			}
		}
	}
}
