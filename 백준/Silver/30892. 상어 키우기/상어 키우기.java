import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NKT = br.readLine().split(" ");

		int N = Integer.parseInt(NKT[0]);

		int K = Integer.parseInt(NKT[1]);

		long T = Long.parseLong(NKT[2]);

		String[] shark = br.readLine().split(" ");

		List<Long> minList = new ArrayList<>();
		List<Long> maxList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			long target = Long.parseLong((shark[i]));

			if (target >= T) {
				maxList.add(target);
			} else {
				minList.add(target);
			}
		}

		Collections.sort(minList);
		Collections.sort(maxList);

		int minStart = minList.size() - 1;
		int maxStart = maxList.size() - 1;

		while (K > 0) {
			
			
			if (maxList.size() > 0 && T > maxList.get(0)) {

				for (int i = maxStart; i >= 0; i--) {
					if (T > maxList.get(i)) {
						T += maxList.get(i);
						maxList.remove(i);
						maxStart--;
						K--;
						break;
					}
				}

			} else {
				
				if(minList.size() == 0 ) break;
				T += minList.get(minStart);
				minList.remove(minStart);
				minStart--;
				K--;
			}

		}

		sb.append(T);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}