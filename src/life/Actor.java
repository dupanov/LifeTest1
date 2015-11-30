package life;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import java.awt.event.MouseEvent;


/**
 * Created by ����� on 24.11.2015.
 */
public class Actor extends AbstractActor {

public Actor(){
    super();
}


    public Actor(int i, int j){
        super(i, j);
    }

    @Override
    public Actor getActor(Location loc){
        return (Actor) super.getActor(loc);
    }

    public void move(){
        super.move();
    }


}