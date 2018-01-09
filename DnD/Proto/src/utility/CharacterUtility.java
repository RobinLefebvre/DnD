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
	
	public static String getAgeDescription (int age, String race){
		Map<String, int[]> ages = RandomAgeGenerator.ages.get(race);
		String ret = "";
		for (String s : ages.keySet()){
			if(age > ages.get(s)[0] && age < ages.get(s)[1])
				ret = s;	
		}
		return ret;
	}
	
	public static Map<String, String> toJSON(boolean display){
		Map<String, String> map = new HashMap <String, String>();
		
		map.put("Alignments", Utility.listToJSON(display, alignmentsList));
		map.put("Abilities", Utility.listToJSON(display,abilityList));
		map.put("Skills", Utility.listToJSON(display,skillsList));
		map.put("Races", Utility.listToJSON(display,racesList));
		map.put("Classes", Utility.listToJSON(display,classList));
		map.put("Languages", Utility.listToJSON(display,languageProf));
		map.put("Weapons", Utility.listToJSON(display,weaponProf));
		map.put("Skills By Ability", Utility.mapListToJSON(display,skillsAbilityMap));
		map.put("Armor Types", Utility.mapListToJSON(display,armorProf));
		map.put("Race Proficiencies", Utility.mapListToJSON(display,RaceUtility.proficiencies));
		map.put("Race Speed", Utility.mapIntegerToJSON(display,RaceUtility.speed));
		map.put("Race Age", Utility.mapMapIntegerArrayToJSON(display,RandomAgeGenerator.ages));
		map.put("Race Abilities", Utility.mapMapIntegerToJSON(display,RaceUtility.abilityBonus));
		map.put("Class Hit Points", Utility.mapIntegerToJSON(display,ClassUtility.hitPoints));
		map.put("Class Accessible Skills", Utility.mapListToJSON(display,ClassUtility.accessibleProficiencies));
		map.put("Class Proficiencies", Utility.mapListToJSON(display,ClassUtility.proficiencies));
		map.put("Race Names", Utility.mapListToJSON(display,RandomNameGen.raceNames));
		return map;
	}

	
}

