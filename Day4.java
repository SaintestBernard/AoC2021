import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//SaintBernard
public class Day4 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException{
		String str;
		BufferedReader in;
		in = new BufferedReader(new FileReader("bingo sheets.txt"));

		Map<Integer, String[][]> sheets = new HashMap<>();
		int c = 0;
		while(true){
			
			String[][] temp = new String[5][5];

			for(int j = 0; j<5; j++){
				try { str = in.readLine();
					if(str.charAt(0) == ' '){ str = str.substring(1);}
					str = str.replace("  ",",");
					str = str.replace(" ",",");
					temp[j] = str.split(",");
				} catch (IOException e) { e.printStackTrace(); }
			}
			
			sheets.put(c, temp);
			c++;
			
			try {
				str = in.readLine();
				if(str == null){break;}
			} catch (IOException e) { break; }
		}
		
		String[] nums = new String[]{"28","82","77","88","95","55","62","21","99","14","30","9","97","92","94","3","60","22","18","86","78","71","61","43","79","33","65","81","26","49","47","51","0","89","57","75","42","35","80","1","46","83","39","53","40","36","54","70","76","38","50","23","67","2","20","87","37","66","84","24","98","4","7","12","44","10","29","5","48","59","32","41","90","17","56","85","96","93","27","74","45","25","15","6","69","16","19","8","31","13","64","63","34","73","58","91","11","68","72","52"};
		String[][] temper;
		int who = 99999;
		int winNum = 1;
		
		//part 2 begin
		Integer[] winners = new Integer[sheets.size()];
		for(int i = 0; i<winners.length; i++){winners[i] = 0;}
		
		for(int i = 0; i<nums.length; i++){
			for(int l = 0; l < sheets.size(); l++){
				if(winners[l] == 0){
					temper = sheets.get(l);
					for(int j = 0; j < 5; j++){
						for(int k = 0; k < 5; k++){ 
							if(temper[j][k].equals(nums[i])){ temper[j][k] = "x"; } 
						}
					}

					//win checks
					for(int j = 0; j < 5; j++){
						if(temper[j][0].equals("x") && temper[j][1].equals("x") && temper[j][2].equals("x") && temper[j][3].equals("x") && temper[j][4].equals("x")){
							who = l;
							winNum = Integer.parseInt(nums[i]);
							winners[l] = 1;
						}

						if(temper[0][j].equals("x") && temper[1][j].equals("x") && temper[2][j].equals("x") && temper[3][j].equals("x") && temper[4][j].equals("x")){
							who = l;
							winNum = Integer.parseInt(nums[i]);
							winners[l] = 1;
						}
					}
				
					if(temper[0][0].equals("x") && temper[1][1].equals("x") && temper[2][2].equals("x") && temper[3][3].equals("x") && temper[4][4].equals("x"))
						{who = l; winNum = Integer.parseInt(nums[i]); winners[l] = 1;}
					if(temper[4][0].equals("x") && temper[3][1].equals("x") && temper[2][2].equals("x") && temper[1][3].equals("x") && temper[0][4].equals("x"))
						{who = l; winNum = Integer.parseInt(nums[i]); winners[l] = 1;}
					//end win checks
				
				}
			}
		}
		//part 2 end
		
		temper = sheets.get(who);
		int total = 0;
		for(int j = 0; j < 5; j++){
			for(int k = 0; k < 5; k++){
				if(temper[j][k] != "x"){ 
					total += Integer.parseInt(temper[j][k]);  
				}
			}
		}
		
		total *= winNum;
		
		System.out.println(total);
		

		/* Part 1
		for(int i = 0, out = 0; i<nums.length; i++){
			
			for(int l = 0; l < sheets.size(); l++){
			temper = sheets.get(l);
			for(int j = 0; j < 5; j++){
				for(int k = 0; k < 5; k++){ 
					if(temper[j][k].equals(nums[i])){ temper[j][k] = "x"; } 
				}
			}
			
			//win checks
			for(int j = 0; j < 5; j++){
				if(temper[j][0].equals("x") && temper[j][1].equals("x") && temper[j][2].equals("x") && temper[j][3].equals("x") && temper[j][4].equals("x")){
					out = 1;
					who = l;
					winNum = Integer.parseInt(nums[i]);
				}
				if(temper[0][j].equals("x") && temper[1][j].equals("x") && temper[2][j].equals("x") && temper[3][j].equals("x") && temper[4][j].equals("x")){
					out = 1;
					who = l;
					winNum = Integer.parseInt(nums[i]);
				}
			}
			if(temper[0][0].equals("x") && temper[1][1].equals("x") && temper[2][2].equals("x") && temper[3][3].equals("x") && temper[4][4].equals("x")){out = 1;
			who = l; winNum = Integer.parseInt(nums[i]);}
			if(temper[4][0].equals("x") && temper[3][1].equals("x") && temper[2][2].equals("x") && temper[1][3].equals("x") && temper[0][4].equals("x")){out = 1;
			who = l; winNum = Integer.parseInt(nums[i]);}
			//end win checks
			if(out == 1){break;}
			}
			if(out == 1){break;}
		}*/
		
}
}
