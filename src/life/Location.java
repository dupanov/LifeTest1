package life;

/**
 * Created by ����� on 24.11.2015.
 */
public class Location {
    private int life_size;
    private int x;
    private int y;

    public Location() {
    }

    ;

    public Location(int col, int raw, int life_size) {
        this.x = col;
        this.y = raw;
        this.life_size = life_size;
    }


    public boolean isValid() {
        return (x >= 0 & x < life_size) & (y >= 0 & y < life_size);
    }

    public boolean equals(Location loc) {
        return this.getx() == loc.x && this.gety() == loc.y;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void setx(int col) {
        x = col;
    }

    public void sety(int raw) {
        y = raw;
    }

}
