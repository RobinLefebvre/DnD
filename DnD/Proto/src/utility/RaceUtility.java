package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceUtility {
	public static Map<String, Integer> speed = new HashMap<String, Integer>();
	public static Map<String, Map<String, Integer>> abilityBonus = new HashMap< String, Map<String, Integer> >();
	public static Map<String, List<String>> proficiencies = new HashMap<String, List<String>>();
	
	static {
		for(String race : CharacterUtility.racesList){
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			List<String> p = new ArrayList<String>();
			switch(race){
				case "Dragonborn" : 
					speed.put(race, 30);
					map.put("Strength", 2);
					map.put("Charisma", 1);
					abilityBonus.put(race, map);
					p.add("Common");
					p.add("Draconic");
					p.add("Breath Weapon");
					p.add("Elemental Resistance");
					proficiencies.put(race, p);
					break;
				case "Dwarf (Hill)" : 
					speed.put(race, 25);
					map.put("Constitution", 2);
					map.put("Wisdom", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Dwarvish");
					p.add("Stonecutter's Lore");
					p.add("Poison Resistance");
					p.add("Smith's Tools");
					p.add("HP max +1 per level");
					proficiencies.put(race, p);
					break;
				case "Dwarf (Mountain)" : 
					speed.put(race, 25);
					map.put("Constitution", 2);
					map.put("Strength", 2);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Dwarvish");
					p.add("Stonecutter's Lore");
					p.add("Poison Resistance");
					p.add("Mason's Tools");
					p.add("Light");
					p.add("Medium");
					proficiencies.put(race, p);
					break;
				case "Elf (High)" :
					speed.put(race, 30);
					map.put("Dexterity", 2);
					map.put("Intelligence", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Elven");
					p.add("Perception");
					p.add("Charm Resistance");
					p.add("Sleep resistance");
					p.add("Trance");
					p.add("Longbow");
					p.add("Shortbow");
					p.add("Longsword");
					p.add("Shortsword");
					p.add("One Wizard Cantrip");
					p.add("One extra language");
					proficiencies.put(race, p);

					break;
				case "Elf (Wood)" : 
					speed.put(race, 35);
					map.put("Dexterity", 2);
					map.put("Wisdom", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Elven");
					p.add("Perception");
					p.add("Charm Resistance");
					p.add("Sleep resistance");
					p.add("Trance");
					p.add("Longbow");
					p.add("Shortbow");
					p.add("Longsword");
					p.add("Shortsword");
					p.add("Mask Of The Wild");
					proficiencies.put(race, p);
					
					break;
				case "Elf (Drow)" : 
					speed.put(race, 30);
					map.put("Dexterity", 2);
					map.put("Charisma", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (30)");
					p.add("Common");
					p.add("Elven");
					p.add("Perception");
					p.add("Charm Resistance");
					p.add("Sleep resistance");
					p.add("Trance");
					p.add("Sunlight Sensitivity");
					p.add("Rapier");
					p.add("Shortsword");
					p.add("Hand Crossbow");
					proficiencies.put(race, p);

					break;
				case "Gnome (Forest)" : 
					speed.put(race, 25);
					map.put("Intelligence", 2);
					map.put("Dexterity", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Gnomish");
					p.add("Advantage INT, WIS, CHA saving throws");
					p.add("Minor Illusion Cantrip");
					p.add("Speak with small beasts");
					proficiencies.put(race, p);

					break;
				case "Gnome (Rock)" : 
					speed.put(race, 25);
					map.put("Intelligence", 2);
					map.put("Constitution", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Gnomish");
					p.add("Artificer's Lore");
					p.add("Tinker's Tools");
					p.add("Craft Clockwork Device");
					proficiencies.put(race, p);

					break;
				case "Gnome (Deep)" : 
					speed.put(race, 25);
					map.put("Intelligence", 2);
					map.put("Dexterity", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (30)");
					p.add("Common");
					p.add("Gnomish");
					p.add("Undercommon");
					p.add("Stone Camouflage");
					proficiencies.put(race, p);
					break;
				case "Goblin" : 
					speed.put(race, 30);
					map.put("Dexterity", 2);
					map.put("Constitution", 1);
					map.put("Intelligence", -1);
					abilityBonus.put(race, map);
					p.add("Darkvision (30)");
					p.add("Common");
					p.add("Goblin");
					p.add("Undercommon");
					proficiencies.put(race, p);
					break;
				case "Halfling (Lightfoot)" : 
					speed.put(race, 25);
					map.put("Dexterity", 2);
					map.put("Charisma", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Halfling");
					p.add("Lucky");
					p.add("Freightened Resistance");
					p.add("Move around larger creatures");
					p.add("Hide behind larger creatures");
					proficiencies.put(race, p);
					break;
				case "Halfling (Stout)" : 
					speed.put(race, 25);
					map.put("Dexterity", 2);
					map.put("Constitution", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Halfling");
					p.add("Lucky");
					p.add("Freightened Resistance");
					p.add("Move around larger creatures");
					p.add("Poison Resistance");
					proficiencies.put(race, p);

					break;
				case "Half-Elf" : /*TODO : 1 random attribute */
					speed.put(race, 30);
					map.put("Charisma", 2);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Elven");
					p.add("Charm Resistance");
					p.add("Sleep Resistance");
					p.add("Choose Two Skills");
					p.add("One Extra Language");
					proficiencies.put(race, p);

					break;
				case "Half-Orc" : 
					speed.put(race, 30);
					map.put("Strength", 2);
					map.put("Constitution", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Orcish");
					p.add("Intimidation");
					p.add("Relentless Endurance");
					p.add("Savage Critical");
					proficiencies.put(race, p);
					break;
				case "Human" : 
					speed.put(race, 30);
					map.put("Strength", 1);
					map.put("Dexterity", 1);
					map.put("Intelligence", 1);
					map.put("Constitution", 1);
					map.put("Wisdom", 1);
					map.put("Charisma", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("One Extra Language");
					proficiencies.put(race, p);
					break;
				case "Kobold" : 
					speed.put(race, 30);
					map.put("Strength", -2);
					map.put("Dexterity", 2);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					proficiencies.put(race, p);
					break;
				case "Orc" : 
					speed.put(race, 30);
					map.put("Strength", 2);
					map.put("Constitution", 1);
					map.put("Intelligence", -1);
					abilityBonus.put(race, map);
					p.add("Darkvision (15)");
					p.add("Common");
					p.add("Orcish");
					p.add("Undercommon");
					proficiencies.put(race, p);
					break;
				case "Tiefling" : 
					speed.put(race, 30);
					map.put("Charisma", 2);
					map.put("Intelligence", 1);
					abilityBonus.put(race, map);
					p.add("Darkvision (30)");
					p.add("Common");
					p.add("Infernal");
					p.add("Fire Resistance");
					p.add("Infernal Magic");
					proficiencies.put(race, p);
					break;
			}
		}
	}

}
