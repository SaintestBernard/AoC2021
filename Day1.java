import java.io.*;
import java.util.ArrayList;
import java.util.List;
//SaintBernard
public class Day1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		List<String> lint = new ArrayList<String>();
		String str;
		
		BufferedReader in = new BufferedReader(new FileReader("numbas.txt"));
		
		while((str = in.readLine()) != null){
			lint.add(str);
		}
		
		
		int[] lints = new int[lint.size()];
		for(int i = 0; i < lint.size(); i++) {
			lints[i] = Integer.parseInt(lint.get(i));
		}
		
		
		int total = 0;
		
		//Part 1
		for(int i = 0, j = 1; j<(lints.length); i++, j++){
			if(lints[j] > lints[i])
			{total++;};
		}
		
		System.out.println(total);
		total = 0;
		
		
		//part 2
		for(int i = 1, j = 1, a = 0, b = 0; j<(lints.length-2); i++, j++){
			a = lints[i]+lints[i+1]+lints[i+2];
			b = lints[j]+lints[j+1]+lints[j+2];
			if(b>a){
			total++;
			}
			a = 0;
			b = 0;
		}
			
		System.out.println(total);
	}

}
