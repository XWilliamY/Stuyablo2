import java.util.Random;
public class Wizard extends Adventurer{
    private int intelligence, mana, str, dex;
    Random rand = new Random();

    public void setMana(int mana){
	this.mana = mana;
    }

    public int getMana(){
	return mana;
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

    public void setDex(int dex){
	this.dex = dex;
    }

    public int getDex(){
	return dex;
    }


    public Wizard(){
	setMana(20);
	setInt(20);
	setDex(5);
	setStr(5);
	setName("Vanderloss");
    }

    public Wizard(String name){
	setMana(20);
	setInt(20);
	setDex(5);
	setStr(5);
	setName(name);
    }

    public void attack(Adventurer other){
	if(super.hit()){
	    if(getMana() > 0){
		int damage = rand.nextInt((getInt()/3)) + 1;
		other.setHP((other.getHP()) -  damage);
		double regenMana = rand.nextDouble();
		System.out.println(getName() + " lightly toasts " + other.getName() + " for " + damage + " damage!");
		if (regenMana > .5){
		    setMana((getMana()) + 1);
		    System.out.println("By the power of the RNG gods, " + getName() + "'s basic attack has granted " + getName()+" one additional mana point! " + getName() +" now has " + getMana()+ " mana points!");
		}
		else{
		    setMana(getMana()-1);
		    System.out.println(getName() + " now has " + getMana() + " mana");
		}
	    }
	    else{
		System.out.println(getName() + "tries to lightly toast " + other.getName() + " but " + getName() + " has no mana! Instead, ");
		super.attack(other);
		}
	}
	else{
	    System.out.println(getName() + " casts 'Scorch' but misses, dealing 0 damage");
	}
    }
    

public void specialAttack(Adventurer other){
	if(mana > 9){
	    if(super.hit()){
		int damage = rand.nextInt((getInt()/2)) + 1;
		other.setHP(other.getHP()- damage);
		mana = mana - 10;
		System.out.println(getName() + " deep fries " + other.getName() + " for " + damage + " damage");
		System.out.println(getName() + " has " + getMana() + " mana");
	}
	    else{
		System.out.println(getName() + " attempts to cast 'Fire Blast' but misses!");
	    }
	}
	else{
	    System.out.println(getName() + " doesn't have enough  mana to cast 'Fire Blast'! Instead, ");
	    super.attack(other);
	}
}
   


public String getStats(){
    return super.getStats() + " "+ getStr()+"STR " + getInt()+"INT " + getDex()+"DEX " + getMana()+"Mana " + "Wizard";
}

}
