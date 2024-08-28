import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();


		for (int tc = 0; tc < 10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			
			String[] boxesStr = br.readLine().split(" ");
			int[] boxes = new int[100];
			
			for(int i = 0; i < 100; i++) {
				boxes[i] = Integer.parseInt(boxesStr[i]);
			}
			
			while(dump != 0) {
				
				boxes[0]++;
				boxes[99]--;
				
				Arrays.sort(boxes);
				dump--;
			}
		
			int result = boxes[99] - boxes[0];
			
			
			sb.append("#").append(tc+1).append(" ").append(result).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}