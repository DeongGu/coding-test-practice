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
			sb.append("#").append(tc+1).append("\n");
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] tri = new int[N][N];
			
			
			for(int i = 0; i < N; i++) {
				tri[i][0] = 1;
				sb.append(tri[i][0]).append(" ");
				for(int j = 1; j <= i; j++) {
					tri[i][j] = tri[i-1][j] +tri[i-1][j-1];
					sb.append(tri[i][j]).append(" ");
				}
				
				sb.append("\n");
			}
		
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}