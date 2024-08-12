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
			String[] PQRSW = br.readLine().split(" ");
			
			int P = Integer.parseInt(PQRSW[0]);
			int Q = Integer.parseInt(PQRSW[1]);
			int R = Integer.parseInt(PQRSW[2]);
			int S = Integer.parseInt(PQRSW[3]);
			int W = Integer.parseInt(PQRSW[4]);
			
			int SumA = W * P;
			int SumB = Q; 
			
			if(W > R) SumB += (W-R) * S;
			
			int result = Math.min(SumA, SumB);
		
			sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}