package life.FXApp;

import javafx.scene.control.Slider;

/**
 * Created by Вадик on 01.02.2016.
 */
public class MySpeedSlider extends Slider implements MySlider {
    public Slider speedSlider;

    public MySpeedSlider() {
        speedSlider = new Slider();
    }

    public MySpeedSlider(int min, int max) {
        speedSlider = new Slider();
        this.setSliderVal(min, max);
    }


    public void setSliderVal(int min, int max) {
        speedSlider = new Slider();
        speedSlider.setMin(min);
        speedSlider.setMax(max);
        speedSlider.setValue((max - min) / 2);
        speedSlider.setBlockIncrement((max - min) / 100);

    }


    public int getSliderVal() {
        return (int) speedSlider.getValue();
    }
}
