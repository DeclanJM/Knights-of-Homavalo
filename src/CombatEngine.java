
public class CombatEngine {
    
    private final GameData data;
    private final GameView view;

    public CombatEngine(GameData data, GameView view){
    this.data = data;
    this.view = view;
    }

    public void runCombat(){}               //OPTIONAL METHOD

    public void initialize(){
        for(Knight kn : data.getActiveKnights()){
            kn.setActiveFortune(data.getRandomFortune());
        }
        view.printFortunes(data.getActiveKnights());
    }

    public void clear(){    //Sets all fortunes to *null* across all knights
        for(Knight kn : data.getKnights()){
            kn.setActiveFortune(null);
        }
    }
}