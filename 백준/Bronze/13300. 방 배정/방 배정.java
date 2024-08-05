import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().trim().split(" ");

		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		int[][] room = new int[2][6];

		int count = 0;

		for (int i = 0; i < N; i++) {
			String[] info = br.readLine().trim().split(" ");

			int gender = Integer.parseInt(info[0]);
			int grade = Integer.parseInt(info[1]) - 1;

			room[gender][grade]++;

		}
		for(int i = 0; i < 6; i++) {
			if(room[1][i] != 0) {
				if(room[1][i]/K == 0 && room[1][i] % K != 0) {
					count++;
				}else if(room[1][i]%K ==0) {
					count+= room[1][i]/K;
				}else {
					count += (room[1][i]/K) + 1;						
				}
			}
		}

        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}