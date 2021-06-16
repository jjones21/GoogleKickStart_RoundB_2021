import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static TestCase[] cases;
	static int numOfCases;						//first int provided in input
												//number of cases
	static class TestCase{
		int length;								//length of the case's string
		String data;							//string provided for the case
		String solution="";						//output for this case
	}
	
	static void readInput(){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        numOfCases = in.nextInt();
        cases= new TestCase[numOfCases];
        for (int i = 1; i <= numOfCases; ++i) {
        	TestCase temp = new TestCase();
        	temp.length = in.nextInt();
        	in.nextLine(); 						//clear newline char
        	temp.data = in.nextLine();
        	cases[i-1]=(temp);
        }
	}
	
	static void runTest() {
		for(TestCase t: cases) {				//runs the test on all cases in the arraylist
			char lastChar = t.data.charAt(0);	//defaults to the first char, causes first iteration to always be 1
			int combo = 1;						//stores the # of Consecutive increases
			for (char y: t.data.toCharArray()) {
				if(lastChar<y) {				//increases combo
					combo+=1;
				}else { 						//combo breaker
					combo=1;
				}
				lastChar = y;
				t.solution=t.solution+" "+combo;//appends current combo to the solution
			}
		}
	}
	
	public static void main(String[] args) {
        readInput();
        runTest();
        int iterator = 1;
        for(TestCase t: cases) {
        	System.out.println("Case #" + iterator + ":" + t.solution);
        	iterator++;
        }
	}
}
