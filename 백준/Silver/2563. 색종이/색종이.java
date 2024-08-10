import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[][] board = new int[100][100];

		for (int c = 0; c < T; c++) {
			String[] paper = br.readLine().split(" ");

			int startX = Integer.parseInt(paper[0]);
			int startY = Integer.parseInt(paper[1]);
			int width = 10;
			int height = 10;

			for (int x = startX; x < startX + width; x++) {
				for (int y = startY; y < startY + height; y++) {
					board[x][y] = c + 1;
				}
			}
		}

		int sum = 0;

		for (int i = 0; i < 100; i++) {

			for (int j = 0; j < 100; j++) {

				if (board[i][j] != 0) {
					sum++;
				}
			}
		}
		
		sb.append(sum).append("\n");

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}