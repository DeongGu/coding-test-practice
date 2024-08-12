import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String[] NK = br.readLine().split(" ");
			int N = Integer.parseInt(NK[0]);
			int K = Integer.parseInt(NK[1]);

			int result = 0;

			int[][] puzzle = new int[N][N];

			for (int r = 0; r < N; r++) {
				String[] info = br.readLine().split(" ");

				int check = 0;

				for (int c = 0; c < N; c++) {
					puzzle[r][c] = Integer.parseInt(info[c]);

					if (puzzle[r][c] == 1) {
						check++;
					} else {
						if (check == K) {
							result++;
						}
						check = 0;
					}
				}
				
				if (check == K)
					result++;
			}

			for (int c = 0; c < N; c++) {

				int check = 0;

				for (int r = 0; r < N; r++) {

					if (puzzle[r][c] == 1) {
						check++;
					} else {
						if (check == K) {
							result++;
						}
						check = 0;

					}
				}
				
				if(check == K) result++;

			}

			sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}