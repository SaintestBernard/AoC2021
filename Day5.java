import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//SaintBernard
public class Day5 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
	
		String str;
		BufferedReader in;
		in = new BufferedReader(new FileReader("data.txt"));
		
		Map<Integer, String[][]> coords = new HashMap<>();
		int c = 0;
		str = in.readLine();
		while(str != null){
			String[][] temp = new String[2][2];
			String[][] tempta = new String[2][2];
			
			//jank replacement dw about it
			str = str.replace(" ","");
			str = str.replace(">","");
			tempta[0] = str.split("-");
			temp[0] = tempta[0][0].split(",");
			temp[1] = tempta[0][1].split(",");
			coords.put(c, temp);
			c++;
			str = in.readLine();
		}
	
		String[][] tem;
		Map<Integer, int[][]> coordser = new HashMap<>();
	
		c = 0;
		for(int i = 0, a = 0, b = 0; i<coords.size(); i++){
			int[][] temper = new int[2][2];
			tem = coords.get(i);
		
			for(int j = 0; j<2; j++){ for(int k = 0; k<2; k++){ temper[j][k] = Integer.parseInt(tem[j][k]); } }
		
			a = temper[0][0] - temper[1][0];
			if(a<0)a=-a;
			b = temper[0][1] - temper[1][1];
			if(b<0)b=-b;
			if(tem[0][0].equals(tem[1][0]) || tem[0][1].equals(tem[1][1]) || a == b){ 
				coordser.put(c, temper);
				c++;
			}
		}
	
		int[][] plot = new int[1000][1000];
		for(int i = 0; i<coordser.size(); i++){
			int[][] temm = coordser.get(i);
		
			//Part 2: diags
			int a = temm[0][0] - temm[1][0];
			if(a<0)a=-a;
			int b = temm[0][1] - temm[1][1];
			if(b<0)b=-b;
			if(a == b){
			
				//A is Up
				if(temm[0][1] > temm[1][1]){
					//Up Left to Down Right
					if(temm[0][0] < temm[1][0]){
						while(temm[0][0] <= temm[1][0]){
							plot[temm[0][0]][temm[0][1]]++;
							temm[0][0]++;
							temm[0][1]--;
						}
					}
					//Up Right to Down Left
					else {
						while(temm[0][1] >= temm[1][1]){
							plot[temm[0][0]][temm[0][1]]++;
							temm[0][0]--;
							temm[0][1]--;
						}
					}
				}
				//B is Up
				else if(temm[0][1] < temm[1][1]){
					//Up Left to Down Right
					if(temm[0][0] > temm[1][0]){
						while(temm[0][0] >= temm[1][0]){
							plot[temm[1][0]][temm[1][1]]++;
							temm[1][0]++;
							temm[1][1]--;
						}
					}
					//Up Right to Down Left
					else {
						while(temm[0][0] <= temm[1][0]){
							plot[temm[1][0]][temm[1][1]]++;
							temm[1][0]--;
							temm[1][1]--;
						}
					}
				}			
			
				else System.out.println(i+"- honk- "+temm[0][0]+","+temm[0][1]+" - "+temm[1][0]+","+temm[1][1]);
			}
			
		
		
			//Part 1: horiz \ verts
			else if(temm[0][0] == temm[1][0]){
				if(temm[0][1] < temm[1][1]){
					while(temm[0][1] <= temm[1][1]){
						plot[temm[0][0]][temm[0][1]]++;
						temm[0][1]++;			
					}
				}
				else if(temm[0][1] > (temm[1][1])){
					while(temm[0][1] >= temm[1][1]){
						plot[temm[1][0]][temm[1][1]]++;
						temm[1][1]++;			
					}
				}
				else System.out.println("Raggy");
			}
			else if(temm[0][1] == temm[1][1]){
				if(temm[0][0] < temm[1][0]){
					while(temm[0][0] <= temm[1][0]){
						plot[temm[0][0]][temm[0][1]]++;
						temm[0][0]++;			
					}
				}
				else if(temm[0][0] > temm[1][0]){
					while(temm[0][0] >= temm[1][0]){
						plot[temm[1][0]][temm[1][1]]++;
						temm[1][0]++;			
					}
				}
			}
			
			else System.out.println(i+"- bonk "+temm[0][0]+","+temm[0][1]+" - "+temm[1][0]+","+temm[1][1]);
		}
		int tote = 0;
		for(int i = 0; i<1000; i++){
			for(int j = 0; j<1000; j++){
				if(plot[j][i]>1){tote++;}			
			}
		}
		System.out.println(tote);
	}
}
