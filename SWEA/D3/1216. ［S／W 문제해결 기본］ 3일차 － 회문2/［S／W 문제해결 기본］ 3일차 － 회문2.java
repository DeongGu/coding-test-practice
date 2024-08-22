import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int T = 0; T < 10; T++) {
			int t = Integer.parseInt(br.readLine());
			int max = 0;

			String[][] matrix = new String[100][100];

			for (int r = 0; r < 100; r++) {
				String[] str = br.readLine().split("");

				for (int c = 0; c < 100; c++) {
					matrix[r][c] = str[c];
				}

				for (int i = 0; i < 100; i++) {

					for (int j = i; j < 100; j++) {
						boolean check = true;

						for (int k = 0; k < (j - i + 1) / 2; k++) {

							if (!str[i + k].equals(str[j - k])) {
								check = false;
								break;
							}

						}

						if (check) {
							max = Math.max(max, j - i + 1);
						}

					}
				}

			}

			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 100; r++) {

					for (int i = r; i < 100; i++) {
						boolean check = true;

						for (int k = 0; k < (i - r + 1) / 2; k++) {

							if (!matrix[r + k][c].equals(matrix[i - k][c])) {
								check = false;
								break;
							}
						}
						if (check) {
							max = Math.max(max, i - r + 1);
						}
					}

				}
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");

		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}