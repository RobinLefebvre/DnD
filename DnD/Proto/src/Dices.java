import java.io.InputStream;
import java.util.Scanner;

import utility.DiceRoll;

public class Dices {
	public static void main(String[] args) {
		InputStream stream = System.in;
		Scanner in = new Scanner(stream);
		System.out.println("_______      Robs' Dice Roller      _______  ");
		System.out.println("_______\"exit\" to exit program       _______");
		System.out.println("_______\"help\" for code explanation  _______");
		System.out.println("___________________________________________");
		do {
			System.out.print("> Enter dice code : ");
			String input = in.nextLine();
			switch(input){
				case "exit" :
					in.close();
					System.exit(1);
					break;
				case "help" :
					System.out.println("\n\nDices are represented by a specific notation : \"XdY\" \n    X : number of dices rolled.\n    Y : number of sides on the dice.");
					System.out.println("EX: (1d20) will roll one twenty-sided dice\nEX: (3d6) will roll three six-sided dices.\n");
					System.out.println("You can roll multiple different dices and add bonuses by seperating each by \" + \" \nSpacing is important and adding a negative bonus requires an extra \"-\" sign.");
					System.out.println("EX: (3d6 + 3) will roll three six-sided dice and add 3 to the result.");
					System.out.println("EX: (3d6 + -3) will roll three six-sided dice and substract 3 from the result.");
					System.out.println("EX: (1d20 + 3d6 + 3) will roll also roll one twenty-sided dice.\n");
					System.out.println("You can roll any number of dice and drop the lowest of them all by using XdY + droplowest ");
					System.out.println("EX : (4d6 + droplowest) will roll 4 dices and remove the lowest score\n\n");
					break;
				default :
					DiceRoll.rollDice(true, input);
					break;
			
			
			}
		}while (true);
	}
}
