import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int result = 0;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int direction = 1;
		Deque<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { 0, 0 });

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];

		board[0][0] = 2;

		for (int i = 0; i < K; i++) {
			String[] RC = br.readLine().split(" ");
			int R = Integer.parseInt(RC[0]) - 1;
			int C = Integer.parseInt(RC[1]) - 1;

			board[R][C] = 1;
		}

		int L = Integer.parseInt(br.readLine());

		boolean check = true;

		for (int i = 0; i < L; i++) {
			
			if(!check) break;

			String[] XC = br.readLine().split(" ");

			int X = Integer.parseInt(XC[0]);
			String C = XC[1];

			while (result < X) {
				result++;
				int[] head = queue.peekLast();

				int r = head[0] + dr[direction];
				int c = head[1] + dc[direction];

				if (r >= 0 && r < N && c >= 0 && c < N && board[r][c] != 2) {

					if (board[r][c] != 1) {
						int[] tail = queue.pollFirst();
						board[tail[0]][tail[1]] = 0;
					}
					
					board[r][c] = 2;
					queue.add(new int[] { r, c });

				} else {
					check = false;
					break;
				}

			}
			
			if(C.equals("L")) {
				direction = (direction+3)%4;
			}else {
				direction = (direction+1)%4;
			}
			
			
		}

		if (check) {
			while (true) {
				result++;
				
				int[] head = queue.peekLast();

				int r = head[0] + dr[direction];
				int c = head[1] + dc[direction];

				if (r >= 0 && r < N && c >= 0 && c < N && board[r][c] != 2) {

					if (board[r][c] != 1) {
						int[] tail = queue.pollFirst();
						board[tail[0]][tail[1]] = 0;
					}
					
					board[r][c] = 2;
					queue.add(new int[] { r, c });

				} else {
					break;
				}

				
			}
			
		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}