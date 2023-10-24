import interfaces.Attributes;
import interfaces.DiceType;

public class MOB implements Attributes{

    protected int armor; 
    protected int damage; 
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private final String name;


    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie){
        this.name = name;
        this.maxHP = hp;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;
    }


    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName(){
        return name;
    }

    public int getHP(){
        return getMaxHP()  - damage; 
    }

    public int getDamage(){
        return damage;
    }


    public void addDamage(int damage){
        this.damage += damage;
    }

    public void resetDamage(){
        this.damage = 0;
    }
    public MOB copy(){
        return new MOB(getName(), getHP(), getArmor(), getHitModifier(), getDamageDie());
    }

    
    public String toString(){
        String card;
        card = "+============================+\n";
        card += String.format("| %-27s|%n", getName());
        card += "|                            |\n";
        card += String.format("|         Health: %-10d |\n", getHP());
        card += String.format("|  Power: %-6s  Armor: %-4d|\n", getDamageDie().toString(), getArmor());
        card += "|                            |\n";
        card += "+============================+";
        return card;
    }

public static void main(String[] args) {
    Knight Eriu = new Knight(3, "Eriu", 32, 13, 2, DiceType.D10, 0);
    Fortune ftn = new Fortune("Merlin's Luck", 2, 5, 2, DiceType.D6);
    System.out.println(Eriu.toString());
    Eriu.setActiveFortune(ftn);
    System.out.println(Eriu.getActiveFortune());
    System.out.println(Eriu.toString());
    Eriu.damage += 17;
    Eriu.xp += 40;
    System.out.println(Eriu.toString());

}

/*
    public static void main(String args[]){
        MOB ben = new MOB("BEN", 100, 50, 5, DiceType.D10);
        System.out.println(ben.toString());
        MOB fakeBen = ben.copy();
        System.out.print(fakeBen.toString());
    }
*/
}
