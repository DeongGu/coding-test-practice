import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		while(deque.size() > 1) {			
			sb.append(deque.pollFirst()).append(" ");
			deque.add(deque.pollFirst());
		}

		sb.append(deque.pop());
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}