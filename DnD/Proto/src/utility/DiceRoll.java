package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceRoll {
	private static final String diceRegex = "(([0-9]+)d([0-9]+))";
	private static final String bonusRegex = "[0-9]+";
	private static final String negBonusRegex = ".[0-9]+";
	private static final String dropLowestRegex = "droplowest";
	private static final Pattern dicePattern = Pattern.compile(diceRegex);
	private static final Pattern bonusPattern = Pattern.compile(bonusRegex);
	private static final Pattern negBonusPattern = Pattern.compile(negBonusRegex);
	private static final Pattern dropLowestPattern = Pattern.compile(dropLowestRegex);
	
	public static int rollDice(boolean display, String diceCode){
		if (display){ System.out.print("Dice roll : " + diceCode + " = [ (");}
		List<Integer> results = new ArrayList<Integer>();
		String[] codes = diceCode.split(" \\+ ");
		for (String code : codes){
			Matcher diceM = dicePattern.matcher(code);
			Matcher bonusM = bonusPattern.matcher(code);
			Matcher negBonusM = negBonusPattern.matcher(code);
			Matcher dropLowestM = dropLowestPattern.matcher(code);
			
			if(dropLowestM.matches()){
				if (display){ System.out.print(" - " + Collections.min(results) + "");}
				results.remove(results.indexOf(Collections.min(results)));
			}
			if(diceM.matches()){
				int diceAmount = Integer.parseInt(diceM.group(2));
				int diceType = Integer.parseInt(diceM.group(3));
				results.addAll(rollDice(display, diceAmount, diceType));
			}else if (negBonusM.matches()){
				results.add(Integer.parseInt(negBonusM.group()));
				if (display){ System.out.print(" " + Integer.parseInt(negBonusM.group()) + " ");}
			}
			else if (bonusM.matches()){
				results.add(Integer.parseInt(bonusM.group()));
				if (display){ System.out.print(" + " + Integer.parseInt(bonusM.group()) + " ");}
			}
		}
		int sum = results.stream().mapToInt(Integer::intValue).sum();
		if (display){ System.out.print(" = " + sum + " ]\n");}
		return sum;
	}

	public static List<Integer> rollDice(boolean display, int amount, int type){
		List<Integer> results = new ArrayList<Integer>();
		for (int i = 1; i <= amount; i++){
			int temp = rollDice(display, type);
			if (display){ if(i != amount) {System.out.print(" + "); } }
			results.add(temp);
		}
		if (display){System.out.print(")");}
		return results;
	}
	public static int rollDice (boolean display, int diceNum){
		Random rng = new Random();
		int i = rng.nextInt(diceNum) + 1;
		if(display){System.out.print(i);}
		return i;
	}
	
	public static int rollAverage(String diceCode){
		int min = 0;
		int max = 0;
		int result = 0;
		for (String code : diceCode.split(" . ")){
			Matcher diceM = dicePattern.matcher(code);
			Matcher bonusM = bonusPattern.matcher(code);
			if(diceM.matches()){
				int diceAmount = Integer.parseInt(diceM.group(2));
				int diceType = Integer.parseInt(diceM.group(3));
				for (int i = 1; i <= diceAmount; i++){
					min += 1;
					max += diceType;
				}
			}else if (bonusM.matches()){
				min += Integer.parseInt(bonusM.group());
				max += Integer.parseInt(bonusM.group());
			}
		}
		result = (min + max) / 2;
		return result;
	}
	
	public static int rollMin(boolean display, String diceCode) {
		int result = 0;
		String[] codes = diceCode.split(" . ");
		for (String code : codes){
			Matcher diceM = dicePattern.matcher(code);
			Matcher bonusM = bonusPattern.matcher(code);
			if(diceM.matches()){
				int diceAmount = Integer.parseInt(diceM.group(2));
				int diceType = 1;
				for(int i : rollDice(display, diceAmount, diceType)){
					result += i;
				}
			}else if (bonusM.matches()){
				result += Integer.parseInt(bonusM.group());
				if (display){System.out.print(" + " + Integer.parseInt(bonusM.group()) + "   = ");}
			}
		}
		return result;
	}
	public static int rollMax(boolean display, String diceCode) {
		int result = 0;
		String[] codes = diceCode.split(" . ");
		for (String code : codes){
			Matcher diceM = dicePattern.matcher(code);
			Matcher bonusM = bonusPattern.matcher(code);
			if(diceM.matches()){
				int diceAmount = Integer.parseInt(diceM.group(2));
				int diceType = Integer.parseInt(diceM.group(3));
				for (int i = 1; i <= diceAmount; i++){
					result += diceType;
				}
			}else if (bonusM.matches()){
				result += Integer.parseInt(bonusM.group());
				if (display){System.out.print(" + " + Integer.parseInt(bonusM.group()) + "   = ");}
			}
		}
		return result;
	}
}
