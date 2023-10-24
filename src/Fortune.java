import interfaces.Attributes;
import interfaces.DiceType;

public class Fortune implements Attributes{

    private final int armor;
    private final DiceType type;
    private final int hitModifier;
    private final int hpBonus;
    private final String name;
    
    
    public Fortune(String name, int hpBonus, int armor, int hitModifier){
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type){
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.type = type;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        return type;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        String card;
        card = "+======================+\n";
        card += String.format("|%-22s|\n", name);
        card += String.format("|HP Bonus: %12s|\n", (getMaxHP() > 0 ?"+" + getMaxHP() : getMaxHP()));
        card += String.format("|AC Bonus: %12s|\n", (getArmor() > 0 ?"+" + getArmor() : getArmor()));
        card += String.format("|Hit Bonus: %11s|\n", (getHitModifier() > 0 ?"+" + getHitModifier() : getHitModifier()));
        card += String.format("|Damage Adj: %10s|\n", getDamageDie() != null ?getDamageDie() : "-");
        card += "+======================+\n";
        return card;
    }
    /*
    public static void main(String[] args){
        Fortune ftn = new Fortune("Merlin's Luck", 1, 5, 2);
        Fortune ftn2 = new Fortune("Dumbledoorknob", -4, 9, 1, DiceType.D20);
        System.out.println("TESTING Armor in Fortune:  " + ftn.getArmor());
        System.out.println(ftn.toString());
        System.out.println(ftn2.toString());
    }
*/
}
