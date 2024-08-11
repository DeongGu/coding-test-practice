import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[][] board = new int[5][5];
		int[][] bingo = new int[5][5];

		for (int i = 0; i < 5; i++) {
			String[] nums = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(nums[j]);
			}
		}

		int[] orders = new int[25];
		int ordersIdx = 0;

		for (int i = 0; i < 5; i++) {
			String[] order = br.readLine().split(" ");

			for (int j = 0; j < 5; j++) {
				orders[ordersIdx++] = Integer.parseInt(order[j]);
			}
		}

		for (int i = 0; i < orders.length; i++) {
			int check = orders[i];

			for (int r = 0; r < 5; r++) {

				for (int c = 0; c < 5; c++) {

					if (board[r][c] == check) {
						bingo[r][c] = 1;
					}
					;
				}

			}

			int bingoCount = 0;

			for (int r = 0; r < 5; r++) {
				boolean rowBingo = true;
				for (int c = 0; c < 5; c++) {
					if (bingo[r][c] != 1) {
						rowBingo = false;
						break;
					}
				}
				if (rowBingo)
					bingoCount++;
			}

			for (int c = 0; c < 5; c++) {
				boolean colBingo = true;
				for (int r = 0; r < 5; r++) {
					if (bingo[r][c] != 1) {
						colBingo = false;
						break;
					}
				}
				if (colBingo)
					bingoCount++;
			}

			boolean diag1Bingo = true;
			boolean diag2Bingo = true;

			for (int d = 0; d < 5; d++) {
				if (bingo[d][d] != 1) {
					diag1Bingo = false;
				}
				if (bingo[d][4 - d] != 1) {
					diag2Bingo = false;
				}
			}

			if (diag1Bingo)
				bingoCount++;
			if (diag2Bingo)
				bingoCount++;

			if (bingoCount >= 3) {
				sb.append(i + 1);
				break;
			}

		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}