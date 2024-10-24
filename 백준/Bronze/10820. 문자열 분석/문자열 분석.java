import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String line;

		while ((line = br.readLine()) != null) {
			int[] result = new int[4];

			String[] S = line.split("");

			for (int i = 0; i < S.length; i++) {

				if (S[i].trim().length() == 0) {
					result[3]++;
				} else if (isNum(S[i])) {
					result[2]++;
				} else if (S[i].equals(S[i].toLowerCase())) {
					result[0]++;
				} else if (S[i].equals(S[i].toUpperCase())) {
					result[1]++;
				}
			}

			for (int i = 0; i < 4; i++) {
				sb.append(result[i]).append(" ");
			}

			sb.append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean isNum(String element) {

		try {
			Integer.parseInt(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}