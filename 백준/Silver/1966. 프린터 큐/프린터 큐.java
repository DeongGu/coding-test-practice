import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);

			String[] docs = br.readLine().split(" ");

			Deque<int[]> queue = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				queue.add(new int[] {Integer.parseInt(docs[i]), i});
			}

			int result = 0;

			
			while(!queue.isEmpty()) {
				
				int[] curr = queue.pollFirst();
				boolean check = false;
				
				for(int[] current : queue) {
					
					if(current[0] > curr[0]) {
						check = true;
						queue.add(curr);
						break;
					}
					
				}
				
				if(!check) {
					result++;
				
					if(curr[1] == M) {
						break;
					}
				}
			}
		

			sb.append(result).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}