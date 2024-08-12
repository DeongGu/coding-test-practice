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

			double[] scoreArr = new double[N];

			for (int s = 0; s < N; s++) {
				String[] score = br.readLine().split(" ");
				scoreArr[s] = Integer.parseInt(score[0]) * 0.35 + Integer.parseInt(score[1]) * 0.45
						+ Integer.parseInt(score[2]) * 0.2;
			}

			String result = "A+";

			double check = scoreArr[K - 1];
			int count = 0;

			for (int i = 0; i < scoreArr.length; i++) {
				if (i == K-1)
					continue;
				if (check < scoreArr[i])
					count++;
			}

			String[] rank = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
			
			result = rank[count/(N/10)];
			

			sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	
	}
}