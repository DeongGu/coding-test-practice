import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] RC = br.readLine().split(" ");

		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int[][] garden = new int[R][C];
		int result = 1;

		for (int r = 0; r < R; r++) {

			String[] s = br.readLine().split("");

			for (int c = 0; c < C; c++) {
				if (s[c].equals("S")) {
					garden[r][c] = 1;
				} else if (s[c].equals("W")) {
					garden[r][c] = 2;
				}
			}
		}

		for (int r = 0; r < R; r++) {

			for (int c = 0; c < C; c++) {

				if (garden[r][c] == 2) {

					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						
						if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
							if(garden[nr][nc] == 1) {
								result = 0;
							}else if(garden[nr][nc] == 0) {
								garden[nr][nc] = 3;
							}
							
						}
					}

				}

			}
		}

		if(result == 0) {
			sb.append(result);			
		}else {
			sb.append(result).append("\n");
			
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					
					if(garden[r][c] == 2) {						
						sb.append("W");
					}else if(garden[r][c] == 1) {
						sb.append("S");
					}else if(garden[r][c] == 3){
						sb.append("D");
					}else {
						sb.append(".");
					}
				}
				
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}