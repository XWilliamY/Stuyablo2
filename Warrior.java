import java.util.Random;

public class Warrior extends Adventurer{
    private int bonusHealth, str, rage, intelligence, dex;
    Random rand = new Random();

    public void setbonusHP(int bonus){
	bonusHealth = bonus;
    }

    public int getbonusHP(){
	return bonusHealth;
    }

    public void setStr(int str){
	this.str = str;
    }

    public int getStr(){
	return str;
    }

    public void setRage(int rage){
	this.rage = rage;
    }

    public int getRage(){
	return rage;
    }

    public int getInt(){
	return intelligence;
    }

    public void setInt(int a){
	intelligence = a;
    }

    public int getDex(){
	return dex;
    }

    public void setDex(int b){
	dex = b;
    }
    public Warrior(){
	bonusHealth = 10;
	setRage(0);
	setStr(12);
	setHP(getHP() + bonusHealth);
	setName("Garg");
	setInt(8);
	setDex(10);
	
    }

    public Warrior(String name){
	setbonusHP(10);
	setRage(0);
	setStr(12);
	setHP(getHP() + bonusHealth);
	setInt(8);
	setDex(10);
	setName(name);
    }




    public void attack(Adventurer other){
	Double rawPower = (getStr()/(double)(getInt()+getDex()+getStr()) * 10);
	int power = rand.nextInt(rawPower.intValue()) + 1;
	if(super.hit()){
	    other.setHP((other.getHP()) - power);
	    System.out.println(getName() + " swings recklessly at " + other.getName() + " for " + power + " damage");
	    setRage(getRage()+10);
	}
	else{
	    System.out.println(getName() + " swings recklessly at " + other.getName() + " but misses, dealing 0 damage");
	}

    }

    public void specialAttack(Adventurer other){
	int power = rand.nextInt(str/2)+1;
	if(rage > 0){
	    if(super.hit()){
		power += (getRage()/10);
		other.setHP((other.getHP()) - power);
		System.out.println(getName() + " pulverizes " + other.getName() + " for " + power + " damage");
		setRage(0);
	    }
	    else{
		System.out.println(getName() + " attempts to pulverize " + other.getName() + " but fails! Instead, ");
		attack(other);
	    }
	}
    
	else{
	    System.out.println(getName() + " doesn't have enough rage to pulverize " + other.getName() + "! Instead, ");
	    attack(other);
	}
    }  





public String getStats(){
    return super.getStats() + " "+getStr()+"STR " + getInt()+"INT " + getDex()+"DEX " +getRage()+"Rage " + "Warrior";
}

}
