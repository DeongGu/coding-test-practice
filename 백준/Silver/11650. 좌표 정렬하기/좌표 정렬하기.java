import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String[] xy = br.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);

			list.add(new int[] { x, y });
		}
		
		Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(int[] n1, int[] n2) {
				
				if(n1[0] == n2[0]) {
					return Integer.compare(n1[1], n2[1]);
				}else {					
					return Integer.compare(n1[0], n2[0]);
				}
			}
		});

		for(int[] xy : list) {
			sb.append(xy[0]).append(" ").append(xy[1]).append("\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}