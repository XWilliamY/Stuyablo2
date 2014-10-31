import java.util.Random;
public class Rogue extends Adventurer{
    private int dex, stamina, intelligence, str;
    Random rand = new Random();

    public void setDex(int dex){
	this.dex = dex;
    }

    public int getDex(){
	return dex;
    }

    public void setInt(int intelligence){
	this.intelligence = intelligence;
    }
    public int getInt(){
	return intelligence;
    }

    public void setStr(int str){
	this.str = str;
    }

    public int getStr(){
	return str;
    }

    public void setStamina(int stamina){
	this.stamina = stamina;
    }

    public int getStamina(){
	return stamina;
    }

    public Rogue(){
	setName("Bond");
	setDex(15);
	setStamina(20);
	setInt(10);
	setStr(5);
    }

    public Rogue(String name){
	setName(name);
	setDex(15);
	setStamina(20);
	setInt(10);
	setStr(5);
    }

    public void attack(Adventurer other){
	if(super.hit()){
	    if(getStamina() > 0){
		int x = 1;
		int damage = getDex()/5;
		int total = 0;
		while( x < 4){
		    int dmg = rand.nextInt(damage - 1) + 1;
		    other.setHP((other.getHP()) - dmg);
		    System.out.println(getName() + " stabs " +  other.getName() + " for " + dmg + " damage!");
		    total += dmg;
		    x+=1;
		}
		System.out.println(getName() + " stabbed " + other.getName()+ " three times in total, dealing " + total + " damage!");
		setStamina(getStamina()-1);
		System.out.println(getName() + " has " + getStamina() + " stamina");
	    }
	    else{
		System.out.println(getName() + " has no stamina! Instead, ");
		super.attack(other);
	    }
	}
	else{
	    System.out.println(getName() + " misses, instead stabbing at air!");
	     }
    }


public void specialAttack(Adventurer other){
    if(super.hit()){
	if(getStamina() > 10){
	    int dmg = rand.nextInt(10);
	    if(dmg > 8){
		other.setHP((other.getHP()) - 10+(getDex()/2));
		System.out.println(getName() + " sneaks behind " + other.getName() + " and backstabs " + other.getName() + " for " + dmg + "  damage!");
	    }
	    else{
		other.setHP((other.getHP()) - (getDex()/2));
		System.out.println(getName() + " backstabs" + other.getName() + " for " + (getDex()/2) + " damage");
	    }
	    setStamina(getStamina()-10);
	    System.out.println(getName() + " has " + getStamina() + " stamina");
	}
	else{
	    System.out.println(getName() + " doesn't have enough stamina! Instead, ");
	    attack(other);
	}
    }
    else{
	System.out.println(getName() + " attempts to backstab " + other.getName() + " but misses!");
    }
}

public String getStats(){
    return super.getStats() + " " + getStr() + "STR " + getInt() +"INT " + getDex() + "DEX " + getStamina() + "Stamina " + "Rogue";
}

}
