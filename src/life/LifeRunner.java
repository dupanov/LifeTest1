package life;

import javafx.scene.control.Label;
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
    private int aliveCounter;


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


    public void runner(boolean val) {
        Thread trd2 = new Thread(() -> {
            setRunningState(val);
             while(getRunningState()) {
                 Iterator it = actorArrayList.iterator();
                 while (it.hasNext()) {
                     Actor act = (Actor) it.next();
                     AbstractActor.setDoChange(false);
                     act.move();
                     AbstractActor.setDoChange(true);
                     act.move();

                 }

                 try {
                     currentThread().sleep(Main.getSpeedSliderValue());
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

        });
        trd2.start();
        //if(aliveCounter==0) {
        //    setRunningState(false);
        //    Main.setLabelText((Label)Main.getLabel());
        //}

    }

    public int liveActorsCount(){
        aliveCounter =0;
        Iterator it = actorArrayList.iterator();
        while (it.hasNext()) {
            Actor act = (Actor) it.next();
            if(act.isAlive()) ++aliveCounter;
        }
        return aliveCounter;
    }

    public static int getSize(){
        return size;
    }

    public static void setSize(int sz){
        size = sz;
    }


    public boolean getRunningState(){
        return runningState;
    }

    public void setRunningState(boolean val){
        runningState = val;
    }

}
