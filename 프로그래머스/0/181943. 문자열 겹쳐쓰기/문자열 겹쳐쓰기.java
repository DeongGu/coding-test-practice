import java.io.*;

class Solution {
	public String solution(String my_string, String overwrite_string, int s) throws Exception {

		StringBuilder sb = new StringBuilder();

		String[] ms = my_string.split("");
		String[] os = overwrite_string.split("");

		for (int i = 0; i < ms.length; i++) {
			if (i >= s && i - s < os.length) {
				sb.append(os[i - s]);
			} else {
				sb.append(ms[i]);
			}

		}
        
        return sb.toString();

	}
}