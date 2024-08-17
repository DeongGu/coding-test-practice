import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		String[] arr = br.readLine().split(" ");

		int start = 0;
		int end = 0;

		int maxLen1 = 1;
		int maxLen2 = 1;

		int check = Integer.parseInt(arr[0]);

		for (int i = 0; i < N; i++) {

			if (check > Integer.parseInt(arr[i])) {
				maxLen1 = Math.max(maxLen1, end - start + 1);
				start = i;
				end = i;
			} else {
				end = i;
			}

			check = Integer.parseInt(arr[i]);
		}
		
		maxLen1 = Math.max(maxLen1, end - start + 1);

		check = Integer.parseInt(arr[0]);
		start = 0;
		end = 0;
		
		for (int i = 0; i < N; i++) {

			if (check < Integer.parseInt(arr[i])) {
				maxLen2 = Math.max(maxLen2, end - start +1);
				start = i;
				end = i;
			} else {
				end = i;
			}
			check = Integer.parseInt(arr[i]);
		}
		maxLen2 = Math.max(maxLen2, end - start +1);

		sb.append(Math.max(maxLen1, maxLen2));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}