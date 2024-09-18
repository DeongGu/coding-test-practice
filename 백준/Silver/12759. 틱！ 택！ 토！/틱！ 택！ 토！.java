import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String firstMember = br.readLine();
		String secondMember = firstMember.equals("1") ? "2" : "1";

		String[][] matrix = new String[3][3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(matrix[i][j] == null) matrix[i][j] = "0";
			}
		}
		
		String result = "0";

		boolean end = false;

		for (int i = 0; i < 9; i++) {

			String[] RC = br.readLine().split(" ");

			int R = Integer.parseInt(RC[0]);
			int C = Integer.parseInt(RC[1]);

			matrix[R - 1][C - 1] = i % 2 == 0 ? firstMember : secondMember;

			if (i >= 5) {

				if (i % 2 == 0) {
					for (int r = 0; r < 3; r++) {
						String check = String.join("", matrix[r]);

						if (check.equals(firstMember.repeat(3))) {
							result = firstMember;
							sb.append(result);
							end = true;
							break;
						}
					}

					if (end)
						break;

					for (int c = 0; c < 3; c++) {

						boolean check = true;

						for (int r = 0; r < 3; r++) {

							if (!matrix[r][c].equals(firstMember)) {
								check = false;
								break;
							}
						}

						if (check) {
							end = true;
							result = firstMember;
							sb.append(result);
							break;
						}
					}

					if (end)
						break;

					if (matrix[0][0].equals(firstMember) && matrix[1][1].equals(firstMember)
							&& matrix[2][2].equals(firstMember)) {
						end = true;
						result = firstMember;
						sb.append(result);
						break;
					}

					if (matrix[0][2].equals(firstMember) && matrix[1][1].equals(firstMember)
							&& matrix[2][0].equals(firstMember)) {
						end = true;
						result = firstMember;
						sb.append(result);
						break;
					}

				} else {

					for (int r = 0; r < 3; r++) {
						String check = String.join("", matrix[r]);

						if (check.equals(secondMember.repeat(3))) {
							result = secondMember;
							sb.append(result);
							end = true;
							break;
						}
					}

					if (end)
						break;

					for (int c = 0; c < 3; c++) {

						boolean check = true;

						for (int r = 0; r < 3; r++) {

							if (!matrix[r][c].equals(secondMember)) {
								check = false;
								break;
							}
						}

						if (check) {
							end = true;
							result = secondMember;
							sb.append(result);
							break;
						}
					}

					if (end)
						break;

					if (matrix[0][0].equals(secondMember) && matrix[1][1].equals(secondMember)
							&& matrix[2][2].equals(secondMember)) {
						end = true;
						result = secondMember;
						sb.append(result);
						break;
					}

					if (matrix[0][2].equals(secondMember) && matrix[1][1].equals(secondMember)
							&& matrix[2][0].equals(secondMember)) {
						end = true;
						result = secondMember;
						sb.append(result);
						break;
					}

				}

			}
		}

		if (result.equals("0"))
			sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}