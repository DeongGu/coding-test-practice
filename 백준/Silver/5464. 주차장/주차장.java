import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");

		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[] Rs = new int[N];
		int[] Wk = new int[M];

		long result = 0;

		List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			Rs[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			Wk[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < M * 2; i++) {
			int carNum = Integer.parseInt(br.readLine());
			if (carNum > 0) {

				boolean check = false;
				for(int j = 0; j < N; j++) {
					
					if(list.get(j) == 0) {
						
						list.set(j, carNum);
						result+= Rs[j] * Wk[carNum - 1];
						check = true;
						break;
					}
					
				}
				
				if(!check) {
					deque.add(carNum);
				}
				
	
			} else {
				int exitCarNum = -carNum;
				int exitCarNumIdx = list.indexOf(exitCarNum);
				
				if(!deque.isEmpty()) {
					
					int waitCarNum = deque.pollFirst();
					list.set(exitCarNumIdx, waitCarNum);
					result+= Rs[exitCarNumIdx] * Wk[waitCarNum - 1];
					
				}else {
					list.set(exitCarNumIdx, 0);
				}

			}
		}
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}