import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @see <a href="http://zerojudge.tw/ShowProblem?problemid=b524">b524: 先別管這個了，你聽過yee嗎？</a>
 * @author chriswong
 *
 */
public class Yee {

	public static void main(String args[]){
		String input = "yeeyee";
		int i = 0;
		System.out.println(stripYees(input));
		
		while(true){
			if(isYee(input)){
				break;
			} else{
				input = stripYees(input);
				input = swapY(input);
				i++;
			}
		}
		
		System.out.println(i);
		
	}
	
	/**
	 * Check if a string is (yee)+ by regular expression
	 * @param input	input string
	 * @return	yes if it is (yee)+
	 */
	public static boolean isYee(String input){
		Pattern pattern = Pattern.compile("^(yee)+");
		Matcher matcher = pattern.matcher(input);
		boolean b = matcher.matches();
		return b;
	}
	
	/**
	 * strip the leading (yee)+
	 * @param input
	 * @return
	 */
	public static String stripYees(String input){
		Pattern pattern = Pattern.compile("^(yee)+(.*)");
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()){
		    return matcher.group(2);
		}
		return input;
	}
	
	/**
	 * Swap the y logically
	 * @param input	
	 * @return
	 */
	public static String swapY(String input){
		
		/* if the first character is equal to y
		 *	swap the ye after
		 * else
		 *	the first y swap with previous(should be e)
		 */
		StringBuilder sb = new StringBuilder(input);
		int firstY = input.indexOf("y");
		if(input.startsWith("y")){
			int ye = input.indexOf("ye", firstY + 1);
			
			sb.setCharAt(ye, 'e');
			sb.setCharAt(ye + 1, 'y');
		} else {
			
			sb.setCharAt(firstY, 'e');
			sb.setCharAt(firstY - 1, 'y');
		}
		
		return sb.toString();
	}
}
