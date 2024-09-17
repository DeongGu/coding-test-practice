import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N =  Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[][] garden = new int[N+1][M+1];
		
		String[] left = br.readLine().split(" ");
		String[] top = br.readLine().split(" ");
		
		for(int r = 0; r < left.length; r++) {
			garden[r+1][0] = Integer.parseInt(left[r]);
		}
		
		for(int c = 0; c < top.length; c++) {
			garden[0][c+1] = Integer.parseInt(top[c]);
		}

		for(int r = 1; r < N+1; r++) {
			
			for(int c = 1; c < M+1; c++) {
				
				if(garden[r-1][c] == garden[r][c-1]) {
					garden[r][c] = 0;
				}else {
					garden[r][c] = 1;
				}
			}
		}
		
		sb.append(garden[N][M]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}