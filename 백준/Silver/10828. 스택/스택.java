import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {

			String[] order = br.readLine().split(" ");

			if (order[0].equals("push")) {
				deque.addLast(Integer.parseInt(order[1]));
			} else if (order[0].equals("top")) {
				sb.append(deque.size() == 0 ? -1 : deque.peekLast()).append("\n");
			} else if (order[0].equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if (order[0].equals("empty")) {
				sb.append(deque.size() == 0 ? 1 : 0).append("\n");
			} else if (order[0].equals("pop")) {
				sb.append(deque.size() == 0 ? -1 : deque.pollLast()).append("\n");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}