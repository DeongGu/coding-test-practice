import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] CR = br.readLine().split(" ");

		int R = Integer.parseInt(CR[0]);
		int C = Integer.parseInt(CR[1]);

		int[][] hall = new int[R][C];

		int K = Integer.parseInt(br.readLine());

		if (C * R >= K) {
			int num = 1;

			// 우 하 좌 상
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			int idx = 0;
			int r = 0;
			int c = 0;

			while (num < K) {
				hall[r][c] = num++;
				if (r + dr[idx] >= 0 && r + dr[idx] < R && c + dc[idx] >= 0 && c + dc[idx] < C
						&& hall[r + dr[idx]][c + dc[idx]] == 0) {
					r = r + dr[idx];
					c = c + dc[idx];
				} else {
					idx++;
					if (idx >= 4)
						idx %= 4;
					r = r + dr[idx];
					c = c + dc[idx];
				}

			}

			sb.append(r+1).append(" ").append(c+1);

		} else {
			sb.append(0);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
