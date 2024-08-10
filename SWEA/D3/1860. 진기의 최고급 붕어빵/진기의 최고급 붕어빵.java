import java.io.*;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String result = "Possible";
            String[] NMK = br.readLine().trim().split(" ");

            int N = Integer.parseInt(NMK[0]);
            int M = Integer.parseInt(NMK[1]);
            int K = Integer.parseInt(NMK[2]);

            String[] timeSArr = br.readLine().trim().split(" ");
            int[] timeNArr = new int[timeSArr.length];

            for (int i = 0; i < timeSArr.length; i++) {
                timeNArr[i] = Integer.parseInt(timeSArr[i]);
            }

            Arrays.sort(timeNArr);

            int time = 0;
            int breadCount = 0;

            // 모든 손님에 대해 처리
            for (int i = 0; i < N; i++) {
                int customerTime = timeNArr[i];

                // 손님이 도착할 때까지 붕어빵 생산
                while (time < customerTime) {
                    time++;
                    if (time % M == 0) {
                        breadCount += K;
                    }
                }

                // 손님에게 붕어빵 제공
                if (breadCount > 0) {
                    breadCount--;
                } else {
                    result = "Impossible";
                    break;
                }
            }

            sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}