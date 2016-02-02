package life;

import javafx.scene.layout.GridPane;
import life.FXApp.MySpeedSlider;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by ????? on 24.11.2015.
 */
public class LifeRunner extends Thread {
    private int FIELD_SIZE;
    private boolean runningState;
    private ArrayList<Actor> actorArrayList;
    private int aliveCounter;
    private MySpeedSlider mySpeedSlider;
    private Thread trd2;

    public LifeRunner(){
        actorArrayList = new ArrayList<>();
        mySpeedSlider = new MySpeedSlider();
        FIELD_SIZE = 20;
        runningState = false;

    }

    public ArrayList<Actor> getActorArrayList() {
        return actorArrayList;
    }

    public void setActorArrayList(GridPane grid) {
        for (int j = 0; j < FIELD_SIZE; j++) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                Actor actor = new Actor(i, j, FIELD_SIZE);
                actorArrayList.add(i + j, actor);
                grid.add(actor.getPic(), i, j);
            }
        }
    }


    public void runner(boolean val) {
        trd2 = new Thread(() -> {
            Iterator it = actorArrayList.iterator();
            while (it.hasNext()) {
                Actor act = (Actor) it.next();
                act.setDoChange(false);
                act.move();
                act.setDoChange(true);
                act.move();
            }
            try {
                currentThread().sleep(mySpeedSlider.getSliderVal());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        trd2.start();


        //       if(aliveCounter==0) {
        //           setRunningState(false);
        //           Main.setLabelText((Label)Main.getLabel());
        //       }

    }

    public int liveActorsCount() {
        aliveCounter = 0;
        Iterator it = actorArrayList.iterator();
        while (it.hasNext()) {
            Actor act = (Actor) it.next();
            if (act.isAlive()) ++aliveCounter;
        }
        return aliveCounter;
    }

    public void setFIELD_SIZE(int sz) {
        FIELD_SIZE = sz;
    }


    public boolean getRunningState() {
        return runningState;
    }

    public void setRunningState(boolean val) {
        runningState = val;
    }

}
