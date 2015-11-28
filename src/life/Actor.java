package life;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.event.ActionListener;
import java.util.EventListener;

import static sun.text.normalizer.UTF16.append;


/**
 * Created by Вадик on 24.11.2015.
 */
public class Actor extends Node {
    Image lifeImage;
    ImageView pic = new ImageView();
    Rectangle rectangle = new Rectangle();

    final static public int actorSize = 30;


    public Actor(){
        lifeImage = new Image(getClass().getResourceAsStream("life.png"));
        pic.setImage(lifeImage);
        pic.setFitWidth(actorSize);
        pic.setFitHeight(actorSize);
        pic.setSmooth(true);

    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Override
    protected NGNode impl_createPeer() {
        return null;
    }



    /**
     * Computes the geometric bounds for this Node. This method is abstract
     * and must be implemented by each Node subclass.
     *
     * @param bounds
     * @param tx
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        return null;
    }

    /**
     * @param localX
     * @param localY
     * K@treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        return false;
    }

    /**
     * This method is used by Scene-graph JMX bean to obtain the Scene-graph structure.
     *
     * @param alg current algorithm to process this node
     * @param ctx current contextK
     * @return the algorithm specific result for this node
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Override
    public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return null;
    }


    public boolean isAlive(){
        return this.getPic().isVisible();
    }

    public void setAlive(){
        if(!isAlive()) this.getPic().setVisible(true);
    }

    public void setDead(){
        if(isAlive()) this.getPic().setVisible(false);
    }

    public ImageView getPic(){
        return this.pic;
    }


  /*  public void onClick (EventHandler e){
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                GridPane.getRowIndex(getPic());
                GridPane.getColumnIndex(getPic());
                if(isAlive()){
                    setDead();
                } else {
                    setAlive();
                }
            }

    }*/
    }