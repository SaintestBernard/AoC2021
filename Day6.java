import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//SaintBernard
public class Day6 {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {
		
		String str;
		BufferedReader in;
		in = new BufferedReader(new FileReader("FishData.txt"));
		long[] fesh = new long[9];
		str = in.readLine();
		String[] rawFish = str.split(",");
		
		for(int i = 0, j = 0; i<rawFish.length; i++){ j = Integer.parseInt(rawFish[i]);
			fesh[j]++; }
		long temp = 0;
		for(int i = 0; i<256; i++){
			temp = fesh[0];
			for(int j = 1; j<9; j++){ fesh[j-1] = fesh[j]; }
			fesh[6] += temp;
			fesh[8] = temp;
		}
		long tote = 0;
		for(int i = 0; i<9; i++){tote+=fesh[i];}
		
		System.out.println(tote);
		
		
		/* part 1
		for(int i = 0; i<256; i++){
			for(int j = 0;j<fesh.size(); j++){
				if(fesh.get(j) == 0){ 
					fesh.add(9); 
					fesh.set(j, 7);
				}
				fesh.set(j, fesh.get(j)-1);
			}
		}
		System.out.println(tote);*/
	}

}
