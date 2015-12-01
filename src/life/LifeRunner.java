package life;

import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ????? on 24.11.2015.
 */
public class LifeRunner {
    static private int size = 50;
    static private int[][] field = new int[size][size];
    static private boolean runningState = false;


    private static LifeRunner life = new LifeRunner();
    private static ArrayList<Actor> actorArrayList = new ArrayList<>();


    public ArrayList<Actor> getActorArrayList(){
        return this.actorArrayList;
    }

    public static void setActorArrayList(GridPane grid) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < LifeRunner.getSize(); j++) {
                Actor actor = new Actor(i, j);
                life.getActorArrayList().add(i + j, actor);
                grid.add(actor.getPic(), i, j);
            }
        }
    }

    public static void runner(){
        while(getRunningState()){
            System.out.println("2" + getRunningState());
            Iterator it = actorArrayList.iterator();
            while(it.hasNext()){
                System.out.println("3");
                Actor act = (Actor)it.next();
                act.move();
            }
        }
    }


    public static void runner(boolean val){
        setRunningState(val);
        while(getRunningState()){
            System.out.println("2" + getRunningState());
            Iterator it = actorArrayList.iterator();
            while(it.hasNext()){
                System.out.println("3");
                Actor act = (Actor)it.next();
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

    public static void main(String[] args) {
        setRunningState(true);
        Main.main(args);
    }
}
