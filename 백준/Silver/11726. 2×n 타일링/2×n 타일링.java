import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		long first = 1;
		long second = 2;

		long result = 0;

		if (n == 1) {
			result = 1;
		} else if (n == 2) {
			result = 2;
		} else {

			for (int i = 2; i < n; i++) {
				result = first + second;
				result %= 10007;
				first = second;
				second = result;

			}

		}

		sb.append(result % 10007);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}