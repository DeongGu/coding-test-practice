import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());

		ArrayList<Integer> order = new ArrayList<>();

		int rowMax = 0;
		int colMax = 0;

		for (int i = 0; i < 6; i++) {
			String[] info = br.readLine().split(" ");

			int direction = Integer.parseInt(info[0]);
			int length = Integer.parseInt(info[1]);
			
			order.add(length);

			if (direction == 1 || direction == 2) {
				rowMax = Math.max(rowMax, length);
			} else {
				colMax = Math.max(colMax, length);
			}
		}

		int rowCheck = order.indexOf(rowMax);
		int colCheck = order.indexOf(colMax);
		
		int rowMaxPrev = rowCheck-1 < 0 ? order.size()-1 : rowCheck-1;
		int rowMaxNext = rowCheck+1 > order.size()-1 ? 0 : rowCheck+1;
		
		int colMaxPrev = colCheck-1 < 0 ? order.size()-1 : colCheck-1;
		int colMaxNext = colCheck+1 > order.size()-1 ? 0 : colCheck+1;
		
		int substractRow  = rowMax - Math.min(order.get(colMaxPrev), order.get(colMaxNext));
		int substractCol  = colMax - Math.min(order.get(rowMaxPrev), order.get(rowMaxNext));
		
		int result = K * (rowMax * colMax - substractRow * substractCol);

		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
