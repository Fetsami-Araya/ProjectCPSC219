package scores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
//setting up the file store high scores
public class ReadHighScores {
	private static String filename = "C:\\Users\\fetsa\\OneDrive\\Documents\\CPSC 219\\Project\\Project_Final2\\Project_Final2\\Project\\Menu\\src\\scores\\HighScores.txt";
	private static File scoresFile = new File(filename);
	private static String row;
	private ArrayList<String> theData = new ArrayList<String>();
	private ArrayList<String[]> rankings = new ArrayList<String[]>();
	private int fastestTime=61;
	private int highestLives=-1;
	
	public ArrayList<String[]> readScores() {
		//reading from the file
		if (scoresFile.isFile()) {  
			try {
				BufferedReader csvReader = new BufferedReader(new FileReader(scoresFile));  
				while ((row = csvReader.readLine()) != null) {  
				    String[] data = row.split(",");
				    rankings.add(data);
				    	
				    }
				    				    
				csvReader.close();  
				rankings.sort(new ScoreComparator());
				return rankings;
				
			}catch(IOException trap) {
				System.out.print("You're trash");
				return null;
			}
		}
		
		else {
			return rankings;
		}
	}

}
