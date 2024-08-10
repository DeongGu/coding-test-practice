import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < T; tc++) {
        	
        	String[] a = br.readLine().split(" ");
        	String[] b = br.readLine().split(" ");
        	
        	String result = "D";
        	
        	int[] aCount = new int[4];
        	int[] bCount = new int[4];
        	
        	for(int i = 1; i < a.length; i++) {        		
        		aCount[4-Integer.parseInt(a[i])]++;
        	}
        	
        	for(int i = 1; i < b.length; i++) {
        		bCount[4-Integer.parseInt(b[i])]++;
        	}
        	
        	for(int i = 0; i < 4; i++) {
        		
        		if(aCount[i] > bCount[i]) {
        			result = "A";
        			break;
        		}else if(aCount[i] < bCount[i]) {
        			result = "B";
        			break;
        		}else if(aCount[i] == bCount[i]) {
        			continue;        			
        		}
        		
        	}
        	
        	
        	sb.append(result).append("\n");
        }
            
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}