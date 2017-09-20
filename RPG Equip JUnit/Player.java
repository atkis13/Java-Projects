public class Player {
	
	int damage = 5;
	int stamina = 5;
	int magic  = 0;
	
	public void equip (Sword o) {
		damage += o.damage;
		stamina +=o.stamina;
		magic +=o.magic;
		
	}

}
