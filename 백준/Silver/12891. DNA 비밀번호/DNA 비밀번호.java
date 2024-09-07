import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] SP = br.readLine().split(" ");

		int S = Integer.parseInt(SP[0]);
		int P = Integer.parseInt(SP[1]);

		String[] tmp = br.readLine().split("");
		String[] minCountStr = br.readLine().split(" ");
		int[] minCount = new int[4];

		for (int i = 0; i < 4; i++)
			minCount[i] = Integer.parseInt(minCountStr[i]);

		int result = 0;

		int[] check = new int[4];

		for (int i = 0; i < P; i++) {
			if (tmp[i].equals("A"))
				check[0]++;
			if (tmp[i].equals("C"))
				check[1]++;
			if (tmp[i].equals("G"))
				check[2]++;
			if (tmp[i].equals("T"))
				check[3]++;

		}

		if (check[0] >= minCount[0] && check[1] >= minCount[1] && check[2] >= minCount[2] && check[3] >= minCount[3])
			result++;

		int startIdx = 0;
		int endIdx = P - 1;

		while (endIdx < S - 1) {

			if (tmp[startIdx].equals("A"))
				check[0]--;
			if (tmp[startIdx].equals("C"))
				check[1]--;
			if (tmp[startIdx].equals("G"))
				check[2]--;
			if (tmp[startIdx].equals("T"))
				check[3]--;

			startIdx++;
			endIdx++;

			if (tmp[endIdx].equals("A"))
				check[0]++;
			if (tmp[endIdx].equals("C"))
				check[1]++;
			if (tmp[endIdx].equals("G"))
				check[2]++;
			if (tmp[endIdx].equals("T"))
				check[3]++;

			if (check[0] >= minCount[0] && check[1] >= minCount[1] && check[2] >= minCount[2]
					&& check[3] >= minCount[3])
				result++;

		}

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}