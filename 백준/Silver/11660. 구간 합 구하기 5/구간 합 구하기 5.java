import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[][] sum = new int[N][N];

		for (int r = 0; r < N; r++) {

			String[] row = br.readLine().split(" ");

			for (int c = 0; c < N; c++) {
				
				if(c == 0) {
					sum[r][c] = Integer.parseInt(row[c]);
				}else {					
					sum[r][c] = sum[r][c-1] + Integer.parseInt(row[c]);
				}
			}
		}


		for (int tc = 0; tc < M; tc++) {
			String[] xy = br.readLine().split(" ");

			int x1 = Integer.parseInt(xy[0])-1;
			int y1 = Integer.parseInt(xy[1])-1;
			int x2 = Integer.parseInt(xy[2])-1;
			int y2 = Integer.parseInt(xy[3])-1;

			int result = 0;
			
			for(int r = x1; r <= x2; r++) {
			
				if(y2 - 1 >= 0 && y1 -1 >= 0) {
					result+= sum[r][y2] - sum[r][y1-1];
				}else {
					result+= sum[r][y2];
				}
			}


			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}