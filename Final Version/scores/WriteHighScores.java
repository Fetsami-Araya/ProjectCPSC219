package scores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//writing high scores to the file
public class WriteHighScores {
	private static String filename = "C:\\Users\\fetsa\\OneDrive\\Documents\\CPSC 219\\Project\\Project_Final2\\Project_Final2\\Project\\Menu\\src\\scores\\HighScores.txt";
	private static File scoresFile = new File(filename);

	private static String name;
	private static int timeitTook;
	private static int livesLeft;
	
	public WriteHighScores(String aName, int time, int nLives) {
		//reading name time and lives left
		WriteHighScores.name = aName;
		WriteHighScores.timeitTook = time;
		WriteHighScores.livesLeft = nLives;
	}
	
	
	public static void writeScores() {
		if(!scoresFile.exists()) {
			try {
				String[] rows = {name,Integer.toString(timeitTook),Integer.toString(livesLeft)};

					FileWriter csvWriter = new FileWriter(scoresFile); 
					
					int index = 0;
					for(String entry: rows) {
						if(index<2) {
							csvWriter.append(entry+",");
						} else {
							csvWriter.append(entry);
						}
						index++;
					}
					
					csvWriter.append("\n");

					csvWriter.flush();  
					csvWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			try {
				String[] rows = {name,Integer.toString(timeitTook),Integer.toString(livesLeft)};

				   FileWriter fileWriter = new FileWriter(filename,true); //Set true for append mode
				    PrintWriter printWriter = new PrintWriter(fileWriter);
					int index = 0;
					for(String entry: rows) {
						if(index<2) {
							printWriter.print(entry+",");
						} else {
							printWriter.print(entry);
						}
						index++;
					}
					
					printWriter.append("\n");
					//New line
				    printWriter.close();  

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
			

	}
