import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] ABC = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };

		int N = Integer.parseInt(br.readLine());

		double[] v = new double[N];

		String[] s = br.readLine().split("");

		Stack<Double> value = new Stack<>();

		for (int i = 0; i < N; i++) {
			v[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < s.length; i++) {

			int select = Arrays.asList(ABC).indexOf(s[i]);

			if (select == -1) {
				double first = value.pop();
				double second = value.pop();

				double nv = 0;

				switch (s[i]) {

				case "*":
					nv = first * second;
					break;

				case "/":
					nv = second / first;
					break;
				
				case "+":
					nv = first + second;
					break;
				
				case "-":
					nv = second - first;
					break;
				}
				
				value.push(nv);

			} else {
				value.push(v[select]);
			}
		}

		sb.append(String.format("%.2f", value.pop()));

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}