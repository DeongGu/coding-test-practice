import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<int[]> list = new LinkedList<>();

		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		List<Integer> C = new ArrayList<>();

		for (int tc = 0; tc < n; tc++) {

			String[] TNM = br.readLine().split(" ");
			int T = Integer.parseInt(TNM[0]);
			int N = Integer.parseInt(TNM[1]);
			int M = T == 2 ? Integer.parseInt(TNM[1]) : Integer.parseInt(TNM[2]);
			
			if (T == 1) {
				list.add(new int[] { N, M });
			} else {

				int[] first = list.get(0);
				if (first[1] == M) {
					A.add(first[0]);
				} else {
					B.add(first[0]);
				}
				
				list.remove(0);

			}

		}

		while (!list.isEmpty()) {
			C.add(list.get(0)[0]);
			list.remove(0);
		}
		
		if(A.isEmpty()) {
			sb.append("None");
		}else {
			Collections.sort(A);
			for(int num : A) sb.append(num).append(" ");
		}
		
		sb.append("\n");

		if(B.isEmpty()) {
			sb.append("None");
		}else {
			Collections.sort(B);
			for(int num : B) sb.append(num).append(" ");
		}
		
		sb.append("\n");
		
		if(C.isEmpty()) {
			sb.append("None");
		}else {
			Collections.sort(C);
			for(int num : C) sb.append(num).append(" ");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}