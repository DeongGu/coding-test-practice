import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] S = br.readLine().split("");

		String[] alph = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z" };

		int[] countArr = new int[26];

		for (int j = 0; j < 26; j++) {
			if (Arrays.asList(S).contains(alph[j])) {
				countArr[j] = Arrays.asList(S).indexOf(alph[j]);
			} else {
				countArr[j] = -1;
			}
		}

		for (int i = 0; i < 26; i++)
			sb.append(countArr[i]).append(" ");

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}