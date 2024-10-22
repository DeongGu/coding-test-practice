import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		HashMap<Long, Long> map = new HashMap<>();
		long result = Long.MIN_VALUE;
		long count = 0;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {

			long num = Long.parseLong(br.readLine());

			if (map.isEmpty()) {
				map.put(num, (long) 1);
				result = num;
				count = 1;
			} else if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);

				if (count < map.get(num)) {
					count = map.get(num);
					result = num;
				} else if (count == map.get(num)) {
					result = result > num ? num : result;
				}
				;
			} else {
				map.put(num, (long) 1);
				if (count < map.get(num)) {
					count = map.get(num);
					result = num;
				} else if (count == map.get(num)) {
					result = result > num ? num : result;
				}
				;
			}
		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}