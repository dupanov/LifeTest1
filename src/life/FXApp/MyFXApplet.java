package life.FXApp;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import life.LifeRunner;
import life.ViewConsrtuctor;


public class MyFXApplet extends FXApplet {
    // protected fields scene & root are available
    public Slider speedSlider;
    public Label label;
    public JFXPanel fxPanel;

    @Override
    public void initApplet(JFXPanel fxPanel) {
        // this method is called once applet has been loaded & JavaFX has been set-up
        LifeRunner life = new LifeRunner();
        ViewConsrtuctor view = new ViewConsrtuctor(fxPanel, life);
        life.setRunningState(true);
        //view.getScene().
        view.getPanel().show(true);

    }
}