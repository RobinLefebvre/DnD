package character;

import java.util.*;

import utility.CharacterUtility;

public class AC {
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public AC(Map<String, Integer> abilityScore, Map<String, Boolean> proficiencies) {
		if(proficiencies.containsKey("Unarmored Defense Barbarian")){
			map.put("Unarmored", 10 + CharacterUtility.getAbilityBonus("Constitution", abilityScore) + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		}
		else if(proficiencies.containsKey("Unarmored Defense Monk")){
			map.put("Unarmored", 10 + CharacterUtility.getAbilityBonus("Wisdom", abilityScore) + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		}else {
			map.put("Unarmored", 10 + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		}
		map.put("Padded", 11 + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		map.put("Leather", 11 + CharacterUtility.getAbilityBonus("Dexterity" , abilityScore));
		map.put("Studded", 12 + CharacterUtility.getAbilityBonus("Dexterity" , abilityScore));
		map.put("Hide", 12 + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		map.put("Chain shirt", 13 + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		map.put("Scale mail", 14 + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		map.put("Breatplate", 14 + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		map.put("Half plate", 15 + CharacterUtility.getAbilityBonus("Dexterity", abilityScore));
		map.put("Ring mail", 14);
		map.put("Chain mail", 16);
		map.put("Splint", 17);
		map.put("Plate", 18);
		map.put("Shield", 2);
	}
	
	public int getArmorClass(String armor){
		if(map.containsKey(armor))
			return (map.get(armor));
		else 
			return 0;
	}
	
}
