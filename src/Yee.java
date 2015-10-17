import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @see <a href="http://zerojudge.tw/ShowProblem?problemid=b524">b524: 先別管這個了，你聽過yee嗎？</a>
 * @author chriswong
 *
 */
public class Yee {

	private int swapCount;
	private String input;
	
	/**
	 * Constructor
	 * @param input
	 */
	public Yee(String input){
		this.swapCount = 0;
		this.input = input;
	}
	
	/**
	 * Get the count of swap
	 * @return the count of swap
	 */
	public int getSwapCount() {
		return swapCount;
	}

	/**
	 * Calculate the swap count
	 */
	public void calSwapCount() {
		int currentTarget = 0;
		// get all indices of y
		for(int i = 0; i < this.input.length(); i++){
			if(this.input.charAt(i) == 'y'){
				if(i != currentTarget){
					this.swapCount += Math.abs(i - currentTarget);
				}
				currentTarget += 3;
			}
		}
	}

}
