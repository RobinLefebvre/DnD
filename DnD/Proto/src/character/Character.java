package character;

import utility.CharacterUtility;
import utility.ClassUtility;
import utility.DiceRoll;
import utility.RaceUtility;
import java.util.*;

@SuppressWarnings("unused")
public class Character {
	private String name;
	private int level;
	private int experience;
	
	private String race;
	private String[] classes;
	private int movementSpeed;
	private int hitPoints;
	
	private int age;
	private String ageDescription;
	private String alignment;
	
	private Map<String, Integer> abilityScore 	= new HashMap<String, Integer>();
	private Map<String, Skill>   skillsBonus 	= new HashMap<String, Skill>() ;
	private Map<String, Boolean> proficiencies 	= new HashMap<String, Boolean>();
	private int proficiencyBonus;
	
	private AC armorClass;	
	private Equipment equipment;
	
	/* START - Constructors  */
	public Character(String name, int level, int experience, String race, String[] classes, int age, String alignment, Map<String, Integer> abilityScore, Map<String, Skill> skillsBonus, Map<String, Boolean> proficiencies) {
		super();
		this.name = name;
		this.level = level;
		this.experience = experience;
		
		this.abilityScore = abilityScore;
		this.skillsBonus = skillsBonus;
		this.proficiencies = proficiencies;
		
		this.race = race;
		this.movementSpeed = RaceUtility.speed.get(race);
		this.classes = classes;
		this.hitPoints = ClassUtility.hitPoints.get(classes[0]) + this.getAbilityBonus("Constitution"); 
		if(proficiencies.containsKey("HP max +1 per level")){
			this.hitPoints ++;
		}
		this.age = age;
		this.ageDescription = CharacterUtility.getAgeDescription(age, race);
		this.alignment = alignment;
		this.armorClass = new AC(abilityScore, proficiencies);
		this.equipment = new Equipment(classes[0]);
		
		if(level < 5)
			this.proficiencyBonus = 2;
		else if (level < 9)
			this.proficiencyBonus = 3;
		else if (level < 13)
			this.proficiencyBonus = 4;
		else if (level < 17)
			this.proficiencyBonus = 5;
		else 
			this.proficiencyBonus = 6;
		
	}
	
	/* START - Behavior  */
	public int rollSkill (String skill){
		int bonus = 0;
		for(String ability : CharacterUtility.skillsAbilityMap.keySet()){
			if(CharacterUtility.skillsAbilityMap.get(ability).contains(skill)){
				bonus = this.getAbilityBonus(ability);
			}
		}
		int dice = DiceRoll.rollDice(false, "1d20 + " + bonus);
		return dice;
	}
	
	/* START - getters & setters  */
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public String getRace (){
		return this.race;
	}
	
	public int getMovementSpeed(){
		return this.movementSpeed / 5;
	}
	
	private void setMovementSpeed() {
		this.movementSpeed = RaceUtility.speed.get(race);
	}
	
