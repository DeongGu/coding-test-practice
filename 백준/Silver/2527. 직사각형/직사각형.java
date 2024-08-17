import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for(int tc = 0; tc < 4; tc++) {			
			String[] arr = br.readLine().split(" ");
			
			int x1 = Integer.parseInt(arr[0]);
			int y1 = Integer.parseInt(arr[1]);
			int x2 = Integer.parseInt(arr[2]);
			int y2 = Integer.parseInt(arr[3]);
			int a1 = Integer.parseInt(arr[4]);
			int b1 = Integer.parseInt(arr[5]);
			int a2 = Integer.parseInt(arr[6]);
			int b2 = Integer.parseInt(arr[7]);
			
			String result = "a";
			
			
			if(x2 < a1 || b1 > y2 || a2 < x1 || b2 < y1) {
				result = "d";
			}else if((a1 == x2 && b1 == y2) || (a1 == x2 && b2 == y1) || (x1 == a2 && y1 == b2) || (b1 == y2 && a2 == x1)) {
				result = "c";
			}else if(x2 == a1 || b1 == y2 || x1 == a2 || b2 == y1) {
				result ="b";
			}
				
			sb.append(result).append("\n");
		}

		

		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}