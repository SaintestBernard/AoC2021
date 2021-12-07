import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//SaintBernard
public class Day7 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
		String str;
		BufferedReader in;
		in = new BufferedReader(new FileReader("crabData.txt"));
		str = in.readLine();
		String[] cronb = str.split(",");
		
		int[] crabs = new int[cronb.length];
		for(int i = 0; i<cronb.length; i++) crabs[i] = Integer.parseInt(cronb[i]);
		
		int low = 0;
		int high = 0;
		for(int i = 0; i<crabs.length; i++){
			if(crabs[i] < low) low=crabs[i];
			if(crabs[i] > high) high=crabs[i];
		}
		
		int min = 0;
		int pos = 0;
		for(int i = low; i<high; i++){
			int temp = 0;
			int temptat = 0;
			for(int j = 0; j<crabs.length;j++){
				if(crabs[j] > i) for(int k = 0; k<crabs[j]-i+1; k++) temptat+=k; 
				else for(int k = 0; k<i-crabs[j]+1; k++) temptat+=k; 
				temp += temptat;
				temptat = 0;
			}
			if(i == low)min = temp;
			else if(temp < min) {min = temp;
			pos = i;}
		}
		System.out.println(pos);
		System.out.println(min);
	}
}
