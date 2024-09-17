import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

		while (true) {

			String[] CR = br.readLine().split(" ");

			int C = Integer.parseInt(CR[0]);
			int R = Integer.parseInt(CR[1]);

			if (C == 0 && R == 0)
				break;

			int[][] matrix = new int[C][R];

			for (int r = 0; r < C; r++) {

				String[] area = br.readLine().split("");

				for (int c = 0; c < R; c++) {

					if (area[c].equals("*")) {
						matrix[r][c] = -1;
						for (int i = 0; i < 8; i++) {

							int nr = r + dr[i];
							int nc = c + dc[i];

							if (nr >= 0 && nc >= 0 && nr < C && nc < R && matrix[nr][nc] != -1) {
								matrix[nr][nc]++;
							}
						}
					}
				}

			}
			
			for(int r = 0; r < C; r++) {
				
				for(int c = 0; c < R; c++) {
					
					if(matrix[r][c] == -1) {						
						sb.append("*");
					}else {
						sb.append(matrix[r][c]);
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