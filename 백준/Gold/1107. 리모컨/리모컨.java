import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int result = Math.abs(N - 100);

		boolean[] btn = new boolean[10];

		int M = Integer.parseInt(br.readLine());

		if (M > 0) {
			String[] nbtn = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				btn[Integer.parseInt(nbtn[i])] = true;
			}
		}

		for (int i = 0; i <= 999999; i++) {
			String[] check = Integer.toString(i).split("");
			boolean isValid = true;

			for (int j = 0; j < check.length; j++) {
				if (btn[Integer.parseInt(check[j])]) {
					isValid = false;
					break;
				}
			}

			if (isValid) {
				result = Math.min(result, Math.abs(i - N) + check.length);
			}
		}

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}