	public int getHitPoints(){
		return this.hitPoints;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	private void setRace(String race) {
		this.race = race;
	}
	
	public String[] getClasse() {
		return classes;
	}
	
	private void setClasse(String[] classes) {
		this.classes = classes;
	}
	
	public int getAbilityScore(String ability) {
		return abilityScore.get(ability);
	}
	
	
	private void setAbilityScore(Map<String, Integer> abilityScore){
		this.abilityScore = abilityScore;
	}
	
	public int getAbilityBonus (String ability){
		int score =  this.abilityScore.get(ability) - 10;
		score = (score <= 0 && Math.abs(score % 2) == 1) ?(score / 2) - 1 : score / 2 ;
		return score;
	}
	public int getSkillsBonus(String skill){
		Skill s = skillsBonus.get(skill);
		if(s.isProficient())
			return s.getBonus() + this.proficiencyBonus;
		else
			return s.getBonus();
	}
	private void setSkillsBonus(Map<String, Skill> skillsBonus){
		this.skillsBonus = skillsBonus;
	}
	
	public Map<String, Boolean> getProficiencies() {
		return this.proficiencies;
	}
	
	public boolean isProficient(String skill){
		if(this.proficiencies.containsKey(skill)){
			return this.proficiencies.get(skill);
		}
		else{
			return false;
		}
	}
	
	public void setProficiencies(HashMap<String, Boolean> proficiencies) {
		this.proficiencies = proficiencies;
	}
	
	public int getProficiencyBonus() {
		return proficiencyBonus;
	}
	
	/* START - toString  */
	@Override
	public String toString() {
		return 	"Name : " + name + "\nRace : " + race + " | Age : " + age + " ("+ ageDescription +")\nClasses : " + classes[0] 
				+ "\n\nLevel : " + level + "  | Experience : " + experience 
				+ "\nHit Points : " + hitPoints + "\nProficiency Bonus : " + proficiencyBonus 
				+ "\nMovement Speed : " + movementSpeed/5 + " meters per action"
				+ "\n\nAbility Score : \n" + this.displayAbility() 
				+ "\nSkills :\n" + this.displaySkills() 
				+ "\nFeatures :\n"+ this.displayOtherProficiencies() + "\n" 
				+ "\nEquipment : \n" + this.displayEquipment() + "\n";
	}

	public String toJSON(){
		String ret = "{	\n    \"Name\"  : \"" + name + "\",\n    \"Race\" : \"" + race + "\",\n    \"Age\" : " + age + ",\n    \"Classes\" : \"" + classes[0] + "\","
						+ "\n    \"Level\" : " + level + ",\n    \"Experience\" : " + experience + ",\n    \"Proficiency Bonus\" : " + proficiencyBonus + ","
						+ "\n    \"Movement Speed\" : " + movementSpeed/5 +  ","
						+ "\n    \"Hit Points\" : " + hitPoints +  ",\n"
						+ "\n    \"Ability Scores & Bonuses\" : \n    { \n" + this.displayAbility()+ "    },"
						+ "\n    \"Skill Bonuses\" : \n    { \n" + this.displaySkills()+ "    },"
						+ "\n    \"Skill Proficiencies\" : \n    [ \n" + this.displaySkillProficiencies()+ "    ],"
						+ "\n    \"Language Proficiencies\" : \n    [ \n" + this.displayLanguageProf() 			+ "    ],"
						+ "\n    \"Weapon Proficiencies\":  \n    [ \n" + this.displayWeaponProf() 			+ "    ],"
						+ "\n    \"Armor Proficiencies\" : \n    [ \n" + this.displayArmorProf() 			+ "    ],"
						+ "\n    \"Armor Classes\" : \n    { \n" + this.displayArmorClass() 			+ "    },"
						+ "\n    \"Features\" : \n    [ \n" + this.displayOtherProficiencies() 	+ "    ],"
						+ "\n    \"Equipment\" : \n    [ \n" + this.displayEquipment() 	+ "    ]"
						+ " }";
		ret = ret.replace(",\n    ]", "\n    ]");
		ret = ret.replace(",\n    }", "\n    }");
		return ret;
	}
	private String displayEquipment() {
		String ret = "";
		for(String s : this.equipment.equipment.keySet()){
			ret+= "        \"" + s + "\",\n";
		}
		return ret;
	}
	
	private String displayArmorClass(){
		String ret = "";
		for (String armorType : CharacterUtility.armorProf.keySet()){
			if(this.proficiencies.containsKey(armorType)){
				for(String armor : CharacterUtility.armorProf.get(armorType)){
					ret += "       \"" + armor + "\" : \"" + armorClass.getArmorClass(armor) +"\",\n";
				}
			}
		}
		return ret;
	}

	private String displayArmorProf() {
		String ret = "";
		int i = 1;
		for (String skill : this.proficiencies.keySet()){
			if(CharacterUtility.armorProf.containsKey(skill)){
				ret += "       \"" + skill + "\"";
				if(i != this.proficiencies.keySet().size() -2) { ret += ","; }
				ret+= "\n";
				i++;
			}
		}
		return ret;
	}
	
	private String displayWeaponProf() {
		String ret = "";
		int i = 0;
		for (String skill : this.proficiencies.keySet()){
			if(CharacterUtility.weaponProf.contains(skill)){
				ret += "       \"" + skill + "\"";
				if(i != this.proficiencies.keySet().size()) { ret += ","; }
				ret += "\n";
			}
			i++;
		}
		return ret;
	}
	
	private String displaySkills() {
		String ret = "";
		int i = 0;
		for (String skill : CharacterUtility.skillsList){
			ret += "      \"" + skill + "\" : " + this.getSkillsBonus(skill) + "";
			if(i != this.proficiencies.keySet().size()) { ret += ","; }
			ret += "\n";
			
			i++;
		}
		return ret;
	}
	
	private String displayAbility() {
		String ret = "";
		for (String ability : CharacterUtility.abilityList){
			ret += "       \"" + ability + "\" : [" + this.getAbilityScore(ability) + ", " + this.getAbilityBonus(ability) + "]";
			ret += ",";
			ret += "\n";
		}
		return ret;
	}
	private String displaySkillProficiencies(){
		String ret = "";
		for(String skill : this.proficiencies.keySet()){
			if(CharacterUtility.skillsList.contains(skill))
				ret += "       \"" + skill + "\",\n";
		}
		return ret;
	}
	private String displayOtherProficiencies(){
		String ret = "";
		for(String skill : this.proficiencies.keySet()){
			if(!CharacterUtility.skillsList.contains(skill) && !CharacterUtility.languageProf.contains(skill) && ! CharacterUtility.weaponProf.contains(skill) && !CharacterUtility.armorProf.containsKey(skill))
				ret += "       \"" + skill + "\",\n";
		}
		return ret;
	}
	
	private String displayLanguageProf() {
		String ret = "";
		for (String skill : this.proficiencies.keySet()){
			if(CharacterUtility.languageProf.contains(skill))
				ret += "       \"" + skill + "\",\n";
		}
		return ret;
	}

}

