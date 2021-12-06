import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//SaintBernard
public class Day3 {
	public static void main(String[] args) throws IOException {
		
		List<String> pos = new ArrayList<String>();
		List<String> nos = new ArrayList<String>();
		List<String> lint = new ArrayList<String>();
		String str;
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new FileReader("binarycodes.txt"));
		
		while((str = in.readLine()) != null){ lint.add(str); pos.add(str); nos.add(str);}
		
		String[] lints = new String[lint.size()];
		
		for(int i = 0; i < lint.size(); i++) { lints[i] = lint.get(i);}
		
		char car;
		
		for(int i = 0, jay, nay; i < 12 && pos.size() > 1; i++) {
			jay = 0; nay = 0;
			
			for(int j = 0; j < pos.size(); j++){
				car = pos.get(j).charAt(i);
				if(car == '1') { jay++; }
				else { nay++; }
			}
			
			if( jay >= nay ) {				
				for(int j = 0; j < pos.size() && pos.size() > 1; j++){
					car = pos.get(j).charAt(i);
					
					if(car != '1'){
						pos.remove(j);
						j--;
			} 	} 	}
			else {				
				for(int j = 0; j < pos.size() && pos.size() > 1; j++){
					car = pos.get(j).charAt(i);
					if(car != '0'){
						pos.remove(j);
						j--;
			} 	} 	}
			}
		
		for(int i = 0, jay, nay; i < 12 && nos.size() > 1; i++) {
			jay = 0; nay = 0;
			
			for(int j = 0; j < nos.size(); j++){
				car = nos.get(j).charAt(i);
				if(car == '1') { jay++; }
				else { nay++; }
			}
			if( jay < nay ) {				
				for(int j = 0; j < nos.size() && nos.size() > 1; j++){
					car = nos.get(j).charAt(i);
					
					if(car != '1'){
						nos.remove(j);
						j--;
			} 	} 	}
			else {				
				for(int j = 0; j < nos.size() && nos.size() > 1; j++){
					car = nos.get(j).charAt(i);
					if(car != '0'){
						nos.remove(j);
						j--;
			} 	} 	}			
			}
			System.out.println(pos);
			System.out.println(nos);
			
		}
		
		/* Part 1
		Integer[] binTotes = new Integer[12];
		Integer[] binTotesRev = new Integer[12];
		
		for(int i = 0; i < binTotes.length; i++){ binTotes[i] = 0; }
		for(int i = 0; i < binTotesRev.length; i++){ binTotesRev[i] = 0; }
		
		for(int i = 0; i < lints.length; i++) {
			for(int j = 0; j < lints[i].length(); j++){
				car = lints[i].charAt(j);
				if(car == '1'){ binTotes[j]++; }
				else{ binTotesRev[j]++; }		
			}
		}
		
		Integer[] tote1 = new Integer[12];
		Integer[] tote2 = new Integer[12];
		for(int i = 0; i < tote1.length; i++){ tote1[i] = 0; }
		for(int i = 0; i < tote2.length; i++){ tote2[i] = 0; }
		
		for(int i = 0; i < binTotes.length; i++) {
			if(binTotes[i] > binTotesRev[i]) { tote1[i] = 1; }
			else { tote2[i] = 1; }
		}
		
		for(int i = 0; i < 12; i++){ System.out.print(binTotes[i]+ " "); }
		System.out.println("");
		for(int i = 0; i < 12; i++){ System.out.print(binTotesRev[i]+ " "); }
		System.out.println("");
		for(int i = 0; i < 12; i++){ System.out.print(tote1[i]); }
		System.out.println("");
		for(int i = 0; i < 12; i++){ System.out.print(tote2[i]); }
		}
		*/
	

}
