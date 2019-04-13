package scores;

import java.util.Comparator;
//compare scores
public class ScoreComparator implements Comparator<String[]>{

	@Override
	public int compare(String[] firstEntry, String[] secondEntry) {
		int timeFirstEntry = Integer.valueOf(firstEntry[1]);
		int timeSecondEntry = Integer.valueOf(secondEntry[1]);
		
		int livesFirstEntry = Integer.valueOf(firstEntry[1]);
		int livesSecondEntry = Integer.valueOf(secondEntry[1]); 
		
		if(timeFirstEntry<timeSecondEntry || (timeFirstEntry==timeSecondEntry&&livesFirstEntry>livesSecondEntry)) {
			return -1;
		}
		else if(timeFirstEntry>timeSecondEntry || (timeFirstEntry==timeSecondEntry&&livesFirstEntry<livesSecondEntry)) {
			return 1;
		}
		else {
			return 0;
		}
		

	}

}
