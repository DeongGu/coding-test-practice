import java.io.*;
import java.util.Arrays;

public class Main {
 public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] inputArr = new int[9];

        for (int t = 0; t < 9; t++) {
            int n = Integer.parseInt(br.readLine());
            inputArr[t] = n;
        }

        int removeIdx1 = -1;
        int removeIdx2 = -1;

        outerLoop:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        sum += inputArr[k];
                    }
                }
                if (sum == 100) {
                    removeIdx1 = i;
                    removeIdx2 = j;
                    break outerLoop;
                }
            }
        }

        int resultIdx = 0;
        int[] result = new int[7];

        for (int i = 0; i < 9; i++) {
            if (i == removeIdx1 || i == removeIdx2)
                continue;
            result[resultIdx++] = inputArr[i];
        }

        Arrays.sort(result);

        for (int i = 0; i < 7; i++) {
            sb.append(result[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
