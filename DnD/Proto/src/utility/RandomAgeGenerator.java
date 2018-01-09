package utility;

import java.util.HashMap;
import java.util.Map;

public class RandomAgeGenerator {
	
	public static Map<String, Map<String, int[]>> ages = new HashMap<String, Map<String, int[]>>();
	
	static {
		for(String race : CharacterUtility.racesList){
			Map<String, int[]> age = new HashMap<String, int[]>();
			int[] young = new int[2];
			int[] adult = new int[2];
			int[] older = new int[2];
			int bonus = 0;
			if(race == "Dragonborn" || race == "Dwarf (Hill)" || race == "Dwarf (Mountain)" || 
				race == "Gnome (Forest)" || race == "Gnome (Rock)" || race == "Gnome (Deep)" || 
				race == "Halfling (Lightfoot)" || race == "Halfling (Stout)"){
				bonus = 40;
				young[0] = DiceRoll.rollMin(false, "1d4 + " + bonus);
				young[1] = DiceRoll.rollMax(false, "1d4 + " + bonus);
				adult[0] = DiceRoll.rollMin(false, "4d4 + 1d6 + " + (young[1] - 5));
				adult[1] = DiceRoll.rollMax(false, "4d4 + 1d6 + " + (young[1] - 5));
				older[0] = DiceRoll.rollMin(false, "4d4 + 6d6 + " + (adult[1] - 10));
				older[1] = DiceRoll.rollMax(false, "4d4 + 6d6 + " + (adult[1] - 10));
				age.put("Young", young);
				age.put("Adult", adult);
				age.put("Older", older);
				ages.put(race, age);
			}

			
			if(race == "Goblin" || race == "Kobold"){
				bonus = 12;
				young[0] = DiceRoll.rollMin(false, "1d4 + " + bonus);
				young[1] = DiceRoll.rollMax(false, "1d4 + " + bonus);
				adult[0] = DiceRoll.rollMin(false, "4d4 + 1d6 + " + (young[1] - 5));
				adult[1] = DiceRoll.rollMax(false, "4d4 + 1d6 + " + (young[1] - 5));
				older[0] = DiceRoll.rollMin(false, "4d4 + 6d6 + " + (adult[1] - 10));
				older[1] = DiceRoll.rollMax(false, "4d4 + 6d6 + " + (adult[1] - 10));
				age.put("Young", young);
				age.put("Adult", adult);
				age.put("Older", older);
				ages.put(race, age);
		    }
			if(race == "Half-Elf" || race == "Tiefling"){
				bonus = 20;
				young[0] = DiceRoll.rollMin(false, "1d4 + " + bonus);
				young[1] = DiceRoll.rollMax(false, "1d4 + " + bonus);
				adult[0] = DiceRoll.rollMin(false, "4d4 + 1d6 + " + (young[1] - 5));
				adult[1] = DiceRoll.rollMax(false, "4d4 + 1d6 + " + (young[1] - 5));
				older[0] = DiceRoll.rollMin(false, "4d4 + 6d6 + " + (adult[1] - 10));
				older[1] = DiceRoll.rollMax(false, "4d4 + 6d6 + " + (adult[1] - 10));
				age.put("Young", young);
				age.put("Adult", adult);
				age.put("Older", older);
				ages.put(race, age);
		    }

			if(race == "Half-Orc" || race == "Orc"){
				bonus = 14;
				young[0] = DiceRoll.rollMin(false, "1d4 + " + bonus);
				young[1] = DiceRoll.rollMax(false, "1d4 + " + bonus);
				adult[0] = DiceRoll.rollMin(false, "4d4 + 1d6 + " + (young[1] - 5));
				adult[1] = DiceRoll.rollMax(false, "4d4 + 1d6 + " + (young[1] - 5));
				older[0] = DiceRoll.rollMin(false, "4d4 + 6d6 + " + (adult[1] - 10));
				older[1] = DiceRoll.rollMax(false, "4d4 + 6d6 + " + (adult[1] - 10));
				age.put("Young", young);
				age.put("Adult", adult);
				age.put("Older", older);
				ages.put(race, age);
		    }

			if(race == "Human" ){
				bonus = 15;
				young[0] = DiceRoll.rollMin(false, "1d4 + " + bonus);
				young[1] = DiceRoll.rollMax(false, "1d4 + " + bonus);
				adult[0] = DiceRoll.rollMin(false, "4d4 + 1d6 + " + (young[1] - 5));
				adult[1] = DiceRoll.rollMax(false, "4d4 + 1d6 + " + (young[1] - 5));
				older[0] = DiceRoll.rollMin(false, "4d4 + 6d6 + " + (adult[1] - 10));
				older[1] = DiceRoll.rollMax(false, "4d4 + 6d6 + " + (adult[1] - 10));
				age.put("Young", young);
				age.put("Adult", adult);
				age.put("Older", older);
				ages.put(race, age);
		    }
			
			
			if(race == "Elf (High)" || race == "Elf (Wood)" || race == "Elf (Drow)"){
				bonus = 110;
				young[0] = DiceRoll.rollMin(false, "1d20 + " + bonus);
				young[1] = DiceRoll.rollMax(false, "1d20 + " + bonus);
				adult[0] = DiceRoll.rollMin(false, "21d20 + " + (young[1] - 21));
				adult[1] = DiceRoll.rollMax(false, "21d20 + " + (young[1] - 21));
				older[0] = DiceRoll.rollMin(false, "422d20 + " + (adult[1] - 422));
				older[1] = DiceRoll.rollMax(false, "422d20 + " + (adult[1] - 422));
				age.put("Young", young);
				age.put("Adult", adult);
				age.put("Older", older);
				ages.put(race, age);
		    }
		}
	}
	
	public static int pickRandomAge(String race) {
		Map<String, int[]> ages = RandomAgeGenerator.ages.get(race);
		int random = DiceRoll.rollDice(false, "1d3");
		int ret = 0;
		if(race == "Elf (High)" || race == "Elf (Wood)" || race == "Elf (Drow)"){
			if(random == 1){
				int[] age = ages.get("Young");
				ret = DiceRoll.rollDice(false, "1d20 + " + (age[0] -1));
			} 
			else if (random == 2){
				int[] age = ages.get("Adult");
				ret = DiceRoll.rollDice(false, "21d20 + " + (age[0] -5));
			} 
			else if (random == 3){
				int[] age = ages.get("Older");
				ret = DiceRoll.rollDice(false, "422d20 + " + (age[0] -10));
			}
		}else {
			if(random == 1){
				int[] age = ages.get("Young");
				ret = DiceRoll.rollDice(false, "1d4 + " + (age[0] -1));
			} 
			else if (random == 2){
				int[] age = ages.get("Adult");
				ret = DiceRoll.rollDice(false, "4d4 + 1d6 + " + (age[0] -5));
			} 
			else if (random == 3){
				int[] age = ages.get("Older");
				ret = DiceRoll.rollDice(false, "4d4 + 6d6 + " + (age[0] -10));
			}
		}
		
		CharacterUtility.getAgeDescription(ret, race);
		return ret;
	}
}
