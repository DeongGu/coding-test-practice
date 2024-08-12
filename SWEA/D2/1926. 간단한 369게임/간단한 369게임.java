import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			
			String[] nums = Integer.toString(i).split("");
			String clap = "";
			
			for(int j = 0; j < nums.length; j++) {
				if(nums[j].equals("3") || nums[j].equals("6") || nums[j].equals("9")) {
					clap += "-";
				}
			}
			
			if(clap.length() == 0) {				
				sb.append(i).append(" ");
			}else {
				sb.append(clap).append(" ");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	
	}
}