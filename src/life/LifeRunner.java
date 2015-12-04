package life;

import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ????? on 24.11.2015.
 */
public class LifeRunner {
    static private int size = 3;
    static private boolean runningState = false;
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


    public static void runner(boolean val){
        setRunningState(val);
      //  while(getRunningState()){
            Iterator it = actorArrayList.iterator();
            while(it.hasNext()){
                Actor act = (Actor)it.next();
                AbstractActor.doChange = false;
                act.move();
                System.out.println("runner "+act.getx() + " "+ act.gety() );
            }
        it = actorArrayList.iterator();
        while(it.hasNext()){
            Actor act = (Actor)it.next();
            AbstractActor.doChange = true;
            act.move();
            System.out.println("runner "+ act.getx() + " "+ act.gety() );
        }

       // }
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

    public static void main(String[] args) {
        setRunningState(true);
        Main.main(args);
    }
}
