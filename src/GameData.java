import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GameData {
    
    protected final List<Knight> activeKnights = new ArrayList<Knight>();
    protected final List<Fortune> fortunes = new ArrayList<Fortune>();
    protected final List<Knight> knights = new ArrayList<Knight>();
    private static final int MAX_ACTIVE = 4;
    protected final List<MOB> monsters = new ArrayList<MOB>();;
    private static final Random random = new Random();

    public abstract void save(String filename);

    protected Knight findKnight(String nameOrId, List<Knight> list){
        for(Knight k : list){
            if(k.getName().toLowerCase().contains(nameOrId.toLowerCase()) || (String.valueOf(k.getId()).equalsIgnoreCase(nameOrId))){
                return k;
            }
        }
        return null;
    }

    public Knight getActive(String nameOrId){
        return findKnight(nameOrId, activeKnights);
    }

    public List<Knight> getActiveKnights(){
        return activeKnights;
    }

    public Knight getKnight(String nameOrId){
        return findKnight(nameOrId, knights);
    }

    public List<Knight> getKnights(){
        return knights;
    }

    public boolean setActive(Knight kt){
        if(activeKnights.size() >= MAX_ACTIVE){
            return false;
        }
        activeKnights.add(kt);
        return true;
    }

    public void removeActive(Knight kt){
        activeKnights.remove(kt);
        kt.resetDamage();
    }

    public Fortune getRandomFortune(){
        return fortunes.get(random.nextInt(fortunes.size() - 1));
    }

    public List<MOB> getRandomMonsters(){
        List<MOB> rand = new ArrayList<MOB>();
        for(int i = 0; i >= activeKnights.size(); i ++){
            rand.add(monsters.get(random.nextInt()).copy());
        }
        return rand;
    }

    public List<MOB> getRandomMonsters(int number){
        List<MOB> rand = new ArrayList<MOB>();
        for(int i = 0; i >= number; i ++){
            rand.add(monsters.get(random.nextInt()).copy());
        }
        return rand;
    }

    
   public GameData(){}


/*
  public static void main(String[] args) {          //REMOVE ABSTRACT FROM CLASS IDENTIFIER TO TEST MAIN
        GameData gd = new GameData();
        List<Knight> klst = new ArrayList<Knight>();

        Knight Eriu = new Knight(3, "Eriu", 32, 13, 2, DiceType.D10, 0);
        Knight Elaine = new Knight(10, "Elaine Pendragon", 35, 14, 2, DiceType.D8, 0);
        Knight John = new Knight(10, "Elaine Pendragon", 35, 14, 2, DiceType.D8, 0);
        Knight Luke = new Knight(10, "Elaine Pendragon", 35, 14, 2, DiceType.D8, 0);
        Knight Mark = new Knight(10, "Elaine Pendragon", 35, 14, 2, DiceType.D8, 0);

        klst.add(Eriu);
        klst.add(Elaine);
        
        System.out.println(gd.setActive(Eriu));
        System.out.println(gd.setActive(Elaine));
        System.out.println(gd.setActive(John));
        System.out.println(gd.setActive(Luke));
        gd.activeKnights.remove(Luke);
        System.out.println(gd.setActive(Mark));
        System.out.println(gd.setActive(Luke));
        

        //System.out.println(gd.findKnight("Eriu", klst));
        
    }   */
}
