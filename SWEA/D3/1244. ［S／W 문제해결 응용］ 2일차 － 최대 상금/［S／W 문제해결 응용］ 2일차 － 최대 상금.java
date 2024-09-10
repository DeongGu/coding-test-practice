import java.io.*;

public class Solution {

	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			result = 0;

			String[] info = br.readLine().split(" ");
			String[] numInfo = info[0].split("");
			int maxChangeCount = Integer.parseInt(info[1]);

			recursion(numInfo, maxChangeCount, 0);

			sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

	static void recursion(String[] arr, int count, int start) {
		String currentState = String.join("", arr);

		if (count == 0) {
			result = Math.max(result, Integer.parseInt(currentState));
			return;
		}

		for (int i = start; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				
				if(i == j) continue;
				
				swap(arr, i, j);
				recursion(arr, count - 1, (start+1)%(arr.length-1));
				swap(arr, i, j);
			}
		}
	}

	static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}