import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//SaintBernard
public class Day2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
		
		List<String> lint = new ArrayList<String>();
		String str;
		
		BufferedReader in = new BufferedReader(new FileReader("coords.txt"));
		
		while((str = in.readLine()) != null){
			lint.add(str);
		}
		
		String[] lints = new String[lint.size()];
		for(int i = 0; i < lint.size(); i++) {
			lints[i] = lint.get(i);
		}
		
		char car;
		char u = 'u';
		char d = 'd';
		
		int vert = 0;
		int horz = 0;
		
		for(int i = 0, j = 0, aim = 0; i < lints.length; i++){
			car = lints[i].charAt(0);
			str = lints[i].substring(lints[i].length() - 1);
			j = Integer.parseInt(str);
		
			if(car == u){ 
				//vert -= j; 
				aim -= j;
			}
			
			else if(car == d){ 
				//vert+= j; 
				aim += j;
			}
			
			else{ 
				horz += j; 
				vert += aim*j;
			}
		}
		
		int total = vert*horz;
		System.out.println(total);
		
		
	}
}
