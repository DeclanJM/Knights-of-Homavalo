import interfaces.DiceType;

public class Knight extends MOB{

    private Fortune activeFortune;
    protected int xp;
    protected final int id;


    Knight(int id, String name, int hp, int armor, int hitmodifier, DiceType damageDie, int xp){
        super(name, hp, armor, hitmodifier, damageDie);
        this.id = id;
        this.xp = xp;
    }


    public void setActiveFortune(Fortune activeFortune){
        this.activeFortune = activeFortune;
    }

    public Fortune getActiveFortune(){
        return activeFortune;
    }


    public int getXP() {
        return xp;
    }

    public void addXP(int xp){
        this.xp += xp;
    }

    public int getId() {
        return id;
    }

    public int getArmor(){
        int arm = super.getArmor(); 
        try{       
            int fort = getActiveFortune().getArmor();
            return arm + fort;
        }catch(NullPointerException ex){
            //System.out.println("Null Pointer Exception: " + ex);
            return arm;
        }
    }

    public int getHitModifier(){
        int hit = super.getHitModifier();
        try{
            int fort = getActiveFortune().getHitModifier();
            return hit + fort;
        }catch(NullPointerException ex){
            //System.out.println("Null Pointer Exception: " + ex);
            return hit;
        }
    }

    public DiceType getDamageDie(){
        DiceType dam = super.getDamageDie();
        try{
            return getActiveFortune().getDamageDie();
        }catch(NullPointerException ex){
            //System.out.println("Null Pointer Exception: " + ex);
            return dam;
        }
    }

    public int getMaxHP(){
        int max = super.getMaxHP();
        try{
            int fort = getActiveFortune().getMaxHP();
            //System.out.println(fort);
            return max + fort;
        }catch(NullPointerException ex){
            //System.out.println("Null Pointer Exception: " + ex);
            return max;
        }
    }


    public String toCSV(){
        return String.format("%s,%d,%d,%s,%d", getName(), getMaxHP(), getHitModifier(), getDamageDie(), getXP());
    }

    public String toString(){
        String card = "";
        card += "+============================+\n";
        card += String.format("| %-27s|\n", getName());
        card += String.format("| id: %-23d|\n", getId());
        card += String.format("|%-28s|\n", "");
        card += String.format("| Health: %-6d XP: %-8d|\n", getHP(), getXP());
        card += String.format("|  Power: %-6s Armor: %-5d|\n", getDamageDie(), getArmor());
        card += String.format("|%-28s|\n", "");
        card += "+============================+\n";
        return card;
    }

    public static void main(String args[]){
    Knight Elaine = new Knight(10, "Elaine Pendragon", 35, 14, 2, DiceType.D8, 0);
    System.out.println("TESTING Elaine.toString()\n" + Elaine.toString());

    Knight Eriu = new Knight(3, "Eriu", 32, 13, 2, DiceType.D10, 0);
    Fortune ftn = new Fortune("Merlin's Duck", 2, 5, 2, DiceType.D6);
    System.out.println(Eriu.toString());
    Eriu.setActiveFortune(ftn);
    System.out.println(Eriu.getActiveFortune());
    //System.out.println(Eriu.toString());
   
    
    //System.out.println("TESTING Eriu.toCSV():  " + Eriu.toCSV());

    }

}
