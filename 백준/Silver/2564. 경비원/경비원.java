import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] wh = br.readLine().split(" ");

		int w = Integer.parseInt(wh[0]);
		int h = Integer.parseInt(wh[1]);

		int shopCount = Integer.parseInt(br.readLine()) + 1;

		int[][] matrix = new int[shopCount][2];

		for (int c = 0; c < shopCount; c++) {
			String[] location = br.readLine().split(" ");

			int direction = Integer.parseInt(location[0]);
			int distance = Integer.parseInt(location[1]);

			if (direction == 1) {
				matrix[c][0] = distance;
				matrix[c][1] = h;

			} else if (direction == 2) {
				matrix[c][0] = distance;
				matrix[c][1] = 0;

			} else if (direction == 3) {

				matrix[c][0] = 0;
				matrix[c][1] = h - distance;

			} else {
				matrix[c][0] = w;
				matrix[c][1] = h - distance;
			}

		}

		int[] currentLocation = matrix[shopCount - 1];

		int sum = 0;

		for (int i = 0; i < shopCount-1; i++) {

			if (currentLocation[0] == 0) {

				if (matrix[i][1] == 0 && matrix[i][0] != w) {
					
					sum+= matrix[i][0];
					sum+= currentLocation[1];
					
				} else if (matrix[i][1] == h && matrix[i][0] != w) {
					
					sum+= matrix[i][0];
					sum+= h - currentLocation[1];
					
				} else if(matrix[i][0] == w){
					
					int first = h - currentLocation[1] + w + h - matrix[i][1]; 
					int second = currentLocation[1] + w + matrix[i][1]; 
					
					sum+= Math.min(first, second);
					
				}else {
					sum+= Math.abs(currentLocation[1] - matrix[i][1]);
				}

			} else if (currentLocation[1] == 0) {

				if (matrix[i][0] == 0 &&  matrix[i][1] != h) {
					sum+= currentLocation[0];
					sum+= matrix[i][1];
					
				} else if (matrix[i][0] == w &&  matrix[i][1] != h) {

					sum += w - currentLocation[0];
					sum += matrix[i][1];
					
				} else if(matrix[i][1] == h) {
					
					int first = w - currentLocation[0] + h + w - matrix[i][0]; 
					int second = currentLocation[0] + h + matrix[i][0]; 
					
					sum+= Math.min(first, second);

				}else {
					sum+= Math.abs(currentLocation[0] - matrix[i][0]);
				}

			} else if (currentLocation[0] == w) {

				if (matrix[i][1] == 0 && matrix[i][0] != 0) {

					sum += w - matrix[i][0];
					sum += currentLocation[1];
					
				} else if (matrix[i][1] == h && matrix[i][0] != 0) {

					sum += h - currentLocation[1];
					sum += w - matrix[i][0];
					
				} else if(matrix[i][0] == 0) {
					
					int first = h - currentLocation[1] + w + h - matrix[i][1]; 
					int second = currentLocation[1] + w + matrix[i][1]; 
					
					sum+= Math.min(first, second);

				}else {
					sum+= Math.abs(currentLocation[1] - matrix[i][1]);
				}

			} else if (currentLocation[1] == h) {

				if (matrix[i][0] == 0 && matrix[i][1] != 0) {

					sum += currentLocation[0];
					sum += h - matrix[i][1];
					
				} else if (matrix[i][0] == w && matrix[i][1] != 0) {

					sum += w - currentLocation[0];
					sum += h - matrix[i][1];
					
				} else if(matrix[i][1] == 0) {
					
					int first = w - currentLocation[0] + h + w - matrix[i][0]; 
					int second = currentLocation[0] + h + matrix[i][0]; 
					
					sum+= Math.min(first, second);
				}else {
					sum+= Math.abs(currentLocation[0] - matrix[i][0]);
				}
			}
		}
		
		sb.append(sum);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}