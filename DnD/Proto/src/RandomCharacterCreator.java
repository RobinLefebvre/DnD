import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

import character.Character;
import character.Skill;
import utility.*;

public class RandomCharacterCreator {
	
	
	public static void main(String[] args) {
		System.out.println("_____    D&D Character Generator    _____");
		displayHelp();
		
		Scanner s = new Scanner(System.in);
		String scan = "";
		do{
			System.out.print("\nYour command > ");
			scan = s.nextLine();
			switch(scan){
				case "exit":
					System.out.println("\n\nEND OF PROGRAM.\n");
					s.close();
					System.exit(1);
					break;
				case "generate":
					saveRandomCharacterToJSON(true);
					break;
					
				case "generateSilent":
					saveRandomCharacterToJSON(false);
					break;
					
				case "data":
					saveGameDataToJSON(false);
					break;
					
				case "all":
					saveAllDataToJSON(false);
					break;
				case "help":
					displayHelp();
					break;
				
				default :
					System.out.println("Wrong command");
					break;
			}
			
		}while(scan != "exit");
		System.out.println("\n\nEND OF PROGRAM.\n");
	}
	
	private static void displayHelp(){
		System.out.println("\n\"exit\" : exits the program");
		System.out.println("\"generate\" : generates a new character in the character folder");
		System.out.println("\"generateSilent\" : generate a new character without display");
		System.out.println("\"data\" to export the data for generation to the data folder");
		System.out.println("\"help\" to display this help again");
	}
	private static void saveAllDataToJSON(boolean display){
		saveGameDataToJSON(display);
		saveRandomCharacterToJSON(display);
	}
	
	private static void saveRandomCharacterToJSON(boolean display){
		if(display){System.out.println("\n\n\nSTART - GENERATING RANDOM CHARACTER");}
		/* Random Character */
		Character c = generateRandomCharacter(display);
		Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir") + "\\Characters\\" + c.getName() +  ".json");
		if(display){System.out.println("\n\nSAVING TO : " + path);}
		try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {	
			writer.write(c.toJSON());
		}catch(IOException e){
			System.out.println("Error : " + e.getMessage());
		}
		if(display){System.out.println("\nGENERATION DONE");}
	}
	private static void saveGameDataToJSON(boolean display){
		if(display){System.out.println("START - GENERATING GAME DATA");}
		for(String s : CharacterUtility.toJSON(display).keySet()){
			if(display){System.out.println("Generating " + s);}
			Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir") + "\\data\\" + s + ".json");
			try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {	
				writer.write(CharacterUtility.toJSON(display).get(s));
			}catch(IOException e){
				System.out.println("Error : " + e.getMessage());
			}
		}
	}
	private static Character generateRandomCharacter(boolean display) {
		String race = Utility.pickRandom(CharacterUtility.racesList);
		String name = RandomNameGen.generateRandomName(race);
		String[] classes = new String[1];
		classes[0] = Utility.pickRandom(CharacterUtility.classList);
		String alignment = Utility.pickRandom(CharacterUtility.alignmentsList);
		int age = RandomAgeGenerator.pickRandomAge(race);
		if(display){System.out.println("Picking Race : " + race + "\nPicking Name : " + name + "\nPicking Class : " + classes[0] + 
										"\nPicking Alignment : " + alignment + "\nPicking Age : " + age + "\n\nGENERATING ABILITY SCORE :");}
		
		HashMap<String, Integer> abilities = generateRandomAbilities(display, race);
		if(display){System.out.println("\nGENERATING PROGICIENCIES : ");}
		HashMap<String, Boolean> proficiency = generateRandomProficiencies(display, race, classes[0]);
		if(display){System.out.println("\nSETTING SKILLS BONUSES : ");}
		HashMap<String, Skill> skills = generateRandomSkills(display, abilities, proficiency);
		
		Character c = new Character(name, 1, 0, race, classes ,age, alignment, abilities, skills, proficiency);
		return c;
	}
	
	private static HashMap<String, Integer> generateRandomAbilities(boolean display, String race) {
		HashMap<String, Integer> abilities = new HashMap<String, Integer>();
		/* Random Ability Score */
		for (String ability : CharacterUtility.skillsAbilityMap.keySet()){
			if(display){System.out.println("Rolling for " + ability);}
			abilities.put(ability, DiceRoll.rollDice(display, "4d6 + droplowest"));	
		}
		/* Adding bonus from Race */
		for(String ab : RaceUtility.abilityBonus.get(race).keySet()){
			int currentAbility = abilities.get(ab);
			int toAdd = RaceUtility.abilityBonus.get(race).get(ab).intValue();
			if(display){System.out.println("Adding "+ race + " racial bonus : +" + toAdd + " to " + ab);}
			abilities.replace(ab, currentAbility + toAdd);
		}
		return abilities;
	}

	private static HashMap<String, Boolean> generateRandomProficiencies(boolean display, String race, String classe) {
		HashMap<String, Boolean> proficiency = new HashMap<String, Boolean>();
		/* Race Proficiencies */
		for(String p1 : RaceUtility.proficiencies.get(race)){
			if(display){System.out.println("Adding " + race + " racial profeciency : " + p1);}
			proficiency.put(p1, true);
		}
		/* Class Proficiencies */
		for(String p2 : ClassUtility.proficiencies.get(classe)){
			if(display && !CharacterUtility.weaponProf.contains(p2) && !CharacterUtility.armorProf.containsKey(p2)){
				String dis = "Adding " + classe + " class profeciency : " + p2; 
				if(CharacterUtility.languageProf.contains(p2)){
					dis += " (Language)";
				}if(CharacterUtility.armorProf.containsKey(p2)){
					dis += " (Armor)";
				}System.out.println(dis);
			}
			proficiency.put(p2, true);
		}
		if(display){
			for(String p2 : ClassUtility.proficiencies.get(classe)){
				if(CharacterUtility.weaponProf.contains(p2)){
					System.out.println("Adding weapon profeciency : " + p2);
				}
			}
		}
		return proficiency;
	}
	
	private static HashMap<String, Skill> generateRandomSkills(boolean display, HashMap<String, Integer> abilities, HashMap<String, Boolean> proficiency) {
		HashMap<String, Skill> skills = new HashMap<String, Skill>();
		/* For each ability */
		for (String ability : CharacterUtility.skillsAbilityMap.keySet()){
			/* Get bonus score */
			int score = abilities.get(ability) - 10;
			score = (score <= 0 && Math.abs(score % 2) == 1) ? (score / 2) - 1 : score / 2 ;
			if(display){System.out.println("Skills related to " + ability);}
			/*For each skill of that ability */
			for (String skill : CharacterUtility.skillsAbilityMap.get(ability)){
				boolean prof = proficiency.containsKey(skill);
				
				/* Create the skill and tell wether or not we are proficient in it */
				skills.put(skill, new Skill(score, prof));
				if(display){System.out.println("" + skill + " score : " + skills.get(skill).getBonus() );}
			}
		}
		return skills;
	}
	
	
}
