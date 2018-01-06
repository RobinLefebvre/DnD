import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import character.Character;
import character.Skill;

import utility.CharacterUtility;
import utility.ClassUtility;
import utility.DiceRoll;
import utility.RaceUtility;
import utility.RandomNameGen;
import utility.Utility;

public class RandomCharacterCreator {

	public static void main(String[] args) {
		saveAllDataToJSON();
	}
	
	private static void saveAllDataToJSON(){
		/* Lists */
		for(String s : CharacterUtility.toJSON().keySet()){
			Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir") + "\\data\\" + s + ".json");
			//System.out.println(System.getProperty("user.dir") + "\\" + s + ".json");
			//System.out.println(CharacterUtility.toJSON().get(s));
			try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {	
				writer.write(CharacterUtility.toJSON().get(s));
			}catch(IOException e){
				System.out.println("Error : " + e.getMessage());
			}
		}
		/* Random Character */
		Character c = generateRandomCharacter();
		Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir") + "\\Characters\\" + c.getName() +  ".json");
		//System.out.println(System.getProperty("user.dir") + "\\" + c.getName() + "_" + c.getRace() + "_" + c.getClasse() + ".json");
		//System.out.println(c.toJSON());
		try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {	
			writer.write(c.toJSON());
		}catch(IOException e){
			System.out.println("Error : " + e.getMessage());
		}
	}
	private static Character generateRandomCharacter() {
		String race = Utility.pickRandom(CharacterUtility.racesList);
		String name = RandomNameGen.generateRandomName(race);
		String[] classes = new String[1];
		classes[0] = Utility.pickRandom(CharacterUtility.classList);
		String alignment = Utility.pickRandom(CharacterUtility.alignmentsList);
		int age = CharacterUtility.pickRandomAge(race);
		
		HashMap<String, Integer> abilities = generateRandomAbilities(race);
		HashMap<String, Boolean> proficiency = generateRandomProficiencies(race, classes[0]);
		HashMap<String, Skill> skills = generateRandomSkills(abilities, proficiency);
		Character c = new Character(name, 1, 0, race, classes ,age, alignment, abilities, skills, proficiency);
		return c;
	}
	
	private static HashMap<String, Integer> generateRandomAbilities(String race) {
		HashMap<String, Integer> abilities = new HashMap<String, Integer>();
		/* Random Ability Score */
		for (String ability : CharacterUtility.skillsAbilityMap.keySet()){
			abilities.put(ability, DiceRoll.rollDice("4d6 + -4"));	
		}
		/* Adding bonus from Race */
		for(String ab : RaceUtility.abilityBonus.get(race).keySet()){
			int a = abilities.get(ab);
			abilities.replace(ab, a + 2);
		}
		return abilities;
	}

	private static HashMap<String, Boolean> generateRandomProficiencies(String race, String classe) {
		HashMap<String, Boolean> proficiency = new HashMap<String, Boolean>();
		/* Race Proficiencies */
		for(String p1 : RaceUtility.proficiencies.get(race)){
			proficiency.put(p1, true);
		}
		/* Class Proficiencies */
		for(String p2 : ClassUtility.proficiencies.get(classe)){
			proficiency.put(p2, true);
		}
		return proficiency;
	}
	
	private static HashMap<String, Skill> generateRandomSkills(HashMap<String, Integer> abilities, HashMap<String, Boolean> proficiency) {
		HashMap<String, Skill> skills = new HashMap<String, Skill>();
		/* For each ability */
		for (String ability : CharacterUtility.skillsAbilityMap.keySet()){
			/* Get bonus score */
			int score = abilities.get(ability) - 10;
			score = (score <= 0 && Math.abs(score % 2) == 1) ? (score / 2) - 1 : score / 2 ;
			/*For each skill of that ability */
			for (String skill : CharacterUtility.skillsAbilityMap.get(ability)){
				/* Create the skill and tell wether or not we are proficient in it */
				skills.put(skill, new Skill(score, proficiency.containsKey(skill)));
				
			}
		}
		return skills;
	}
}
