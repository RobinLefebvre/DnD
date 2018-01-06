package character;

import java.util.*;

import utility.ClassUtility;

public class Equipment {
	
	Map<String, Integer> equipment = new HashMap<String, Integer>();
	
	public Equipment(String classes) {
		for(String objet : ClassUtility.startingEquipment.get(classes)){
			this.equipment.put(objet, 1);
		}
	}

	
}
