package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassUtility {

	
	public static Map<String, Integer> hitPoints = new HashMap<String, Integer>();
	public static Map<String, List<String>> proficiencies = new HashMap<String, List<String>>();
	public static Map<String, List<String>> accessibleProficiencies = new HashMap<String, List<String>>();
	public static Map<String, List<String>> startingEquipment = new HashMap<String, List<String>>();
	
	static {
		for(String classe : CharacterUtility.classList){
			List<String> p = new ArrayList<String>();
			List<String> accessibleP = new ArrayList<String>();
			List<String> startEquip = new ArrayList<String>();
			switch(classe){
				case "Barbarian" : 
					hitPoints.put(classe, 12);
					p.add("Unarmored");
					p.add("Light");
					p.add("Medium");
					p.add("Shield");
					p.addAll(CharacterUtility.weaponProf);
					p.add("Rage");
					p.add("Unarmored Defense Barbarian");
					
					ArrayList<String> barbarianP = new ArrayList<String>(); 
					barbarianP.addAll(Arrays.asList("Animal Handling","Athletics","Intimidation", "Nature", "Perception", "Survival"));
					accessibleP.addAll(barbarianP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String b1 = Utility.pickRandom(barbarianP);
					p.add(b1);
					barbarianP.remove(b1);
					String b2 = Utility.pickRandom(barbarianP);
					p.add(b2);
					barbarianP.remove(b2);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Greataxe", Utility.pickRandom(CharacterUtility.martialWeapon))));
					startEquip.add(Utility.pickRandom(Arrays.asList("Handaxe (2)", Utility.pickRandom(CharacterUtility.simpleWeapon))));
					startEquip.add("Explorer's Pack");
					startEquip.add("Javelin (4)");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Bard" : 
					hitPoints.put(classe, 8);
					p.add("Unarmored");
					p.add("Light");
					p.addAll(CharacterUtility.simpleWeapon);
					p.add("Hand Crossbow");
					p.add("Longsword");
					p.add("Rapier");
					p.add("Shortsword");
					p.add("Three Musical Instruments");
					p.add("Spellcasting");
					p.add("Cantrips Known : 2");
					p.add("Spells known : 4");
					p.add("1st level spell slot : 2");
					p.add("Inpiration (d6)");
					
					p.add(Utility.pickRandom(CharacterUtility.skillsList));
					p.add(Utility.pickRandom(CharacterUtility.skillsList));
					p.add(Utility.pickRandom(CharacterUtility.skillsList));
					accessibleP.addAll(CharacterUtility.skillsList);
					accessibleProficiencies.put(classe, accessibleP);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Rapier", "Longsword", Utility.pickRandom(CharacterUtility.martialWeapon))));
					startEquip.add(Utility.pickRandom(CharacterUtility.simpleWeapon));
					startEquip.add(Utility.pickRandom(Arrays.asList("Explorer's Pack", "Entertainer's Pack")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Lute", "Musical Instrument")));
					startEquip.add("Leather");
					startEquip.add("Dagger");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Cleric" : 
					hitPoints.put(classe, 8);
					p.add("Unarmored");
					p.add("Light");
					p.add("Medium");
					p.add("Shield");
					p.addAll(CharacterUtility.simpleWeapon);
					p.add("Spellcasting");
					p.add("Cantrips Known : 3");
					p.add("1st level spell slot : 2");
					p.add("Divine Domain");
					
					ArrayList<String> clericP = new ArrayList<String>(); 
					clericP.addAll(Arrays.asList("History","Insight","Medicine", "Persuasion", "Religion"));
					accessibleP.addAll(clericP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String c1 = Utility.pickRandom(clericP);
					p.add(c1);
					clericP.remove(c1);
					String c2 = Utility.pickRandom(clericP);
					p.add(c2);
					clericP.remove(c2);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Mace", "Warhammer")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Scale mail", "Leather", "Chain mail")));
					startEquip.add(Utility.pickRandom(Arrays.asList(Utility.pickRandom(CharacterUtility.simpleWeapon), "Light Crossbow")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Priest's Pack", "Explorer's Pack")));
					startEquip.add("Shield");
					startEquip.add("Holy Symbol");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Druid" :
					hitPoints.put(classe, 8);
					p.add("Unarmored");
					p.add("Light");
					p.add("Medium");
					p.add("Shield");
					p.add("Club");
					p.add("Dagger");
					p.add("Dart");
					p.add("Javelin");
					p.add("Mace");
					p.add("Quarterstaff");
					p.add("Scimitar");
					p.add("Sickle");
					p.add("Sling");
					p.add("Spear");
					p.add("Herbalism Kit");
					p.add("Druidic");
					p.add("Spellcasting");
					p.add("Cantrips Known : 2");
					p.add("1st level spell slot : 2");
					
					ArrayList<String> druidP = new ArrayList<String>(); 
					druidP.addAll(Arrays.asList("Animal Handling","Insight","Medicine", "Nature", "Perception", "Religion", "Survival"));
					accessibleP.addAll(druidP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String d1 = Utility.pickRandom(druidP);
					p.add(d1);
					druidP.remove(d1);
					String d2 = Utility.pickRandom(druidP);
					p.add(d2);
					druidP.remove(d2);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Wooden Shield", Utility.pickRandom(CharacterUtility.simpleWeapon))));
					startEquip.add(Utility.pickRandom(Arrays.asList("Scimitar", Utility.pickRandom(CharacterUtility.simpleWeapon))));
					startEquip.add("Leather");
					startEquip.add("Explorer's Pack");
					startEquip.add("Druidic Focus");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Fighter" : 
					hitPoints.put(classe, 10);
					p.add("Unarmored");
					p.add("Light");
					p.add("Medium");
					p.add("Heavy");
					p.add("Shield");
					p.addAll(CharacterUtility.weaponProf);
					p.add("Fighting Style");
					p.add("Second Wind");
					
					ArrayList<String> fighterP = new ArrayList<String>(); 
					fighterP.addAll(Arrays.asList("Acrobatics","Animal Handling","Athletics", "History", "Insight", "Intimidation","Perception", "Survival"));
					accessibleP.addAll(fighterP);
					accessibleProficiencies.put(classe, fighterP);
					
					accessibleP.addAll(fighterP);
					String f1 = Utility.pickRandom(fighterP);
					p.add(f1);
					fighterP.remove(f1);
					String f2 = Utility.pickRandom(fighterP);
					p.add(f2);
					fighterP.remove(f2);
					
					if (Utility.pickRandom(Arrays.asList("a", "b")).equals("a")){
						startEquip.add("Chain mail");
					}else {
						startEquip.add("Leather");
						startEquip.add("Longbow");
					}
					if (Utility.pickRandom(Arrays.asList("a", "b")).equals("a")){
						startEquip.add(Utility.pickRandom(CharacterUtility.martialWeapon));
						startEquip.add(Utility.pickRandom(CharacterUtility.martialWeapon));
					}else {
						startEquip.add("Shield");
						startEquip.add(Utility.pickRandom(CharacterUtility.martialWeapon));
					}
					if (Utility.pickRandom(Arrays.asList("a", "b")).equals("a")){
						startEquip.add("Light Crossbow");
					}else {
						startEquip.add("Handaxe (2)");
					}
					if (Utility.pickRandom(Arrays.asList("a", "b")).equals("a")){
						startEquip.add("Dungeoneer's Pack");
					}else{
						startEquip.add("Explorer's Pack");
					}
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Monk" : 
					hitPoints.put(classe, 8);
					p.add("Unarmored");
					p.addAll(CharacterUtility.simpleWeapon);
					p.add("Shortsword");
					p.add("One Artisan's Tool");
					p.add("One musical instrument");
					p.add("Unarmored Defense Monk");
					p.add("Martial Arts");
					
					ArrayList<String> monkP = new ArrayList<String>(); 
					monkP.addAll(Arrays.asList("Acrobatics","Athletics", "History", "Insight", "Religion","Stealth"));
					accessibleP.addAll(monkP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String m1 = Utility.pickRandom(monkP);
					p.add(m1);
					monkP.remove(m1);
					String m2 = Utility.pickRandom(monkP);
					p.add(m2);
					monkP.remove(m2);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Shortsword", Utility.pickRandom(CharacterUtility.simpleWeapon))));
					startEquip.add(Utility.pickRandom(Arrays.asList("Explorer's Pack", "Dungoeneer's Pack")));
					startEquip.add("Darts (10)");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Paladin" : 
					hitPoints.put(classe, 10);
					p.add("Unarmored");
					p.add("Light");
					p.add("Medium");
					p.add("Heavy");
					p.add("Shield");
					p.addAll(CharacterUtility.weaponProf);
					p.add("Divine Sense");
					p.add("Lay Of Hands");
					
					ArrayList<String> paladinP = new ArrayList<String>(); 
					paladinP.addAll(Arrays.asList("Athletics", "Insight", "Intimidation", "Medicine", "Persuasion", "Religion"));
					accessibleP.addAll(paladinP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String p1 = Utility.pickRandom(paladinP);
					p.add(p1);
					paladinP.remove(p1);
					String p2 = Utility.pickRandom(paladinP);
					p.add(p2);
					paladinP.remove(p2);
					
					if (Utility.pickRandom(Arrays.asList("a", "b")).equals("a")){
						startEquip.add(Utility.pickRandom(CharacterUtility.martialWeapon));
						startEquip.add(Utility.pickRandom(CharacterUtility.martialWeapon));
					}else {
						startEquip.add("Shield");
						startEquip.add(Utility.pickRandom(CharacterUtility.martialWeapon));
					}	
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Javelin (5)", Utility.pickRandom(CharacterUtility.simpleWeapon))));
					startEquip.add(Utility.pickRandom(Arrays.asList("Explorer's Pack", "Priest's Pack")));
					startEquip.add("Chain mail");
					startEquip.add("Holy symbol");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Ranger" : 
					hitPoints.put(classe, 10);
					p.add("Unarmored");
					p.add("Light");
					p.add("Medium");
					p.add("Shield");
					p.addAll(CharacterUtility.weaponProf);
					p.add("Favored Enemy");
					p.add("Natural Explorer");
					
					ArrayList<String> rangerP = new ArrayList<String>(); 
					rangerP.addAll(Arrays.asList("Animal Handling", "Athletics", "Insight", "Investigation", "Nature","Perception", "Stealth","Survival"));
					accessibleP.addAll(rangerP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String r1 = Utility.pickRandom(rangerP);
					p.add(r1);
					rangerP.remove(r1);
					String r2 = Utility.pickRandom(rangerP);
					p.add(r2);
					rangerP.remove(r2);
					String r3 = Utility.pickRandom(rangerP);
					p.add(r3);
					rangerP.remove(r3);
					
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Scale mail", "Leather")));
					if (Utility.pickRandom(Arrays.asList("a", "b")).equals("a")){
						startEquip.add("Shortsword (2)");
					}else {
						startEquip.add(Utility.pickRandom(CharacterUtility.simpleWeapon));
						startEquip.add(Utility.pickRandom(CharacterUtility.simpleWeapon));
					}	
					startEquip.add(Utility.pickRandom(Arrays.asList("Explorer's Pack", "Priest's Pack")));
					startEquip.add("Longbow");
					startEquip.add("Quiver");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Rogue" : 
					hitPoints.put(classe, 8);
					p.add("Unarmored");
					p.add("Light");
					p.addAll(CharacterUtility.simpleWeapon);
					p.add("Hand Crossbow");
					p.add("Longsword");
					p.add("Rapier");
					p.add("Shortsword");
					p.add("Thieves' Tools");
					p.add("Expertise");
					p.add("Sneak Attack");
					p.add("Thieves' Cant");
					
					ArrayList<String> rogueP = new ArrayList<String>(); 
					rogueP.addAll(Arrays.asList("Acrobatics","Athletics","Deception", "Insight","Intimidation", "Investigation", "Perception","Performance", "Persuasion", "Sleight Of Hand", "Stealth"));
					accessibleP.addAll(rogueP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String ro1 = Utility.pickRandom(rogueP);
					p.add(ro1);
					rogueP.remove(ro1);
					String ro2 = Utility.pickRandom(rogueP);
					p.add(ro2);
					rogueP.remove(ro2);
					String ro3 = Utility.pickRandom(rogueP);
					p.add(ro3);
					rogueP.remove(ro3);
					String ro4 = Utility.pickRandom(rogueP);
					p.add(ro4);
					rogueP.remove(ro4);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Rapier", "Shortsword")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Shortbow", "Shortsword")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Explorer's Pack", "Burglar's Pack", "Dungeoneer's Pack")));
					startEquip.add("Leather");
					startEquip.add("Dagger (2)");
					startEquip.add("Thieves' Tools");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Sorcerer" : 
					hitPoints.put(classe, 6);
					p.add("Unarmored");
					p.add("Dagger");
					p.add("Dart");
					p.add("Sling");
					p.add("Quarterstaff");
					p.add("Light Crossbow");
					p.add("Spellcasting");
					p.add("Cantrips Known : 4");
					p.add("Spells known : 2");
					p.add("1st level spell slot : 2");
					p.add("Sourcerous Origin");
					
					ArrayList<String> sorcererP = new ArrayList<String>(); 
					sorcererP.addAll(Arrays.asList("Arcana","Deception","Insight", "Intimidation", "Persuasion", "Religion"));
					accessibleP.addAll(sorcererP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String so1 = Utility.pickRandom(sorcererP);
					p.add(so1);
					sorcererP.remove(so1);
					String so2 = Utility.pickRandom(sorcererP);
					p.add(so2);
					sorcererP.remove(so2);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Light Crossbow", Utility.pickRandom(CharacterUtility.simpleWeapon))));
					startEquip.add(Utility.pickRandom(Arrays.asList("Component Pouch", "Arcane Focus")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Explorer's Pack", "Dungeoneer's Pack")));
					startEquip.add("Dagger (2)");
					startingEquipment.put(classe, startEquip);
					
					proficiencies.put(classe, p);
					break;
					
				case "Warlock" : 
					hitPoints.put(classe, 8);
					p.add("Unarmored");
					p.add("Light");
					p.addAll(CharacterUtility.simpleWeapon);
					p.add("Otherwordly Patron");
					p.add("Spellcasting");
					p.add("Cantrips Known : 2");
					p.add("Spells known : 2");
					p.add("1st level spell slot : 2");
					
					ArrayList<String> warlockP = new ArrayList<String>(); 
					warlockP.addAll(Arrays.asList("Arcana","Deception","History", "Intimidation", "Investigation", "Nature", "Religion"));
					accessibleP.addAll(warlockP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String w1 = Utility.pickRandom(warlockP);
					p.add(w1);
					warlockP.remove(w1);
					String w2 = Utility.pickRandom(warlockP);
					p.add(w2);
					warlockP.remove(w2);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Light Crossbow", Utility.pickRandom(CharacterUtility.simpleWeapon))));
					startEquip.add(Utility.pickRandom(Arrays.asList("Component Pouch", "Arcane Focus")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Scholar's Pack", "Dungeoneer's Pack")));
					startEquip.add(Utility.pickRandom(CharacterUtility.simpleWeapon));
					startEquip.add("Leather");
					startEquip.add("Dagger (2)");
					startingEquipment.put(classe, startEquip);

					proficiencies.put(classe, p);
					break;
					
				case "Wizard" : 
					hitPoints.put(classe, 6);
					p.add("Unarmored");
					p.add("Dagger");
					p.add("Dart");
					p.add("Sling");
					p.add("Quarterstaff");
					p.add("Light Crossbow");
					p.add("Spellcasting");
					p.add("Cantrips Known : 3");
					p.add("Spells known : 2");
					p.add("1st level spell slot : 2");
					p.add("Arcane Recovery");
					
					ArrayList<String> wizardP = new ArrayList<String>(); 
					wizardP.addAll(Arrays.asList("Arcana","History","Insight", "Investigation", "Medicine", "Religion"));
					accessibleP.addAll(wizardP);
					accessibleProficiencies.put(classe, accessibleP);
					
					String wi1 = Utility.pickRandom(wizardP);
					p.add(wi1);
					wizardP.remove(wi1);
					String wi2 = Utility.pickRandom(wizardP);
					p.add(wi2);
					wizardP.remove(wi2);
					
					startEquip.add(Utility.pickRandom(Arrays.asList("Quarterstaff", "Dagger")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Component Pouch", "Arcane Focus")));
					startEquip.add(Utility.pickRandom(Arrays.asList("Scholar's Pack", "Dungeoneer's Pack")));
					startEquip.add("Spellbook");
					startingEquipment.put(classe, startEquip);

					
					proficiencies.put(classe, p);
					break;
			}
		}
	}
}
