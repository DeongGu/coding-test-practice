import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		String[] A = br.readLine().split(" ");
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(A[i]));
		}
		
		Collections.sort(list);
		
		sb.append(list.get(K-1));
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}