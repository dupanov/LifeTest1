package life;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ����� on 24.11.2015.
 */
public class Location {
    int x;
    int y;

    protected int hashLocation(){
        int hash=0;
        hash = this.x*1000 + y;
        return hash;
    }

    public boolean isValid(){
        return (x>=0 & x <LifeRunner.getSize()) & (y>=0 & y <LifeRunner.getSize());
    }

}
