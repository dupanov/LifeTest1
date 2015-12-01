package life;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Iterator;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;


/**
 * Created by Вадик on 28.11.2015.
 */
public abstract class AbstractActor  {


    private Image lifeImage;
    private ImageView pic = new ImageView();
    Location actorLocation = new Location();
    static private int fieldSize;
    private int x;
    private int y;
    static ArrayList<Actor> actorArrayList;
    private boolean doChange = false;
    private boolean alive = false;


    final static private int actorSize = 30;

    public AbstractActor() {
        lifeImage = new Image(getClass().getResourceAsStream("life.png"));
        pic.setFitWidth(100);
        pic.setPreserveRatio(true);
        pic.setSmooth(true);
        pic.setCache(true);
        pic.setImage(lifeImage);
        pic.setFitWidth(actorSize);
        pic.setFitHeight(actorSize);
        pic.setImage(lifeImage);
        Rectangle2D viewportRect = new Rectangle2D(40,35,110,110);
        pic.setViewport(viewportRect);
        pic.setRotate(360*Math.random());
        pic.setPickOnBounds(true);
        pic.addEventHandler(MOUSE_CLICKED, event -> {
            event.consume();
            if (!isAlive()) {
                setAlive();
            } else {
                setDead();
            }
        });
        setDead();
    }

    public AbstractActor(int i, int j) {
        lifeImage = new Image(getClass().getResourceAsStream("life.png"));
        actorLocation.x = i;
        actorLocation.y = j;
        pic.setFitWidth(100);
        pic.setPreserveRatio(true);
        pic.setSmooth(true);
        pic.setCache(true);
        pic.setImage(lifeImage);
        pic.setFitWidth(actorSize);
        pic.setFitHeight(actorSize);
        pic.setImage(lifeImage);
        Rectangle2D viewportRect = new Rectangle2D(40,35,110,110);
        pic.setViewport(viewportRect);
        pic.setRotate(360*Math.random());
        pic.setPickOnBounds(true);
        pic.addEventHandler(MOUSE_CLICKED, event -> {
            event.consume();
            if (!isAlive()) {
                setAlive();
            } else {
                setDead();
            }
        });
        setDead();
    }




    public boolean isAlive() {
        if(getPic().getOpacity()==1.0 ){
        return true;} else {return false;}
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


    public void move(){
        if(!doChange){
        if(countNeighbors()==2 || countNeighbors()==3){
            alive = true;
        } else {alive  = false;}
        }
        if(doChange){
            if(alive){
                setAlive();}
            else if(!alive){
                setDead();
            }
            doChange = false;
        }
    }


    private int countNeighbors()  {
        int counter = 0;
        int x=getx();
        int y = gety();
        int i, j;
        if(x>1) i=x-1; else i=0;
        if(y>1) j=y-1; else j=0;
        try{
        for(;i<x+2;i++){
            for(;j<y+2;j++){
                Location loc = new Location();
                loc.x = i;
                loc.y = j;
                if(getActor(loc).isAlive()){
                    counter++;
                }
            }
        }
        }catch(NullPointerException e){
            System.out.println("exeption" + x + " " + y + " " + counter);

        }
        return counter;
    }



    private Location getActorLocation(){
        actorLocation.x = getx();
        actorLocation.y = gety();
        return this.actorLocation;
    }

    public void setx(int i){
        this.x = i;
    }

    public void sety (int i){
        this.y = i;
    }

    public int getx(){
        return  this.x;
    }

    public int gety (){
        return this.y;
    }

    public AbstractActor getActor (Location loc){
        Iterator it = actorArrayList.iterator();
        while (it.hasNext()){
            AbstractActor abstractActor = (AbstractActor) it.next();
            if(abstractActor.getActorLocation().equals(loc)){
                return abstractActor;
            }

        }
        return null;
    }

}









