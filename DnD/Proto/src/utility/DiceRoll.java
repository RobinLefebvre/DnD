package utility;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceRoll {
	private static final String diceRegex = "(([0-9]+)d([0-9]+))";
	private static final String bonusRegex = "[0-9]+";
	private static final Pattern dicePattern = Pattern.compile(diceRegex);
	private static final Pattern bonusPattern = Pattern.compile(bonusRegex);
	
	public static int rollDice(String diceCode){
		//System.out.print("Dice roll : " + diceCode + " = [ (");
		int result = 0;
		String[] codes = diceCode.split(" . ");
		for (String code : codes){
			Matcher diceM = dicePattern.matcher(code);
			Matcher bonusM = bonusPattern.matcher(code);
			if(diceM.matches()){
				int diceAmount = Integer.parseInt(diceM.group(2));
				int diceType = Integer.parseInt(diceM.group(3));
				result += rollDice(diceAmount, diceType);
			}else if (bonusM.matches()){
				result += Integer.parseInt(bonusM.group());
				//System.out.print(" + " + Integer.parseInt(bonusM.group()) + "   = ");
			}
		}
		//System.out.print(result + " ]\n");
		return result;
	}
	public static int rollDice(int amount, int type){
		int result = 0;
		for (int i = 1; i <= amount; i++){
			int temp = rollDice(type);
			//if(i != amount) {System.out.print(" ,"); }
			result += temp;
		}
		//System.out.print(")");
		return result;
	}
	public static int rollDice (int diceNum){
		Random rng = new Random();
		int i = rng.nextInt(diceNum) + 1;
		//System.out.print(i);
		return i;
	}
	
	public static int rollAverage(String diceCode){
		int[] minMax = new int[2];
		int result = 0;
		for (String code : diceCode.split(" . ")){
			Matcher diceM = dicePattern.matcher(code);
			Matcher bonusM = bonusPattern.matcher(code);
			if(diceM.matches()){
				int diceAmount = Integer.parseInt(diceM.group(2));
				int diceType = Integer.parseInt(diceM.group(3));
				int[] temp = rollAverage(diceAmount, diceType);
				minMax[0] += temp[0];
				minMax[1] += temp[1];
			}else if (bonusM.matches()){
				minMax[0] += Integer.parseInt(bonusM.group());
				minMax[1] += Integer.parseInt(bonusM.group());
			}
		}
		result = (minMax[0] + minMax[1]) / 2;
		return result;
	}
	
	public static int[] rollAverage(int amount, int type){
		int[] ret = new int[2];
		int min = 0;
		int max = 0;
		for (int i = 1; i <= amount; i++){
			min += 1;
			max += type;
		}
		ret[0] = min;
		ret[1] = max;
		return ret;
	}
}
