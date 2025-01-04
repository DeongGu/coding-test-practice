import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] s = br.readLine().split("");

		int result = 0;

		int ref = 0;

		for (int i = 0; i < s.length; i++) {

			if (s[i].equals("(")) {
				ref++;
			} else {
				ref--;

				if (s[i - 1].equals("(")) {
					result += ref;
				} else {
					result++;
				}
			}
		}

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}