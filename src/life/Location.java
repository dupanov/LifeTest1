package life;

/**
 * Created by Вадик on 24.11.2015.
 */
public class Location {
    private int x;
    private int y;

    public Location(){};

    public Location(int col, int raw){
        this.x = col;
        this.y = raw;
    }


    public boolean isValid(){
        return (x>=0 & x <LifeRunner.getSize()) & (y>=0 & y <LifeRunner.getSize());
    }
    public boolean equals (Location loc){
        return this.getx() == loc.x && this.gety() == loc.y;
    }

    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }

    public void setx(int col){
        x = col;
    }
    public void sety(int raw){
        y = raw;
    }

}
