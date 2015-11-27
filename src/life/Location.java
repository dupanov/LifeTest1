package life;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадик on 24.11.2015.
 */
public class Location {
    int x;
    int y;
    Actor actor;

    public ArrayList getNeighbors(){
        ArrayList a = new ArrayList();
        return a;
    }

    public int countAliveNeighbors(){
        int count = 0;
        return count;
    }

    protected int hashLocation(){
        int hash=0;
        hash = this.x*1000 + y;
        return hash;
    }

    private Actor getActor(Location loc){

        return this.actor;
    }

    public void setActor(Actor act){
        actor = act;
    }

}
