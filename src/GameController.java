public class GameController{
    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;


public GameController(GameData data, GameView view, CombatEngine engine){
    this.data = data;
    this.view = view; 
    this.engine = engine;
}

protected boolean processCommand(String command){
    if(command.contains("exit") || command.contains("bye")){
        return false;
    }
    else{
        if(command.contains("ls") || command.contains("list all")){
            view.listKnights(data.getKnights());
        }
        else if(command.contains("list active")){
            view.listKnights(data.getActiveKnights());
        }
        else if(command.startsWith("show")){
            processShowKnight(command.substring(command.indexOf("show") + 4).trim());
        }
        else if(command.startsWith("set active")){
            processSetActive(command.substring(command.indexOf("active") + 6).trim());
        }
        else if(command.startsWith("remove")){
            processRemoveActive(command.substring(command.indexOf("remove") + 6).trim());
        }
        else if(command.startsWith("save")){
            String filename = "savedata.csv";
            String tmp = command.substring(command.indexOf("save") + 4).trim();
            if(!tmp.isEmpty()){
                filename = tmp;
            }
            data.save(filename);
        }
        else if(command.contains("explore") || command.contains("adventure") || command.contains("quest")){
            engine.initialize();
            engine.runCombat();
            engine.clear();
     }
        else{
          view.printHelp();
        }
        return true;
        }
    }


public void start(){
    view.splashScreen();
    while(processCommand(view.displayMainMenu().toLowerCase().trim()));
    view.endGame();
}
   
private void processSetActive(String active){
    Knight kn = data.getKnight(active);
    if(kn == null){
        view.knightNotFound();   
    }
    if(data.setActive(kn) == false){
        view.setActiveFailed();
        }
    }

private void processRemoveActive(String remove){
    Knight k = data.getActive(remove);
    if(k == null){
        view.knightNotFound();
        return;
    }
    data.removeActive(k);
}

private void processShowKnight(String nameOrId){
    Knight kn = data.getKnight(nameOrId);
    if(kn != null){
        view.showKnight(kn);
    }
    else{
        view.knightNotFound();
        }
    }
}