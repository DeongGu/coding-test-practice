import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] alph = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z" };

		String[] S = br.readLine().split("");

		for (int i = 0; i < S.length; i++) {

			if (S[i].trim().length() == 0) {
				sb.append(S[i]);
			}else if(isNum(S[i])) {
				sb.append(S[i]);
			} else if (S[i].equals(S[i].toLowerCase())) {
				sb.append(alph[(Arrays.asList(alph).indexOf(S[i]) + 13) % 26]);
			} else {
				sb.append(alph[(Arrays.asList(alph).indexOf(S[i].toLowerCase()) + 13) % 26].toUpperCase());
			}

		}

		bw.write(sb.toString());
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