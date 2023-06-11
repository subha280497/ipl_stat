package ipl.generic;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.WebDriver;

public class JavaUtility {
	
	public int generateRandomNumber() {
		Random random = new Random();
		int n = random.nextInt(0, 100);
		return n;
	}
	
	public String getCurrentSystemDate() {
		Date date = new Date();
		return date.toString();
	}
	
	public Boolean isSorted(List<Integer> lst) {
		for(int i = 1; i<lst.size(); i++) {
			if(lst.get(i-1) < lst.get(i)) {
				return false;
			}
		}
		return true;
	}
}
