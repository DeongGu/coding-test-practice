import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder(1010);

		int t = Integer.parseInt(br.readLine());

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		for (int tc = 0; tc < t; tc++) {

			int N = Integer.parseInt(br.readLine());

			int num = 1;
			int idx = 0;

			int cr = 0;
			int cc = 0;

			int[][] result = new int[N][N];

			while (num <= N * N) {
				result[cr][cc] = num++;
				if (cr + dr[idx] >= 0 && cr + dr[idx] < N && cc + dc[idx] >= 0 && cc + dc[idx] < N
						&& result[cr + dr[idx]][cc + dc[idx]] == 0) {
					cr = cr + dr[idx];
					cc = cc + dc[idx];
				} else {
					idx++;
					if (idx >= 4)
						idx %= 4;
					cr = cr + dr[idx];
					cc = cc + dc[idx];
				}
			}
			sb.append("#").append(tc+1).append("\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(result[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}