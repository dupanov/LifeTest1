package life;

import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Iterator;



/**
 * Created by ????? on 24.11.2015.
 */
public class LifeRunner extends Thread  {
    private static int size = 20;
    private static boolean runningState = false;
    private static ArrayList<Actor> actorArrayList = new ArrayList<>();


    public ArrayList<Actor> getActorArrayList(){
        return this.actorArrayList;
    }

    public static void setActorArrayList(GridPane grid) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                Actor actor = new Actor(i, j);
                actorArrayList.add(i + j, actor);
                grid.add(actor.getPic(), i, j);
            }
        }
    }


    public static void runner(boolean val)  {
        setRunningState(val);
        while(getRunningState()){
            try {
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Main.stage.wait(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator it = actorArrayList.iterator();
            while(it.hasNext()){
                Actor act = (Actor)it.next();
                AbstractActor.setDoChange(false);
                act.move();
            }
        it = actorArrayList.iterator();
        while(it.hasNext()){
            Actor act = (Actor)it.next();
            AbstractActor.setDoChange(true);
            act.move();
        }

        }
    }



    public static int getSize(){
        return size;
    }

    public static void setSize(int sz){
        size = sz;
    }


    public static boolean getRunningState(){
        return runningState;
    }

    public static void setRunningState(boolean val){
        runningState = val;
    }



}
