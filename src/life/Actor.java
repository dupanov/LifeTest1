package life;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.event.ActionListener;
import java.util.EventListener;

import static sun.text.normalizer.UTF16.append;


/**
 * Created by Вадик on 24.11.2015.
 */
public class Actor implements ActionListener {
    Image lifeImage;
    ImageView pic = new ImageView();
    Rectangle rectangle = new Rectangle();
    private Actor onClick;


    public Actor(){
        lifeImage = new Image(getClass().getResourceAsStream("life.png"));
        pic.setImage(lifeImage);
        pic.setFitWidth(30);
        pic.setFitHeight(30);
        pic.setSmooth(true);
        rectangle.setHeight(10);
        rectangle.setWidth(10);rectangle.setFill(Color.AQUAMARINE);
        setOnClick(this);
    }



    public boolean isAlive(){
        if(this.getPic().isVisible()){
        return true;
        }
        return false;
    }

    public void setAlive(Location loc){
        if(!isAlive()) this.getPic().setVisible(true);
    }

    public void setDead(){
        if(isAlive()) this.getPic().setVisible(false);
    }

    public ImageView getPic(){
        return this.pic;
    }

    public void actionPerformed(ActionEvent e) {
        append(e.getActionCommand() + newline);

    public void addActionListener(Main main) {
    }

    public void setOnClick(Actor onClick) {
        this.onClick = onClick;
    }
}
