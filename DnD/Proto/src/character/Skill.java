package character;

public class Skill {
	private int bonus;
	private boolean proficient;
	
	public Skill(int bonus, boolean proficiency) {
		super();
		this.bonus = bonus;
		this.proficient = proficiency;
	}

	public int getBonus() {
		return bonus;
	}
	
	boolean isProficient() {
		return proficient;
	}
}

