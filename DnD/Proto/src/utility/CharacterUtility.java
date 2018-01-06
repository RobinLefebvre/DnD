package utility;

import java.util.*;

public class CharacterUtility {
	public static final List<String> alignmentsList	= Arrays.asList("Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "Pure Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"); 
	public static final List<String> abilityList 	= Arrays.asList("Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma");
	public static final List<String> skillsList		= Arrays.asList("Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "History", "Insight", "Intimidation" , "Investigation", "Medicine" , "Nature", "Perception", "Performance", "Persuasion" , "Religion" , "Sleight Of Hand", "Stealth" , "Survival");
	public static final List<String> racesList 		= Arrays.asList("Dragonborn", "Dwarf (Hill)", "Dwarf (Mountain)", "Elf (High)","Elf (Wood)", "Elf (Drow)", "Gnome (Forest)", "Gnome (Rock)", "Gnome (Deep)", "Goblin", "Halfling (Lightfoot)", "Halfling (Stout)", "Half-Elf", "Half-Orc", "Human","Kobold", "Orc", "Tiefling" );
	public static final List<String> classList		= Arrays.asList("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard");
	
	public static final List<String> languageProf 	= Arrays.asList("Druidic", "Thieves' Cant", "Common", "Draconic", "Dwarvish", "Elven", "Gnomish", "Goblin", "Halfling", "Half-Orc", "Kobold", "Orcish", "Infernal", "Undercommon");
	public static final List<String> weaponProf 	= Arrays.asList("Club","Dagger","Greatclub","Handaxe","Javelin","Light Hammer","Mace","Quarterstaff","Sickle","Spear","Light Crossbow","Dart","Shortbow","Sling","Battleaxe","Flail","Glaive","Greataxe","Greatsword","Halberd","Lance","Longsword","Maul","Morningstar","Pike","Rapier","Scimitar","Shortsword","Trident","War Pick","Warhammer","Whip","Blowgun","Hand Crossbow","Heavy Crossbow","Longbow");
	public static final List<String> simpleWeapon	= Arrays.asList("Club","Dagger","Greatclub","Handaxe","Javelin","Light Hammer","Mace","Quarterstaff","Sickle","Spear","Light Crossbow","Dart","Shortbow","Sling");
	public static final List<String> martialWeapon 	= Arrays.asList("Battleaxe","Flail","Glaive","Greataxe","Greatsword","Halberd","Lance","Longsword","Maul","Morningstar","Pike","Rapier","Scimitar","Shortsword","Trident","War Pick","Warhammer","Whip","Blowgun","Hand Crossbow","Heavy Crossbow","Longbow");

	
	public static Map<String, List<String>> skillsAbilityMap = new HashMap<String, List<String>>();
	static {
		skillsAbilityMap.put("Strength", 		Arrays.asList("Athletics"));
		skillsAbilityMap.put("Dexterity", 		Arrays.asList("Acrobatics", "Sleight Of Hand", "Stealth"));
		skillsAbilityMap.put("Constitution", 	Arrays.asList());
		skillsAbilityMap.put("Intelligence", 	Arrays.asList("Arcana", "History", "Investigation", "Nature", "Religion"));
		skillsAbilityMap.put("Wisdom", 			Arrays.asList("Animal Handling", "Insight", "Medicine", "Perception", "Survival"));
		skillsAbilityMap.put("Charisma", 		Arrays.asList("Deception", "Intimidation" , "Performance", "Persuasion"));
	}
	
	public static Map<String, List<String>> armorProf = new HashMap<String, List<String>>();
	static {
		armorProf.put("Unarmored", Arrays.asList("Unarmored"));
		armorProf.put("Light", Arrays.asList("Padded", "Leather" , "Studded"));
		armorProf.put("Medium", Arrays.asList("Hide", "Chain shirt" , "Scale mail", "Breastplate", "Half plate"));
		armorProf.put("Heavy", Arrays.asList("Ring mail", "Chain mail","Splint", "Plate"));
		armorProf.put("Shield", Arrays.asList("Shield"));
	}	
	
	public static int getAbilityBonus(String ability, Map<String, Integer> abilityScore){
		int score =  abilityScore.get(ability) - 10;
		score = (score <= 0 && Math.abs(score % 2) == 1) ?(score / 2) - 1 : score / 2 ;
		return score;
	}
	
	public static Map<String, String> toJSON(){
		Map<String, String> map = new HashMap <String, String>();
		map.put("Alignments", Utility.listToJSON(alignmentsList));
		map.put("Abilities", Utility.listToJSON(abilityList));
		map.put("Skills", Utility.listToJSON(skillsList));
		map.put("Races", Utility.listToJSON(racesList));
		map.put("Classes", Utility.listToJSON(classList));
		map.put("Languages", Utility.listToJSON(languageProf));
		map.put("Weapons", Utility.listToJSON(weaponProf));
		map.put("Skills By Ability", Utility.mapListToJSON(skillsAbilityMap));
		map.put("Armor Types", Utility.mapListToJSON(armorProf));
		map.put("Race Proficiencies", Utility.mapListToJSON(RaceUtility.proficiencies));
		map.put("Race Speed", Utility.mapIntegerToJSON(RaceUtility.speed));
		map.put("Race Age", Utility.mapStringArrayToJSON(RaceUtility.ages));
		map.put("Race Abilities", Utility.mapMapIntegerToJSON(RaceUtility.abilityBonus));
		map.put("Class Hit Points", Utility.mapIntegerToJSON(ClassUtility.hitPoints));
		map.put("Class Accessible Skills", Utility.mapListToJSON(ClassUtility.accessibleProficiencies));
		map.put("Class Proficiencies", Utility.mapListToJSON(ClassUtility.proficiencies));
		map.put("Race Names", Utility.mapListToJSON(RandomNameGen.raceNames));
		return map;
	}

	public static int pickRandomAge(String race) {
		String[] ages = RaceUtility.ages.get(race);
		int avg = 0;
		for (String a : ages){
			int age = Integer.parseInt(a);
			avg += (age / 2) + (new Random().nextInt(age));
		}
		avg = avg / ages.length;
		return avg;
	}
}

