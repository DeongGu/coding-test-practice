import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] xy = br.readLine().split(" ");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
		
		String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int day =  0;
		
		for(int i = 0; i < x; i++) {
			day+= month[i];
		}
		
		day+= y;
		sb.append(days[day%7]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}