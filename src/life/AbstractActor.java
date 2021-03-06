package life;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Iterator;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;


/**
 * Created by ����� on 28.11.2015.
 */
public abstract class AbstractActor {

    final private int actorSize = 40;
    private Image lifeImage;
    private ImageView pic = new ImageView();
    private ArrayList<Actor> actorArrayList;
    private boolean doChange;
    private boolean alive;
    private Location location;
    private int life_size;


    public AbstractActor(int i, int j, int life_size) {
        lifeImage = new Image(getClass().getResourceAsStream("life.png"));
        this.life_size = life_size;
        location = new Location(i, j, life_size);
        pic.setFitWidth(100);
        pic.setPreserveRatio(true);
        pic.setSmooth(true);
        pic.setCache(true);
        pic.setImage(lifeImage);
        pic.setFitWidth(actorSize);
        pic.setFitHeight(actorSize);
        pic.setImage(lifeImage);
        pic.setRotate(getAngle());
        pic.setPickOnBounds(true);
        pic.addEventHandler(MOUSE_CLICKED, event -> {
            if (!isAlive()) {
                setAlive();
            } else {
                setDead();
            }

        });
        setDead();
    }

    public int getAngle() {
        int rand = (int) (360 * Math.random());
        if (rand >= 0 && rand < 45) return 0;
        if (rand >= 45 && rand < 135) return 90;
        if (rand >= 135 && rand < 225) return 180;
        if (rand >= 225 && rand < 315) return 270;
        if (rand >= 315 && rand <= 360) return 0;
        return 0;
    }

    public boolean isAlive() {
        if (getPic().getOpacity() == 1.0) {
            return true;
        } else {
            return false;
        }
    }

    public void setAlive() {
        if (!isAlive())
            getPic().setOpacity(1.0);
    }

    public void setDead() {
        if (isAlive())
            getPic().setOpacity(0.0);
    }

    public ImageView getPic() {
        return this.pic;
    }

    public void move() {
        int neighbours = 0;
        if (!doChange) {
            neighbours = countNeighbors();
            if (!isAlive() && neighbours == 3) {
                setAlive();
            } else if (isAlive() && !(neighbours == 2 || neighbours == 3)) {
                setDead();
            }
        }
        if (doChange) {
            if (isAlive()) {
                setAlive();
            } else if (!alive) {
                setDead();
            }
        }
    }

    public boolean getDoChange() {
        return doChange;
    }

    public void setDoChange(boolean val) {
        doChange = val;
    }

    private int countNeighbors() {
        int counter = 0;
        int dx = location.getx();
        int dy = location.gety();
        int j = dy - 1;
        try {
            while (j < dy + 2) {
                int i = dx - 1;

                while (i < dx + 2) {
                    Location loc = new Location();
                    loc.setx(i);
                    loc.sety(j);
                    if (loc.isValid() && !location.equals(loc)) {
                        if (getActor(loc).isAlive()) {
                            counter++;
                        }
                    }
                    i++;
                }
                j++;
            }
        } catch (NullPointerException e) {
            System.out.println("exeption " + location.getx() + " " + location.gety() + " " + counter);
            e.printStackTrace();
        } finally {
            return counter;
        }
    }


    public AbstractActor getActor(Location loc) {
        Iterator it = actorArrayList.iterator();
        while (it.hasNext()) {
            AbstractActor abstractActor = (AbstractActor) it.next();
            if (abstractActor.location.equals(loc)) {
                return abstractActor;
            }
        }
        return null;
    }
}









