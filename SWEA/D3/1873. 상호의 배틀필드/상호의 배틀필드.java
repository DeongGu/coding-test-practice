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
			String[] HW = br.readLine().split(" ");

			int H = Integer.parseInt(HW[0]);
			int W = Integer.parseInt(HW[1]);

			String[][] map = new String[H][W];

			int cr = -1;
			int cc = -1;

			for (int r = 0; r < H; r++) {

				String[] el = br.readLine().split("");

				for (int c = 0; c < W; c++) {

					map[r][c] = el[c];

					if (el[c].equals("<") || el[c].equals(">") || el[c].equals("v") || el[c].equals("^")) {
						cr = r;
						cc = c;
					}
				}

			}

			int N = Integer.parseInt(br.readLine());

			String[] in = br.readLine().split("");

			for (int i = 0; i < N; i++) {
				if (in[i].equals("U")) {

					map[cr][cc] = "^";

					if (cr - 1 >= 0 && map[cr - 1][cc].equals(".")) {
						map[cr - 1][cc] = "^";
						map[cr][cc] = ".";
						cr -= 1;
					}
				} else if (in[i].equals("D")) {

					map[cr][cc] = "v";

					if (cr + 1 < H && map[cr + 1][cc].equals(".")) {
						map[cr + 1][cc] = "v";
						map[cr][cc] = ".";
						cr += 1;
					}

				} else if (in[i].equals("L")) {

					map[cr][cc] = "<";

					if (cc - 1 >= 0 && map[cr][cc - 1].equals(".")) {
						map[cr][cc - 1] = "<";
						map[cr][cc] = ".";
						cc -= 1;
					}
				} else if (in[i].equals("R")) {

					map[cr][cc] = ">";

					if (cc + 1 < W && map[cr][cc + 1].equals(".")) {
						map[cr][cc + 1] = ">";
						map[cr][cc] = ".";
						cc += 1;
					}

				} else if (in[i].equals("S")) {
					if (map[cr][cc].equals("<")) {
						for (int j = cc - 1; j >= 0; j--) {
							if (map[cr][j].equals("#")) break;
							if (map[cr][j].equals("*")) {
								map[cr][j] = ".";
								break;
							}
						}
					} else if (map[cr][cc].equals(">")) {
						for (int j = cc + 1; j < W; j++) {
							if (map[cr][j].equals("#")) break;
							if (map[cr][j].equals("*")) {
								map[cr][j] = ".";
								break;
							}
						}
					} else if (map[cr][cc].equals("^")) {
						for (int j = cr - 1; j >= 0; j--) {
							if (map[j][cc].equals("#")) break;
							if (map[j][cc].equals("*")) {
								map[j][cc] = ".";
								break;
							}
						}
					} else if (map[cr][cc].equals("v")) {
						for (int j = cr + 1; j < H; j++) {
							if (map[j][cc].equals("#")) break;
							if (map[j][cc].equals("*")) {
								map[j][cc] = ".";
								break;
							}
						}
					}
				}

			}

			sb.append("#").append(tc + 1).append(" ");

			for (int r = 0; r < H; r++) {

				for (int c = 0; c < W; c++) {

					sb.append(map[r][c]);

				}

				sb.append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}