import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//SaintBernard
//WARNING: This one is super fucking messy and unoptimized
public class Day8 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		
		String str;
		BufferedReader in;
		in = new BufferedReader(new FileReader("numData.txt"));

		Map<Integer, String[]> codes = new HashMap<>();
		int c = 0;
		while(true){
			String[][] temp = new String[1][15];
			try { str = in.readLine();
				if(str == null){break;}
				temp[0] = str.split(" ");
			} catch (IOException e) { e.printStackTrace(); }
			codes.put(c, temp[0]);
			c++;
		}
		
		int total = 0;
		for(int i = 0; i<codes.size(); i++){
			String[] truth = {"-","-","-","-","-","-","-"};
			char[][] nums = new char[10][7];
			char[][] numnums = new char[6][6];
			String[] temp = codes.get(i);
			
			//sort the numbers into their place in nums, or their place in numnums if mulitple possible
			for(int j = 0, k = 0, fiv = 0, six = 3; j<10; j++){
				k = temp[j].length();
				if(k == 2) nums[1] = temp[j].toCharArray();
				else if(k == 3) nums[7] = temp[j].toCharArray();
				else if(k == 4) nums[4] = temp[j].toCharArray();
				else if(k == 7) nums[8] = temp[j].toCharArray();
				else if(k == 5){ numnums[fiv] = temp[j].toCharArray(); fiv++;}
				else if(k == 6){ numnums[six] = temp[j].toCharArray(); six++;}
			}
			
			//get truth[0]
			for(int j = 0; j<3; j++) {if(Character.compare(nums[7][j], nums[1][0]) != 0 && Character.compare(nums[7][j], nums[1][1]) != 0) truth[0] = Character.toString(nums[7][j]); }
			
			//get nums[6]
			for(int j = 3; j<6; j++){
				int l = 0;
				for(int k = 0; k<6; k++){ if(numnums[j][k] == nums[1][0] || numnums[j][k] == nums[1][1]) l++; }
				if(l == 1){  nums[6] = numnums[j]; break; }
			}
			
			//determine truth[2] as the missing value of 6
			if(!(new String(nums[6]).contains("a")))truth[2] = "a";
			else if(!(new String(nums[6]).contains("b")))truth[2] = "b";
			else if(!(new String(nums[6]).contains("c")))truth[2] = "c";
			else if(!(new String(nums[6]).contains("d")))truth[2] = "d";
			else if(!(new String(nums[6]).contains("e")))truth[2] = "e";
			else if(!(new String(nums[6]).contains("f")))truth[2] = "f";
			else truth[2] = "g";
			
			//get truth [5], the other value in nums[1]
			if(Character.toString(nums[1][0]).equals(truth[2]))truth[5] = Character.toString(nums[1][1]);
			else truth[5] = Character.toString(nums[1][0]);
			
			//find nums[2]
			for(int j = 0; j<3; j++){
				if(!(new String(numnums[j]).contains(truth[5])))nums[2] = numnums[j];
			}
			
			//find truth[1]
			if(!(new String(nums[2]).contains("a"))&&!(truth[5].equals("a"))) truth[1] = "a";
			else if(!(new String(nums[2]).contains("b"))&&!(truth[5].equals("b"))) truth[1] = "b";
			else if(!(new String(nums[2]).contains("c"))&&!(truth[5].equals("c"))) truth[1] = "c";
			else if(!(new String(nums[2]).contains("d"))&&!(truth[5].equals("d"))) truth[1] = "d";
			else if(!(new String(nums[2]).contains("e"))&&!(truth[5].equals("e"))) truth[1] = "e";
			else if(!(new String(nums[2]).contains("f"))&&!(truth[5].equals("f"))) truth[1] = "f";
			else if(!(new String(nums[2]).contains("g"))&&!(truth[5].equals("g"))) truth[1] = "g";
			
			//find truth[3]
			for(int j = 0; j<4; j++) {
				String tem = Character.toString(nums[4][j]);
				if(!(tem.equals(truth[1])) && !(tem.equals(truth[2])) && !(tem.equals(truth[5]))) truth[3] = Character.toString(nums[4][j]);
			}
			
			//find nums[0]
			for(int j = 3; j<6; j++){
				if(!(new String(numnums[j]).contains(truth[3]))) nums[0] = numnums[j];
			}
			
			//find nums[9]
			for(int j = 3; j<6; j++){
				if(numnums[j] != nums[0] && numnums[j] != nums[6]) nums[9] = numnums[j];
			}
			
			//find truth[4]
			if(!(new String(nums[9]).contains("a"))) truth[4] = "a";
			else if(!(new String(nums[9]).contains("b"))) truth[4] = "b";
			else if(!(new String(nums[9]).contains("c"))) truth[4] = "c";
			else if(!(new String(nums[9]).contains("d"))) truth[4] = "d";
			else if(!(new String(nums[9]).contains("e"))) truth[4] = "e";
			else if(!(new String(nums[9]).contains("f"))) truth[4] = "f";
			else if(!(new String(nums[9]).contains("g"))) truth[4] = "g";
			
			//find truth[6], completing the key
			if(!(Arrays.asList(truth).contains("a"))) truth[6] = "a";
			else if(!(Arrays.asList(truth).contains("b"))) truth[6] = "b";
			else if(!(Arrays.asList(truth).contains("c"))) truth[6] = "c";
			else if(!(Arrays.asList(truth).contains("d"))) truth[6] = "d";
			else if(!(Arrays.asList(truth).contains("e"))) truth[6] = "e";
			else if(!(Arrays.asList(truth).contains("f"))) truth[6] = "f";
			else if(!(Arrays.asList(truth).contains("g"))) truth[6] = "g";
			
			//add the found numbers to the total
			for(int j = 11, mul = 1000; j<15; j++, mul/=10){
				if(temp[j].contains(truth[0])&&temp[j].contains(truth[1])&&temp[j].contains(truth[2])&&temp[j].contains(truth[3])&&temp[j].contains(truth[4])&&temp[j].contains(truth[5])&&temp[j].contains(truth[6])){total+=(8*mul);}
				else if(temp[j].contains(truth[0])&&temp[j].contains(truth[1])&&temp[j].contains(truth[2])&&temp[j].contains(truth[3])&&temp[j].contains(truth[5])&&temp[j].contains(truth[6])){total+=(9*mul);}//9
				else if(temp[j].contains(truth[0])&&temp[j].contains(truth[1])&&temp[j].contains(truth[3])&&temp[j].contains(truth[4])&&temp[j].contains(truth[5])&&temp[j].contains(truth[6])){total+=(6*mul);}//6
				else if(temp[j].contains(truth[0])&&temp[j].contains(truth[1])&&temp[j].contains(truth[2])&&temp[j].contains(truth[4])&&temp[j].contains(truth[5])&&temp[j].contains(truth[6])){}//0
				else if(temp[j].contains(truth[0])&&temp[j].contains(truth[1])&&temp[j].contains(truth[3])&&temp[j].contains(truth[5])&&temp[j].contains(truth[6])){total+=(5*mul);}//5
				else if(temp[j].contains(truth[0])&&temp[j].contains(truth[2])&&temp[j].contains(truth[3])&&temp[j].contains(truth[5])&&temp[j].contains(truth[6])){total+=(3*mul);}//3
				else if(temp[j].contains(truth[0])&&temp[j].contains(truth[2])&&temp[j].contains(truth[3])&&temp[j].contains(truth[4])&&temp[j].contains(truth[6])){total+=(2*mul);}//2
				else if(temp[j].contains(truth[1])&&temp[j].contains(truth[2])&&temp[j].contains(truth[3])&&temp[j].contains(truth[5])){total+=(4*mul);} //4
				else if(temp[j].contains(truth[0])&&temp[j].contains(truth[2])&&temp[j].contains(truth[5])){total+=(7*mul);}//7
				else if(temp[j].contains(truth[2])&&temp[j].contains(truth[5])){total+=(1*mul);}//1
			}
			
			
		}
		System.out.println(total);
		
		//personal reminders and help figuring out logic
		//2 digit 1, [2] [5]
		//3 digit 7, [0] [2] [5]
		//4 digit 4, [1] [2] [3] [5]
		//5 digit 2, 3, 5
			//2, [0] [2] [3] [4] [6] - Missing 1, 5
			//3, [0] [2] [3] [5] [6] - Missing 1, 4
			//5, [0] [1] [3] [5] [6] - Missing 2, 4
		//6 digit 0, 6, 9
			//0, [0] [1] [2] [4] [5] [6] - Missing 3
			//6, [0] [1] [3] [4] [5] [6] - Missing 2
			//9, [0] [1] [2] [3] [5] [6] - Missing 4
		//7 digit is 8
		
		/*Part 1
		int tote = 0;
		for(int i = 0; i<codes.size(); i++){
			String[][] temp  = codes.get(i);
			String tem;
			for(int j = 0; j<4; j++){
				tem = temp[1][j];
				if(tem.length() == 2 || tem.length() == 3|| tem.length() == 4|| tem.length() == 7){tote++;}
			}	
		}
		
		System.out.println(tote);*/
	}

}
