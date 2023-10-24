import java.io.IOException;

public class Main {
    
    private static String gamedata = "gamedata.csv";
    private static String saveData = "knights.csv";

    public Main(){}
    public static void main(String[] args) throws IOException{

    GameData data = new CSVGameData(gamedata, saveData);
    GameView view  = new ConsoleView();
    CombatEngine engine = new CombatEngine(data, view);
    GameController controller = new GameController(data, view, engine);
    controller.start();
    }
}
